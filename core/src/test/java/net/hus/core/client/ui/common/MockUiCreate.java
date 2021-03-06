package net.hus.core.client.ui.common;

import org.gwtbootstrap3.client.ui.Alert;
import org.gwtbootstrap3.client.ui.Badge;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.CheckBox;
import org.gwtbootstrap3.client.ui.Column;
import org.gwtbootstrap3.client.ui.Container;
import org.gwtbootstrap3.client.ui.FieldSet;
import org.gwtbootstrap3.client.ui.FormGroup;
import org.gwtbootstrap3.client.ui.FormLabel;
import org.gwtbootstrap3.client.ui.Heading;
import org.gwtbootstrap3.client.ui.Icon;
import org.gwtbootstrap3.client.ui.Input;
import org.gwtbootstrap3.client.ui.Label;
import org.gwtbootstrap3.client.ui.ListBox;
import org.gwtbootstrap3.client.ui.Panel;
import org.gwtbootstrap3.client.ui.PanelBody;
import org.gwtbootstrap3.client.ui.PanelFooter;
import org.gwtbootstrap3.client.ui.PanelHeader;
import org.gwtbootstrap3.client.ui.Row;
import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.client.ui.constants.ColumnSize;
import org.gwtbootstrap3.client.ui.constants.HeadingSize;
import org.gwtbootstrap3.client.ui.constants.InputType;
import org.gwtbootstrap3.client.ui.html.Br;
import org.gwtbootstrap3.client.ui.html.Hr;
import org.gwtbootstrap3.extras.datepicker.client.ui.DatePicker;
import org.gwtbootstrap3.extras.typeahead.client.ui.Typeahead;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.IsWidget;

import net.hus.core.client.common.UiCreate;
import net.hus.core.shared.model.Components.Type;

public class MockUiCreate implements UiCreate
{
  @Override
  public Button newButton()
  {
    return GWT.create(Button.class);
  }

  @Override
  public FlexTable newFlexTable()
  {
    return GWT.create(FlexTable.class);
  }

  @Override
  public Heading newHeading(HeadingSize inSize, String inText)
  {
    return GWT.create(Heading.class);
  }

  @Override
  public Icon newIcon()
  {
    return GWT.create(Icon.class);
  }

  @Override
  public Column newColumn(ColumnSize inSize)
  {
    return GWT.create(Column.class);
  }

  @Override
  public Row newRow()
  {
    return GWT.create(Row.class);
  }

  @Override
  public Container newContainer()
  {
    return GWT.create(Container.class);
  }

  @Override
  public CheckBox newCheckBox()
  {
    return GWT.create(CheckBox.class);
  }

  @Override
  public ListBox newListBox()
  {
    return GWT.create(ListBox.class);
  }

  @Override
  public TextBox newTextBox()
  {
    return GWT.create(TextBox.class);
  }

  @Override
  public FormLabel newFormLabel()
  {
    return GWT.create(FormLabel.class);
  }

  @Override
  public FormGroup newFormGroup()
  {
    return GWT.create(FormGroup.class);
  }

  @Override
  public FieldSet newFieldSet()
  {
    return GWT.create(FieldSet.class);
  }

  @Override
  public Input newInput()
  {
    return GWT.create(Input.class);
  }

  @Override
  public Input newInput(InputType inType)
  {
    return newInput();
  }

  @Override
  public Badge newBadge()
  {
    return GWT.create(Badge.class);
  }

  @Override
  public Alert newAlert()
  {
    return GWT.create(Alert.class);
  }

  @Override
  public Panel newPanel()
  {
    return GWT.create(Panel.class);
  }

  @Override
  public PanelHeader newPanelHeader()
  {
    return GWT.create(PanelHeader.class);
  }

  @Override
  public PanelBody newPanelBody()
  {
    return GWT.create(PanelBody.class);
  }

  @Override
  public PanelFooter newPanelFooter()
  {
    return GWT.create(PanelFooter.class);
  }

  @Override
  public Br newBr()
  {
    return GWT.create(Br.class);
  }

  @Override
  public Hr newHr()
  {
    return GWT.create(Hr.class);
  }

  private DatePicker newDatePicker()
  {
    return GWT.create(DatePicker.class);
  }

  private Typeahead<?> newTypeahead()
  {
    return GWT.create(Typeahead.class);
  }

  private Label newLabel()
  {
    return GWT.create(Label.class);
  }

  @Override
  public IsWidget create(Type inCType)
  {
    IsWidget ret = null;
    switch (inCType)
    {
      case ALERT:
        ret = newAlert();
        break;
      case BADGE:
        ret = newBadge();
        break;
      case BR:
        ret = newBr();
        break;
      case BUTTON:
        ret = newButton();
        break;
      case CHECK_BOX:
        ret = newCheckBox();
        break;
      case COLUMN:
        ret = newColumn(ColumnSize.SM_3);
        break;
      case CONTAINER:
        ret = newContainer();
        break;
      case DATE_PICKER:
        ret = newDatePicker();
        break;
      case FIELD_SET:
        ret = newFieldSet();
        break;
      case FLEX_TABLE:
        ret = newFlexTable();
        break;
      case FORM_GROUP:
        ret = newFormGroup();
        break;
      case FORM_LABEL:
        ret = newFormLabel();
        break;
      case HEADING:
        ret = newHeading(HeadingSize.H4, "");
        break;
      case HR:
        ret = newHr();
        break;
      case ICON:
        ret = newIcon();
        break;
      case INPUT:
        ret = newInput();
        break;
      case INPUT_COLOR:
        ret = newInput(InputType.COLOR);
        break;
      case INPUT_DATE:
        ret = newInput(InputType.DATE);
        break;
      case INPUT_NUMBER:
        ret = newInput(InputType.NUMBER);
        break;
      case INPUT_PASSWORD:
        ret = newInput(InputType.PASSWORD);
        break;
      case INPUT_TEXT:
        ret = newInput(InputType.TEXT);
        break;
      case ITEM:
        ret = null;
        break;
      case LABEL:
        ret = newLabel();
        break;
      case LIST_BOX:
        ret = newListBox();
        break;
      case PANEL:
        ret = newPanel();
        break;
      case PANEL_BODY:
        ret = newPanelBody();
        break;
      case PANEL_FOOTER:
        ret = newPanelFooter();
        break;
      case PANEL_HEADER:
        ret = newPanelHeader();
        break;
      case ROW:
        ret = newRow();
        break;
      case TEXT_BOX:
        ret = newTextBox();
        break;
      case TYPEAHEAD:
        ret = newTypeahead();
        break;
      default:
        break;
    }

    return ret;
  }
}
