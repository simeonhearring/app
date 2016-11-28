package net.hus.core.client.ui.admin;

import java.util.List;

import org.gwtbootstrap3.client.ui.Icon;
import org.gwtbootstrap3.client.ui.Input;
import org.gwtbootstrap3.client.ui.ListBox;
import org.gwtbootstrap3.client.ui.gwt.FlowPanel;
import org.gwtbootstrap3.client.ui.html.Paragraph;
import org.gwtbootstrap3.extras.select.client.ui.Option;
import org.gwtbootstrap3.extras.select.client.ui.Select;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.common.Callback;
import net.hus.core.client.common.UIObjectDisplay;
import net.hus.core.client.model.admin.ComponentDisplay;
import net.hus.core.client.ui.common.AbstractView;
import net.hus.core.shared.model.Components;
import net.hus.core.shared.model.Fields;
import net.hus.core.shared.model.Lookup;
import net.hus.core.shared.model.Page;
import net.hus.core.shared.model.UIObject_;

public class ComponentView extends AbstractView implements ComponentDisplay, Callback<Boolean>
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, ComponentView>
  {
  }

  @UiField
  Select mPages;

  @UiField
  Icon mAdd0, mSave0, mSave1;

  @UiField
  Input mAddPage, mDisplay;

  @UiField
  Paragraph mName, mPageNameC, mPageNameF, mPageNameA;

  @UiField
  ListBox mFvt, mFgg, mPageName, mComponents;

  @UiField
  ListBox mAddFvt, mAddFgg, mAddPageName;

  @UiField
  FlowPanel mTree, mDetail;

  private Action mAction;

  public ComponentView()
  {
    initWidget(BINDER.createAndBindUi(this));

    mTree.getElement().setAttribute("id", "tree");
    addEnumToListBox(Page.Layout.values(), mPageName);
    addEnumToListBox(Page.Layout.values(), mAddPageName);
    exportNodeSelected();
    defaultTree();
  }

  @Override
  public void setAction(Action inAction)
  {
    mAction = inAction;
  }

  @UiHandler(
      {
        "mAdd0",
        "mSave0",
        "mSave1",
      })
  public void onClickBind(ClickEvent inEvent)
  {
    if (mAdd0.equals(inEvent.getSource()))
    {
      mAction.createPage(mAddPage.getText(), mAddFvt.getSelectedValue(), mAddFgg.getSelectedValue(),
          mAddPageName.getSelectedValue());
    }
    else if (mSave0.equals(inEvent.getSource()))
    {
      mAction.savePage(mDisplay.getText());
    }
    else if (mSave1.equals(inEvent.getSource()))
    {
      mAction.savePage(mFvt.getSelectedValue(), mFgg.getSelectedValue(),
          mPageName.getSelectedValue());
    }
  }

  @UiHandler(
      {
        "mPages"
      })
  public void onValueChangeBind(ValueChangeEvent<String> inEvent)
  {
    if (mPages.equals(inEvent.getSource()))
    {
      mAction.selectPage(mPages.getSelectedItem().getValue());
    }
  }

  @Override
  public void addPages(List<Lookup> inPages)
  {
    mPages.clear();
    for (Lookup value : inPages)
    {
      Option field = new Option();
      field.setText(value.getDisplay());
      field.setValue(value.getName());
      field.setId(value.getId().toString());
      mPages.add(field);
    }
    mPages.refresh();
    mPages.setValue(null);
  }

  @Override
  public void addPage(Components inPage)
  {
    mName.setText(inPage.getName());
    mDisplay.setText(inPage.getDisplay());
    mPageNameC.setText(inPage.getDisplay());
    mPageNameF.setText(inPage.getDisplay());

    setSelectedIndex(mFvt, inPage.getFieldTKG().getFvt());
    setSelectedIndex(mFgg, inPage.getFieldTKG().getFgg());
    setSelectedIndex(mPageName, inPage.getFieldTKG().getLayout());

    // should not call first time. maybe have default.
    removeTree();

    addTree(inPage.toJson());

    resetComponent();
  }

  @Override
  public void reset()
  {
    mName.setText(null);
    mDisplay.setText(null);
    mPageNameC.setText(null);
    mPageNameF.setText(null);
    mPageNameA.setText(null);

    setSelectedIndex(mFvt, (String) null);
    setSelectedIndex(mFgg, (String) null);
    setSelectedIndex(mPageName, (String) null);

    defaultTree();
    removeTree();

    resetComponent();
  }

  // http://jonmiles.github.io/bootstrap-treeview/
  // https://github.com/jonmiles/bootstrap-treeview
  private native void addTree(String inJson)
  /*-{
        $wnd.$('#tree').treeview(
        {
          showTags: true,
          onNodeSelected: function(event, node)
          {
            $wnd.nodeSelected(node.nodeId,node.parentId);
          },
          data: inJson
        });
    }-*/;

  private void defaultTree()
  {
    String djson = "[ { \"text\": \"Nothing\" } ]";
    addTree(djson);
  }

  private native void removeTree()
  /*-{
        $wnd.$('#tree').treeview('remove');
    }-*/;

  private native void exportNodeSelected()
  /*-{
        var that = this;
        $wnd.nodeSelected = $entry(function(inNodeId,inParentId)
        {
          that.@net.hus.core.client.ui.admin.ComponentView::nodeSelected(II)(inNodeId,inParentId);
        });
  }-*/;

  private void nodeSelected(int inNodeId, int inParentId)
  {
    mAction.selectComponent(inNodeId, inParentId);
  }

  @Override
  public void addFieldGroups(List<Lookup> inFieldGroups)
  {
    mFgg.clear();
    mAddFgg.clear();
    for (Lookup value : inFieldGroups)
    {
      mFgg.addItem(value.getDisplay(), value.getName());
      mAddFgg.addItem(value.getDisplay(), value.getName());
    }
  }

  @Override
  public void addComponents(List<Lookup> inComponents)
  {
    mComponents.clear();
    for (Lookup value : inComponents)
    {
      mComponents.addItem(value.getDisplay(), value.getName());
    }
  }

  @Override
  public void addTables(List<Lookup> inTables)
  {
    mFvt.clear();
    mAddFvt.clear();
    for (Lookup value : inTables)
    {
      mFvt.addItem(value.getDisplay(), value.getName());
      mAddFvt.addItem(value.getDisplay(), value.getName());
    }
  }

  @Override
  public void addComponent(IsWidget inDisplay)
  {
    resetComponent();
    mDetail.add(inDisplay);
  }

  private void resetComponent()
  {
    mDetail.clear();
  }

  @Override
  public void onDone(Boolean inValue)
  {
    if (inValue)
    {
      mAction.savePage();
    }
    else
    {
      mAction.refresh();
    }
  }

  @Override
  public IsWidget getDisplay(UIObject_ inUiObject, Fields inFields, boolean inParent,
      Page.Layout inPage)
  {
    UIObjectDisplay ret = null;
    mPageNameA.setText(inUiObject.getSimpleName());
    switch (inUiObject.cType())
    {
      case FORM_GROUP:
        ret = new FormGroupView(inUiObject, inParent, inPage);
        break;
      case HEADING:
        ret = new HeadingView(inUiObject, inParent, inPage);
        break;
      case INPUT:
        ret = new InputView(inUiObject, inFields, inParent, inPage);
        break;
      case FORM_LABEL:
        ret = new FormLabelView(inUiObject, inFields, inParent, inPage);
        break;
      case BUTTON:
        ret = new ButtonView(inUiObject, inFields, inParent, inPage);
        break;
      default:
        ret = new DefaultView(inUiObject);
        break;
    }
    ret.setCallback(this);
    return ret;
  }
}