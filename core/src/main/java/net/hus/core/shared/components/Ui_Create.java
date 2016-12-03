package net.hus.core.shared.components;

import org.gwtbootstrap3.client.ui.constants.InputType;

import net.hus.core.shared.model.Components;
import net.hus.core.shared.model.UIObject_;

public class Ui_Create
{
  public static UIObject_ create(Components.Type inType, String inKey, int inPos)
  {
    UIObject_ ret = create(inType);
    ret.setKey(inKey);
    ret.setPos(inPos);

    return ret;
  }

  public static UIObject_ create(Components.Type inType)
  {
    UIObject_ ret = null;

    switch (inType)
    {
      case ALERT:
        ret = new Alert_();
        break;
      case BADGE:
        ret = new Badge_();
        break;
      case BR:
        ret = new Br_();
        break;
      case BUTTON:
        ret = new Button_();
        break;
      case CHECK_BOX:
        ret = new CheckBox_();
        break;
      case COLUMN:
        ret = new Column_();
        break;
      case CONTAINER:
        ret = new Container_();
        break;
      case DATE_PICKER:
        ret = new DatePicker_();
        break;
      case FIELD_SET:
        ret = new FieldSet_();
        break;
      case FLEX_TABLE:
        ret = new FlexTable_();
        break;
      case FORM_GROUP:
        ret = new FormGroup_();
        break;
      case FORM_LABEL:
        ret = new FormLabel_();
        break;
      case HEADING:
        ret = new Heading_();
        break;
      case HR:
        ret = new Hr_();
        break;
      case ICON:
        ret = new Icon_();
        break;
      case INPUT:
        ret = new Input_();
        break;
      case INPUT_COLOR:
        ret = new Input_(InputType.COLOR);
        break;
      case INPUT_DATE:
        ret = new Input_(InputType.DATE);
        break;
      case INPUT_NUMBER:
        ret = new Input_(InputType.NUMBER);
        break;
      case INPUT_PASSWORD:
        ret = new Input_(InputType.PASSWORD);
        break;
      case INPUT_TEXT:
        ret = new Input_(InputType.TEXT);
        break;
      case LABEL:
        ret = new Label_();
        break;
      case LIST_BOX:
        ret = new ListBox_();
        break;
      case PANEL:
        ret = new Panel_();
        break;
      case PANEL_BODY:
        ret = new PanelBody_();
        break;
      case PANEL_FOOTER:
        ret = new PanelFooter_();
        break;
      case PANEL_HEADER:
        ret = new PanelHeader_();
        break;
      case ROW:
        ret = new Row_();
        break;
      case TEXT_BOX:
        ret = new TextBox_();
        break;
      case TYPEAHEAD:
        ret = new Typeahead_();
        break;
      case ITEM:
        break;
      default:
        break;
    }

    if (ret == null)
    {
      throw new RuntimeException("Missing component type in Ui_Create: " + inType);
    }

    return ret;
  }
}