package net.hus.core.client.model.admin;

import net.hus.core.client.model.admin.ComponentDisplay.Action;
import net.hus.core.client.ui.common.Global;
import net.hus.core.client.ui.common.RpcCallback;
import net.hus.core.client.ui.event.AdminEvent;
import net.hus.core.shared.command.AdminDataCommand;
import net.hus.core.shared.command.LookupXLSaveCommand;
import net.hus.core.shared.model.AdminData;
import net.hus.core.shared.model.Components;
import net.hus.core.shared.model.EventType;
import net.hus.core.shared.model.FieldTKG;
import net.hus.core.shared.model.Fields;
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
        mDisplay.addTables(inData.getTables());
        mDisplay.addFieldGroups(inData.getFieldGroups());
        mDisplay.addPages(inData.getPages());
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
    mFields = inData.getFieldGroup();
    mDisplay.addPage(mPage);
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
    tkg.setPage(EnumUtil.valueOf(inPage, Page.Name.values()));

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
    tkg.setPage(EnumUtil.valueOf(inPage, Page.Name.values()));

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
    UIObject_ uiObject = mPage.get(inNodeId);
    Page.Name page = mPage.getFieldTKG().getPage();
    mDisplay.addComponent(mDisplay.getDisplay(uiObject, mFields, child, page));
  }
}