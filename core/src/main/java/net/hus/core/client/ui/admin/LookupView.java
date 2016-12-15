package net.hus.core.client.ui.admin;

import java.util.List;

import org.gwtbootstrap3.client.ui.Form;
import org.gwtbootstrap3.client.ui.FormLabel;
import org.gwtbootstrap3.client.ui.Icon;
import org.gwtbootstrap3.client.ui.Input;
import org.gwtbootstrap3.client.ui.html.Paragraph;
import org.gwtbootstrap3.extras.select.client.ui.OptGroup;
import org.gwtbootstrap3.extras.select.client.ui.Option;
import org.gwtbootstrap3.extras.select.client.ui.Select;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.model.admin.LookupDisplay;
import net.hus.core.client.ui.common.AbstractView;
import net.hus.core.client.ui.components.FlexTable_View;
import net.hus.core.shared.model.Lookup;
import net.hus.core.shared.model.Lookups;
import net.hus.core.shared.util.NumberUtil;

public class LookupView extends AbstractView implements LookupDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, LookupView>
  {
  }

  @UiField
  Select mLookups;

  @UiField
  FlexTable_View mValues;

  @UiField
  Icon mAdd0, mSave0, mSave1;

  @UiField
  Input mAddLookups, mDisplay, mNewName, mNewAbbr, mNewSort;

  @UiField
  Paragraph mName;

  @UiField
  FormLabel mNameText;

  @UiField
  Form mQuickEdit;

  private Action mAction;

  public LookupView()
  {
    initWidget(BINDER.createAndBindUi(this));
    mValues.showActions(false);
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
      mAction.createLookups(mAddLookups.getText());
    }
    else if (mSave0.equals(inEvent.getSource()))
    {
      mAction.saveLookups(mName.getText(), mDisplay.getText());
    }
    else if (mSave1.equals(inEvent.getSource()))
    {
      String grp = mName.getText();
      String name = mNewName.getText();
      String abbr = mNewAbbr.getText();
      int sort = NumberUtil.toInt(mNewSort.getText(), 0);
      mAction.createLookup(grp, name, abbr, sort);
    }
  }

  @UiHandler(
      {
        "mLookups"
      })
  public void onValueChangeBind(ValueChangeEvent<String> inEvent)
  {
    if (mLookups.equals(inEvent.getSource()))
    {
      mAction.select(mLookups.getSelectedItem().getValue());
    }
  }

  @Override
  public void clearLookupGroups()
  {
    mLookups.clear();
  }

  @Override
  public void refreshLookupGroups()
  {
    mLookups.refresh();
    mLookups.setValue(null);
  }

  @Override
  public void addLookupGroups(String inType, List<Lookup> inLookupGroups)
  {
    OptGroup type = new OptGroup();
    type.setLabel(inType);

    for (Lookup value : inLookupGroups)
    {
      Option field = new Option();
      field.setText(value.getDisplay());
      field.setValue(value.getCode());
      field.setId(value.getId().toString());
      type.add(field);
    }
    mLookups.add(type);
  }

  @Override
  public void addValues(Lookups inLookups)
  {
    mValues.clear();
    String[] head =
      {
          "Name",
          "Abbr",
          "Sort",
      };

    mValues.addHeaders(head);
    mValues.setWidth("100%");

    boolean notsys = !Lookup.Group.isApp(inLookups.getCode());
    mQuickEdit.setVisible(notsys);
    mSave0.setVisible(notsys);
    mSave1.setVisible(notsys);
    mDisplay.setEnabled(notsys);

    mName.setText(inLookups.getCode());
    mDisplay.setText(inLookups.getDisplay());
    mNameText.setText(inLookups.getDisplay());

    for (Lookup value : inLookups.getOptions())
    {
      String[] values =
        {
            value.getDisplay(),
            value.getAbbreviation(),
            value.getSort().toString()
        };

      mValues.addRow(head.length, values);
    }
    // TODO doesn't show when tab is not active
    mValues.handlePanelHeight();
    mLookups.setValue(null);
  }

  @Override
  public void setUp()
  {
    clearLookupGroups();
    reset();
    mValues.clear();
    mDisplay.setText(null);
    mNameText.setText(null);
  }

  @Override
  public void reset()
  {
    mAddLookups.setText(null);
    mName.setText(null);
    mNewName.setText(null);
    mNewAbbr.setText(null);
    mNewSort.setText(null);
  }
}