package net.hus.core.client.model.admin;

import net.hus.core.client.model.admin.ComponentDisplay.Action;
import net.hus.core.client.ui.common.Global;
import net.hus.core.client.ui.common.RpcCallback;
import net.hus.core.client.ui.event.AdminEvent;
import net.hus.core.shared.command.AdminDataCommand;
import net.hus.core.shared.command.LookupXLSaveCommand;
import net.hus.core.shared.components.Ui_Create;
import net.hus.core.shared.model.AdminData;
import net.hus.core.shared.model.Components;
import net.hus.core.shared.model.EventType;
import net.hus.core.shared.model.FieldTKG;
import net.hus.core.shared.model.Fields;
import net.hus.core.shared.model.HasCollection;
import net.hus.core.shared.model.Page;
import net.hus.core.shared.model.UIObject_;
import net.hus.core.shared.util.EnumUtil;
import net.hus.core.shared.util.RandomUtil;

public class ComponentPresenter extends RpcCallback<AdminDataCommand>
implements Action, AdminEvent.Handler
{
  private ComponentDisplay mDisplay;
  private Components mPage;
  private Fields mFields;
  private int mNodeId = -1;

  public ComponentPresenter(ComponentDisplay inDisplay)
  {
    Global.addHandler(AdminEvent.TYPE, this);
    mDisplay = inDisplay;
    mDisplay.setAction(this);
  }

  @Override
  public void dispatch(AdminEvent inEvent)
  {
    process(inEvent.getType(), inEvent.getData());
  }

  @Override
  public void onRpcSuccess(AdminDataCommand inCommand)
  {
    process(inCommand.getType(), inCommand.getData());
  }

  private void process(EventType inType, AdminData inData)
  {
    switch (inType)
    {
      case ALL:
      {
        mDisplay.reset();
        mDisplay.addTables(inData.getFggs());
        mDisplay.addFieldGroups(inData.getFggs());
        mDisplay.addPages(inData.getPages());
        mDisplay.addComponents(inData.getComponents());
        break;
      }
      case PAGE:
        addPage(inData);
        break;
      default:
        break;
    }
  }

  private void addPage(AdminData inData)
  {
    mPage = inData.getPage();
    mFields = inData.getFgg();
    mDisplay.addPage(mPage);
    mDisplay.showAdd(mPage.getList().isEmpty());
    mDisplay.showDetail(mPage.getList().isEmpty());
    mDisplay.showAddTo(!mPage.getList().isEmpty());
  }

  @Override
  public void selectPage(String inName)
  {
    Global.fire(new AdminDataCommand(inName, EventType.PAGE), this);
  }

  @Override
  public void createPage(final String inName, String inFvt, String inFgg, String inPage)
  {
    Components c = new Components();
    c.setName(RandomUtil.authCode(8));
    c.setDisplay(inName);

    FieldTKG tkg = c.initTKG();

    tkg.setFvt(inFvt);
    tkg.setFgg(inFgg);
    tkg.setLayout(EnumUtil.valueOf(inPage, Page.Layout.values()));

    Global.fire(new LookupXLSaveCommand(c), new RpcCallback<LookupXLSaveCommand>()
    {
      @Override
      public void onRpcSuccess(LookupXLSaveCommand inCommand)
      {
        mDisplay.notify("Saved ... " + inName);
      }
    });
  }

  @Override
  public void savePage()
  {
    Global.fire(new LookupXLSaveCommand(mPage), new RpcCallback<LookupXLSaveCommand>()
    {
      @Override
      public void onRpcSuccess(LookupXLSaveCommand inCommand)
      {
        mDisplay.notify("Saved ... " + mPage.getDisplay());
      }
    });
  }

  @Override
  public void savePage(String inDisplay)
  {
    mPage.setDisplay(inDisplay);

    Global.fire(new LookupXLSaveCommand(mPage), new RpcCallback<LookupXLSaveCommand>()
    {
      @Override
      public void onRpcSuccess(LookupXLSaveCommand inCommand)
      {
        mDisplay.notify("Saved ... " + mPage.getDisplay());
      }
    });
  }

  @Override
  public void savePage(String inFvt, String inFgg, String inPage)
  {
    FieldTKG tkg = mPage.getFieldTKG();
    tkg.setFvt(inFvt);
    tkg.setFgg(inFgg);
    tkg.setLayout(EnumUtil.valueOf(inPage, Page.Layout.values()));

    Global.fire(new LookupXLSaveCommand(mPage), new RpcCallback<LookupXLSaveCommand>()
    {
      @Override
      public void onRpcSuccess(LookupXLSaveCommand inCommand)
      {
        mDisplay.notify("Saved ... " + mPage.getDisplay());
      }
    });
  }

  @Override
  public void selectComponent(int inNodeId, int inParentId)
  {
    boolean child = inParentId >= 0;
    selectComponent(inNodeId, child);
  }

  private void selectComponent(int inNodeId, boolean inChild)
  {
    mNodeId = inNodeId;
    UIObject_ uiObject = mPage.get(mNodeId);
    Page.Layout page = mPage.getFieldTKG().getLayout();
    mDisplay.addComponent(mDisplay.getDisplay(uiObject, mFields, inChild, page));
    mDisplay.showAdd(uiObject.isAdd());
  }

  @Override
  public void refresh()
  {
    Global.fire(new AdminDataCommand((String) null, EventType.ALL), this);
  }

  @Override
  public void addComponent(Components.Type inComponentType, boolean inRoot)
  {
    if (inRoot)
    {
      UIObject_ child = Ui_Create.create(inComponentType);
      mPage.getList().add(child);
      updateTree("Root", child);
    }
    else
    {
      UIObject_ parent = mPage.get(mNodeId);

      if (parent instanceof HasCollection<?>)
      {
        UIObject_ child = Ui_Create.create(inComponentType);

        String parentName = parent.getSimpleName();

        if (((HasCollection<?>) parent).add(child))
        {
          updateTree(parentName, child);
        }
        else
        {
          String msg = "Can not add '" + child.getSimpleName() + "' to '" + parentName + "'";
          mDisplay.warn(msg);
        }
      }
    }
  }

  private void updateTree(String inParentName, UIObject_ inChild)
  {
    mDisplay.addPage(mPage);
    String msg = "Adding '" + inChild.getSimpleName() + "' to '" + inParentName + "'";
    mDisplay.notify(msg);

    inChild.setKey(RandomUtil.random(5));
    int newNodeId = mPage.get(inChild.getKey());
    inChild.setKey(null);
    selectComponent(newNodeId, true);
  }

  @Override
  public void remove()
  {
    if (mDisplay.confirm("Are you sure you want to remove this component and it's children?"))
    {
      mPage.remove(mPage.get(mNodeId));
      mDisplay.addPage(mPage);
    }
  }

  @Override
  public void refreshComponent()
  {
    // can this just refresh the current component?
    refresh();
  }
}