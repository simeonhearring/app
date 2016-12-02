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

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.IsWidget;

import net.hus.core.client.common.UiCreate;
import net.hus.core.shared.model.Components.Type;

public class GwtUiCreate implements UiCreate
{
  @Override
  public Button newButton()
  {
    return new Button();
  }

  @Override
  public FlexTable newFlexTable()
  {
    return new FlexTable();
  }

  @Override
  public Heading newHeading(HeadingSize inSize, String inText)
  {
    return new Heading(inSize, inText);
  }

  @Override
  public Icon newIcon()
  {
    return new Icon();
  }

  @Override
  public Column newColumn(ColumnSize inSize)
  {
    return new Column(inSize);
  }

  @Override
  public Row newRow()
  {
    return new Row();
  }

  @Override
  public Container newContainer()
  {
    return new Container();
  }

  @Override
  public CheckBox newCheckBox()
  {
    return new CheckBox();
  }

  @Override
  public ListBox newListBox()
  {
    return new ListBox();
  }

  @Override
  public TextBox newTextBox()
  {
    return new TextBox();
  }

  @Override
  public FormLabel newFormLabel()
  {
    return new FormLabel();
  }

  @Override
  public FormGroup newFormGroup()
  {
    return new FormGroup();
  }

  @Override
  public FieldSet newFieldSet()
  {
    return new FieldSet();
  }

  @Override
  public Input newInput()
  {
    return new Input();
  }

  @Override
  public Input newInput(InputType inType)
  {
    return new Input(inType);
  }

  @Override
  public Badge newBadge()
  {
    return new Badge();
  }

  @Override
  public Alert newAlert()
  {
    return new Alert();
  }

  @Override
  public Panel newPanel()
  {
    return new Panel();
  }

  @Override
  public PanelHeader newPanelHeader()
  {
    return new PanelHeader();
  }

  @Override
  public PanelBody newPanelBody()
  {
    return new PanelBody();
  }

  @Override
  public PanelFooter newPanelFooter()
  {
    return new PanelFooter();
  }

  @Override
  public Br newBr()
  {
    return new Br();
  }

  @Override
  public Hr newHr()
  {
    return new Hr();
  }

  public DatePicker newDatePicker()
  {
    return newDatePicker();
  }

  public Label newLabel()
  {
    return new Label();
  }

  public Typeahead<?> newTypeahead()
  {
    return new Typeahead<>();
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
        ret = newColumn(ColumnSize.SM_3); // TODO this should not have a hard coded default.
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
        ret = newHeading(HeadingSize.H4, ""); // TODO this should not have a hard coded default.
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

    if (ret== null)
    {
      throw new RuntimeException("Missing resource in GwtUiCreate");
    }

    return ret;
  }
}