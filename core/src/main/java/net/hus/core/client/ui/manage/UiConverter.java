package net.hus.core.client.ui.manage;

import java.util.List;

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
import org.gwtbootstrap3.client.ui.ListBox;
import org.gwtbootstrap3.client.ui.Panel;
import org.gwtbootstrap3.client.ui.PanelBody;
import org.gwtbootstrap3.client.ui.PanelFooter;
import org.gwtbootstrap3.client.ui.PanelHeader;
import org.gwtbootstrap3.client.ui.Row;
import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.client.ui.base.AbstractTextWidget;
import org.gwtbootstrap3.client.ui.base.ComplexWidget;
import org.gwtbootstrap3.client.ui.base.ValueBoxBase;
import org.gwtbootstrap3.client.ui.constants.Alignment;
import org.gwtbootstrap3.client.ui.constants.BadgePosition;
import org.gwtbootstrap3.client.ui.constants.ButtonSize;
import org.gwtbootstrap3.client.ui.constants.ButtonType;
import org.gwtbootstrap3.client.ui.constants.ColumnOffset;
import org.gwtbootstrap3.client.ui.constants.ColumnPull;
import org.gwtbootstrap3.client.ui.constants.ColumnPush;
import org.gwtbootstrap3.client.ui.constants.ColumnSize;
import org.gwtbootstrap3.client.ui.constants.Emphasis;
import org.gwtbootstrap3.client.ui.constants.FormGroupSize;
import org.gwtbootstrap3.client.ui.constants.IconFlip;
import org.gwtbootstrap3.client.ui.constants.IconPosition;
import org.gwtbootstrap3.client.ui.constants.IconRotate;
import org.gwtbootstrap3.client.ui.constants.IconSize;
import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.client.ui.constants.InputSize;
import org.gwtbootstrap3.client.ui.constants.Pull;
import org.gwtbootstrap3.client.ui.constants.Toggle;
import org.gwtbootstrap3.client.ui.constants.ValidationState;
import org.gwtbootstrap3.client.ui.gwt.ButtonBase;
import org.gwtbootstrap3.client.ui.html.Br;
import org.gwtbootstrap3.client.ui.html.Hr;
import org.gwtbootstrap3.extras.datepicker.client.ui.base.DatePickerBase;
import org.gwtbootstrap3.extras.notify.client.ui.Notify;

import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.UIObject;

import net.hus.core.client.common.UiCreate;
import net.hus.core.client.ui.components.Alert_View;
import net.hus.core.client.ui.components.Badge_View;
import net.hus.core.client.ui.components.Button_View;
import net.hus.core.client.ui.components.CheckBox_View;
import net.hus.core.client.ui.components.DatePicker_View;
import net.hus.core.client.ui.components.FlexTable_View;
import net.hus.core.client.ui.components.FormLabel_View;
import net.hus.core.client.ui.components.Input_View;
import net.hus.core.client.ui.components.ListBox_View;
import net.hus.core.client.ui.components.TextBox_View;
import net.hus.core.client.ui.components.Typeahead_View;
import net.hus.core.shared.components.AbstractTextWidget_;
import net.hus.core.shared.components.Alert_;
import net.hus.core.shared.components.Badge_;
import net.hus.core.shared.components.Br_;
import net.hus.core.shared.components.ButtonBase_;
import net.hus.core.shared.components.Button_;
import net.hus.core.shared.components.CheckBox_;
import net.hus.core.shared.components.Column_;
import net.hus.core.shared.components.ComplexPanel_;
import net.hus.core.shared.components.ComplexWidget_;
import net.hus.core.shared.components.Container_;
import net.hus.core.shared.components.DatePickerBase_;
import net.hus.core.shared.components.DatePicker_;
import net.hus.core.shared.components.FieldSet_;
import net.hus.core.shared.components.FlexTable_;
import net.hus.core.shared.components.FocusWidget_;
import net.hus.core.shared.components.FormGroup_;
import net.hus.core.shared.components.FormLabel_;
import net.hus.core.shared.components.Heading_;
import net.hus.core.shared.components.Hr_;
import net.hus.core.shared.components.Icon_;
import net.hus.core.shared.components.Input_;
import net.hus.core.shared.components.ListBox_;
import net.hus.core.shared.components.ListBox_.Item;
import net.hus.core.shared.components.PanelBody_;
import net.hus.core.shared.components.PanelFooter_;
import net.hus.core.shared.components.PanelHeader_;
import net.hus.core.shared.components.Panel_;
import net.hus.core.shared.components.Row_;
import net.hus.core.shared.components.TextBox_;
import net.hus.core.shared.components.Typeahead_;
import net.hus.core.shared.components.ValueBoxBase_;
import net.hus.core.shared.model.Field.Lookup.Location;
import net.hus.core.shared.model.UIObject_;

/**
 * Responsible for creating UI Objects from Model UI Objects without any values.
 *
 * @author simeonhearring
 * @since October 2016
 */
public abstract class UiConverter
{
  private UiCreate mUiCreate;

  public UiConverter(UiCreate inUiCreate)
  {
    mUiCreate = inUiCreate;
  }

  public IsWidget convert(Panel_ inUiO)
  {
    Panel ret = mUiCreate.newPanel();

    create((UIObject) ret, (UIObject_) inUiO);
    create(ret, inUiO);

    ret.setType(inUiO.getType());

    return ret;
  }

  public IsWidget convert(PanelHeader_ inUiO)
  {
    PanelHeader ret = mUiCreate.newPanelHeader();

    create((UIObject) ret, (UIObject_) inUiO);
    create(ret, inUiO);

    return ret;
  }

  public IsWidget convert(Br_ inUiO)
  {
    Br ret = mUiCreate.newBr();

    create((UIObject) ret, (UIObject_) inUiO);
    create(ret, inUiO);

    return ret;
  }

  public IsWidget convert(Hr_ inUiO)
  {
    Hr ret = mUiCreate.newHr();

    create((UIObject) ret, (UIObject_) inUiO);
    create(ret, inUiO);

    return ret;
  }

  public IsWidget convert(PanelBody_ inUiO)
  {
    PanelBody ret = mUiCreate.newPanelBody();

    create((UIObject) ret, (UIObject_) inUiO);
    create(ret, inUiO);

    return ret;
  }

  public IsWidget convert(PanelFooter_ inUiO)
  {
    PanelFooter ret = mUiCreate.newPanelFooter();

    create((UIObject) ret, (UIObject_) inUiO);
    create(ret, inUiO);

    return ret;
  }

  public IsWidget convert(Typeahead_ inUiO)
  {
    Typeahead_View ret = new Typeahead_View();

    create((UIObject) ret.getComponent(), (UIObject_) inUiO);
    create(ret.getComponent(), inUiO);

    ret.getComponent().setMinLength(3); // TODO

    Location location = inUiO.getLocation();
    if (Location.TABLE.equals(location))
    {
      ret.setOptions(inUiO.getOptions());
    }
    else if (Location.RPC.equals(location))
    {
      ret.setLookupGroups(inUiO.getLookupGroups());
    }

    add(inUiO.getKey(), ret);

    return ret;
  }

  public IsWidget convert(DatePicker_ inUiO)
  {
    DatePicker_View ret = new DatePicker_View();

    create((UIObject) ret.getComponent(), (UIObject_) inUiO);
    create(ret.getComponent(), inUiO);

    add(inUiO.getKey(), ret);

    return ret;
  }

  public IsWidget convert(Button_ inUiO)
  {
    Button ret = mUiCreate.newButton();

    create(ret, inUiO);

    String text = inUiO.getText();
    IconType iconType = inUiO.getIconType();
    Boolean toggleCaret = inUiO.getToggleCaret();
    Toggle dataToggle = inUiO.getDataToggle();
    ButtonType buttonType = inUiO.getButtonType();
    IconPosition iconPosition = inUiO.getIconPosition();
    IconSize iconSize = inUiO.getIconSize();
    IconFlip iconFlip = inUiO.getIconFlip();
    IconRotate iconRotate = inUiO.getIconRotate();
    Boolean iconBordered = inUiO.getIconBordered();
    Boolean iconInverse = inUiO.getIconInverse();
    Boolean iconSpin = inUiO.getIconSpin();
    Boolean iconPulse = inUiO.getIconPulse();
    Boolean iconFixedWidth = inUiO.getIconFixedWidth();
    String badgeText = inUiO.getBadgeText();
    BadgePosition badgePosition = inUiO.getBadgePosition();
    Boolean active = inUiO.getActive();
    Boolean enabled = inUiO.getEnabled();
    ButtonSize buttonSize = inUiO.getButtonSize();

    if (text != null)
    {
      ret.setText(text);
    }
    if (iconType != null)
    {
      ret.setIcon(iconType);
    }
    if (toggleCaret != null)
    {
      ret.setToggleCaret(toggleCaret);
    }
    if (dataToggle != null)
    {
      ret.setDataToggle(dataToggle);
    }
    if (buttonType != null)
    {
      ret.setType(buttonType);
    }
    if (iconPosition != null)
    {
      ret.setIconPosition(iconPosition);
    }
    if (iconSize != null)
    {
      ret.setIconSize(iconSize);
    }
    if (iconFlip != null)
    {
      ret.setIconFlip(iconFlip);
    }
    if (iconRotate != null)
    {
      ret.setIconRotate(iconRotate);
    }
    if (iconBordered != null)
    {
      ret.setIconBordered(iconBordered);
    }
    if (iconInverse != null)
    {
      ret.setIconInverse(iconInverse);
    }
    if (iconSpin != null)
    {
      ret.setIconSpin(iconSpin);
    }
    if (iconPulse != null)
    {
      ret.setIconPulse(iconPulse);
    }
    if (iconFixedWidth != null)
    {
      ret.setIconFixedWidth(iconFixedWidth);
    }
    if (badgeText != null)
    {
      ret.setBadgeText(badgeText);
    }
    if (badgePosition != null)
    {
      ret.setBadgePosition(badgePosition);
    }
    if (active != null)
    {
      ret.setActive(active);
    }
    if (enabled != null)
    {
      ret.setEnabled(enabled);
    }
    if (buttonSize != null)
    {
      ret.setSize(buttonSize);
    }

    add(inUiO.getKey(), new Button_View(ret, inUiO.commandName()));

    return ret;
  }

  /*
   * FlexTable_View uses UI Binder for additional icons on the layout. Add
   * FlexTable_View instead of FlexTable.
   */
  public IsWidget convert(FlexTable_ inUiO)
  {
    FlexTable_View ret = new FlexTable_View();

    create(ret.getComponent(), inUiO);

    add(inUiO.getKey(), ret);

    return ret;
  }

  public IsWidget convert(Heading_ inUiO)
  {
    Heading ret = mUiCreate.newHeading(inUiO.getSize(), inUiO.getText());

    create((UIObject) ret, (UIObject_) inUiO);
    create(ret, inUiO);

    String subText = inUiO.getSubText();
    Alignment alignment = inUiO.getAlignment();
    Emphasis emphasis = inUiO.getEmphasis();

    if (subText != null)
    {
      ret.setSubText(subText);
    }
    if (alignment != null)
    {
      ret.setAlignment(alignment);
    }
    if (emphasis != null)
    {
      ret.setEmphasis(emphasis);
    }

    return ret;
  }

  public IsWidget convert(Icon_ inUiO)
  {
    Icon ret = mUiCreate.newIcon();

    create((UIObject) ret, (UIObject_) inUiO);
    create(ret, inUiO);

    IconType type = inUiO.getType();
    IconSize size = inUiO.getSize();
    IconRotate rotate = inUiO.getRotate();
    IconFlip flip = inUiO.getFlip();
    Emphasis emphasis = inUiO.getEmphasis();
    Boolean border = inUiO.getBorder();
    Boolean spin = inUiO.getSpin();
    Boolean pulse = inUiO.getPulse();
    Boolean inverse = inUiO.getInverse();
    Boolean stackTop = inUiO.getStackTop();
    Boolean stackBase = inUiO.getStackBase();
    Boolean fixedWidth = inUiO.getFixedWidth();

    ret.setType(type);

    if (size != null)
    {
      ret.setSize(size);
    }
    if (rotate != null)
    {
      ret.setRotate(rotate);
    }
    if (flip != null)
    {
      ret.setFlip(flip);
    }
    if (emphasis != null)
    {
      ret.setEmphasis(emphasis);
    }
    if (border != null)
    {
      ret.setBorder(border);
    }
    if (spin != null)
    {
      ret.setSpin(spin);
    }
    if (pulse != null)
    {
      ret.setPulse(pulse);
    }
    if (inverse != null)
    {
      ret.setInverse(inverse);
    }
    if (stackTop != null)
    {
      ret.setStackTop(stackTop);
    }
    if (stackBase != null)
    {
      ret.setStackBase(stackBase);
    }
    if (fixedWidth != null)
    {
      ret.setFixedWidth(fixedWidth);
    }

    return ret;
  }

  public IsWidget convert(Column_ inUiO)
  {
    Column ret = mUiCreate.newColumn(inUiO.getSize());

    create((UIObject) ret, (UIObject_) inUiO);
    create(ret, inUiO);

    ColumnSize[] other = inUiO.getOtherSize();
    ColumnPull[] pull = inUiO.getPulls();
    ColumnPush[] push = inUiO.getPush();
    ColumnOffset[] offset = inUiO.getOffset();

    if (other != null)
    {
      ret.addSize(other);
    }
    if (pull != null)
    {
      ret.addPull(pull);
    }
    if (push != null)
    {
      ret.addPush(push);
    }
    if (offset != null)
    {
      ret.addOffset(offset);
    }

    return ret;
  }

  public IsWidget convert(Row_ inUiO)
  {
    Row ret = mUiCreate.newRow();

    create((UIObject) ret, (UIObject_) inUiO);
    create(ret, inUiO);

    List<Column_> columns = inUiO.getColumn();

    if (columns != null)
    {
      for (Column_ uiObject_ : columns)
      {
        ret.add(match(uiObject_));
      }
    }

    return ret;
  }

  public IsWidget convert(Container_ inUiO)
  {
    Container ret = mUiCreate.newContainer();

    create((UIObject) ret, (UIObject_) inUiO);
    create(ret, inUiO);

    Boolean fluid = inUiO.getFluid();
    if (fluid != null)
    {
      ret.setFluid(fluid);
    }

    return ret;
  }

  public IsWidget convert(CheckBox_ inUiO)
  {
    CheckBox ret = mUiCreate.newCheckBox();

    create((UIObject) ret, (UIObject_) inUiO);
    create((FocusWidget) ret, (FocusWidget_) inUiO);
    create(ret, inUiO);

    Boolean value = inUiO.getValue();
    if (value != null)
    {
      ret.setValue(value);
    }

    add(inUiO.getKey(), new CheckBox_View(ret));

    return ret;
  }

  public IsWidget convert(ListBox_ inUiO)
  {
    ListBox ret = mUiCreate.newListBox();

    create((UIObject) ret, (UIObject_) inUiO);
    create(ret, inUiO);

    if (inUiO.getMultipleSelect() != null)
    {
      ret.setMultipleSelect(inUiO.getMultipleSelect());
    }

    if (inUiO.getItems() != null)
    {
      for (Item value : inUiO.getItems())
      {
        ret.addItem(value.getText(), String.valueOf(value.getValueId()));
      }
    }

    add(inUiO.getKey(), new ListBox_View(ret));

    return ret;
  }

  public IsWidget convert(TextBox_ inUiO)
  {
    TextBox ret = mUiCreate.newTextBox();

    create((UIObject) ret, (UIObject_) inUiO);
    create(ret, inUiO);

    String value = inUiO.getValue();
    if (value != null)
    {
      ret.setValue(value);
    }

    add(inUiO.getKey(), new TextBox_View(ret));

    return ret;
  }

  public IsWidget convert(FormLabel_ inUiO)
  {
    FormLabel ret = mUiCreate.newFormLabel();

    create((UIObject) ret, (UIObject_) inUiO);
    create(ret, inUiO);

    Boolean showRequiredIndicator = inUiO.getShowRequiredIndicator();
    if (showRequiredIndicator != null)
    {
      ret.setShowRequiredIndicator(showRequiredIndicator);
    }

    add(inUiO.getKey(), new FormLabel_View(ret));

    return ret;
  }

  public IsWidget convert(FormGroup_ inUiO)
  {
    FormGroup ret = mUiCreate.newFormGroup();

    create((UIObject) ret, (UIObject_) inUiO);
    create(ret, inUiO);

    FormGroupSize size = inUiO.getSize();
    ValidationState state = inUiO.getState();

    if (size != null)
    {
      ret.setSize(size);
    }
    if (state != null)
    {
      ret.setValidationState(state);
    }

    return ret;
  }

  public IsWidget convert(FieldSet_ inUiO)
  {
    FieldSet ret = mUiCreate.newFieldSet();

    create((UIObject) ret, (UIObject_) inUiO);
    create(ret, inUiO);

    ret.setEnabled(inUiO.isEnabled());

    return ret;
  }

  public IsWidget convert(Input_ inUiO)
  {
    Input ret = mUiCreate.newInput();

    create((UIObject) ret, (UIObject_) inUiO);
    create(ret, inUiO);

    ret.setType(inUiO.getType());
    String min = inUiO.getMin();
    String value = inUiO.getValue();
    if (value != null)
    {
      ret.setValue(value);
    }
    if (min != null)
    {
      ret.setMin(min);
    }
    String max = inUiO.getMax();
    if (max != null)
    {
      ret.setMax(max);
    }

    add(inUiO.getKey(), new Input_View(ret));

    return ret;
  }

  public IsWidget convert(Badge_ inUiO)
  {
    Badge ret = mUiCreate.newBadge();

    create(ret, inUiO);

    ret.setText(inUiO.getText());

    add(inUiO.getKey(), new Badge_View(ret));

    return ret;
  }

  public IsWidget convert(Alert_ inUiO)
  {
    Alert ret = mUiCreate.newAlert();

    create(ret, inUiO);

    ret.setText(inUiO.getText());
    ret.setType(inUiO.getType());
    ret.setDismissable(inUiO.isDismissable());
    ret.setFade(inUiO.isFade());

    add(inUiO.getKey(), new Alert_View(ret));

    return ret;
  }

  private void create(FocusWidget inUiO, FocusWidget_ inUiO_)
  {
  }

  private void create(ButtonBase inUiO, ButtonBase_ inUiO_)
  {
    String text = inUiO_.getText();
    if (text != null)
    {
      if (inUiO_.isHtml())
      {
        inUiO.setHTML(text);
      }
      else
      {
        inUiO.setText(text);
      }
    }
  }

  private void create(ComplexWidget inUiO, ComplexWidget_ inUiO_)
  {
    String color = inUiO_.getColor();
    Double marginBottom = inUiO_.getMarginBottom();
    Double marginLeft = inUiO_.getMarginLeft();
    Double marginRight = inUiO_.getMarginRight();
    Double marginTop = inUiO_.getMarginTop();
    Double paddingBottom = inUiO_.getPaddingBottom();
    Double paddingLeft = inUiO_.getPaddingLeft();
    Double paddingRight = inUiO_.getMarginRight();
    Double paddingTop = inUiO_.getPaddingTop();
    Pull pull = inUiO_.getPull();

    create((ComplexPanel) inUiO, (ComplexPanel_) inUiO_);

    if (color != null)
    {
      inUiO.setColor(color);
    }
    if (marginBottom != null)
    {
      inUiO.setMarginBottom(marginBottom);
    }
    if (marginLeft != null)
    {
      inUiO.setMarginLeft(marginLeft);
    }
    if (marginRight != null)
    {
      inUiO.setMarginRight(marginRight);
    }
    if (marginTop != null)
    {
      inUiO.setMarginTop(marginTop);
    }
    if (paddingBottom != null)
    {
      inUiO.setPaddingBottom(paddingBottom);
    }
    if (paddingLeft != null)
    {
      inUiO.setPaddingLeft(paddingLeft);
    }
    if (paddingRight != null)
    {
      inUiO.setPaddingRight(paddingRight);
    }
    if (paddingTop != null)
    {
      inUiO.setPaddingTop(paddingTop);
    }
    if (pull != null)
    {
      inUiO.setPull(pull);
    }
  }

  private void create(AbstractTextWidget inUiO, AbstractTextWidget_ inUiO_)
  {
    String text = inUiO_.getText();
    String color = inUiO_.getColor();
    Double marginBottom = inUiO_.getMarginBottom();
    Double marginLeft = inUiO_.getMarginLeft();
    Double marginRight = inUiO_.getMarginRight();
    Double marginTop = inUiO_.getMarginTop();
    Double paddingBottom = inUiO_.getPaddingBottom();
    Double paddingLeft = inUiO_.getPaddingLeft();
    Double paddingRight = inUiO_.getMarginRight();
    Double paddingTop = inUiO_.getPaddingTop();
    Pull pull = inUiO_.getPull();

    if (text != null)
    {
      if (inUiO_.isHtml())
      {
        inUiO.setHTML(text);
      }
      else
      {
        inUiO.setText(text);
      }
    }

    if (color != null)
    {
      inUiO.setColor(color);
    }
    if (marginBottom != null)
    {
      inUiO.setMarginBottom(marginBottom);
    }
    if (marginLeft != null)
    {
      inUiO.setMarginLeft(marginLeft);
    }
    if (marginRight != null)
    {
      inUiO.setMarginRight(marginRight);
    }
    if (marginTop != null)
    {
      inUiO.setMarginTop(marginTop);
    }
    if (paddingBottom != null)
    {
      inUiO.setPaddingBottom(paddingBottom);
    }
    if (paddingLeft != null)
    {
      inUiO.setPaddingLeft(paddingLeft);
    }
    if (paddingRight != null)
    {
      inUiO.setPaddingRight(paddingRight);
    }
    if (paddingTop != null)
    {
      inUiO.setPaddingTop(paddingTop);
    }
    if (pull != null)
    {
      inUiO.setPull(pull);
    }
  }

  private void create(ComplexPanel inUiO, ComplexPanel_ inUiO_)
  {
    List<UIObject_> collection = inUiO_.getCollection();

    if (collection != null)
    {
      for (UIObject_ uiObject_ : collection)
      {
        inUiO.add(match(uiObject_));
      }
    }
  }

  private <T> void create(ValueBoxBase<T> inUiO, ValueBoxBase_ inUiO_)
  {
    Boolean allowBlank = inUiO_.getAllowBlank();
    Boolean autoComplete = inUiO_.getAutoComplete();
    Integer maxLength = inUiO_.getMaxLength();
    String placeholder = inUiO_.getPlaceholder();
    InputSize size = inUiO_.getSize();

    if (allowBlank != null)
    {
      inUiO.setAllowBlank(allowBlank);
    }
    if (autoComplete != null)
    {
      inUiO.setAutoComplete(autoComplete);
    }
    if (maxLength != null)
    {
      inUiO.setMaxLength(maxLength);
    }
    if (placeholder != null)
    {
      inUiO.setPlaceholder(placeholder);
    }
    if (size != null)
    {
      inUiO.setSize(size);
    }
  }

  private void create(DatePickerBase inUiO, DatePickerBase_ inUiO_)
  {
  }

  private void create(UIObject inUiO, UIObject_ inUiO_)
  {
    String id = inUiO_.getId();
    String height = inUiO_.getHeight();
    String width = inUiO_.getWidth();
    String title = inUiO_.getTitle();
    String stylePrimaryName = inUiO_.getStylePrimaryName();
    String styleName = inUiO_.getStyleName();
    Boolean visible = inUiO_.getVisible();

    if (id != null)
    {
      inUiO.getElement().setId(id);
    }
    if (visible != null)
    {
      inUiO.setVisible(visible);
    }
    if (height != null)
    {
      inUiO.setHeight(height);
    }
    if (width != null)
    {
      inUiO.setWidth(width);
    }
    if (title != null)
    {
      inUiO.setTitle(title);
    }
    if (stylePrimaryName != null)
    {
      inUiO.setStylePrimaryName(stylePrimaryName);
    }
    if (styleName != null)
    {
      inUiO.setStyleName(styleName);
    }
  }

  public IsWidget match(UIObject_ inUiO)
  {
    IsWidget ret = null;

    if (inUiO instanceof Alert_)
    {
      ret = convert((Alert_) inUiO);
    }
    else if (inUiO instanceof Badge_)
    {
      ret = convert((Badge_) inUiO);
    }
    else if (inUiO instanceof FieldSet_)
    {
      ret = convert((FieldSet_) inUiO);
    }
    else if (inUiO instanceof FormGroup_)
    {
      ret = convert((FormGroup_) inUiO);
    }
    else if (inUiO instanceof FormLabel_)
    {
      ret = convert((FormLabel_) inUiO);
    }
    else if (inUiO instanceof Input_)
    {
      ret = convert((Input_) inUiO);
    }
    else if (inUiO instanceof ListBox_)
    {
      ret = convert((ListBox_) inUiO);
    }
    else if (inUiO instanceof Typeahead_)
    {
      ret = convert((Typeahead_) inUiO);
    }
    else if (inUiO instanceof TextBox_)
    {
      ret = convert((TextBox_) inUiO);
    }
    else if (inUiO instanceof CheckBox_)
    {
      ret = convert((CheckBox_) inUiO);
    }
    else if (inUiO instanceof Container_)
    {
      ret = convert((Container_) inUiO);
    }
    else if (inUiO instanceof Row_)
    {
      ret = convert((Row_) inUiO);
    }
    else if (inUiO instanceof Column_)
    {
      ret = convert((Column_) inUiO);
    }
    else if (inUiO instanceof Icon_)
    {
      ret = convert((Icon_) inUiO);
    }
    else if (inUiO instanceof Heading_)
    {
      ret = convert((Heading_) inUiO);
    }
    else if (inUiO instanceof FlexTable_)
    {
      ret = convert((FlexTable_) inUiO);
    }
    else if (inUiO instanceof Button_)
    {
      ret = convert((Button_) inUiO);
    }
    else if (inUiO instanceof DatePicker_)
    {
      ret = convert((DatePicker_) inUiO);
    }
    else if (inUiO instanceof Panel_)
    {
      ret = convert((Panel_) inUiO);
    }
    else if (inUiO instanceof PanelHeader_)
    {
      ret = convert((PanelHeader_) inUiO);
    }
    else if (inUiO instanceof PanelBody_)
    {
      ret = convert((PanelBody_) inUiO);
    }
    else if (inUiO instanceof PanelFooter_)
    {
      ret = convert((PanelFooter_) inUiO);
    }
    else if (inUiO instanceof Hr_)
    {
      ret = convert((Hr_) inUiO);
    }
    else if (inUiO instanceof Br_)
    {
      ret = convert((Br_) inUiO);
    }
    else
    {
      Notify.notify("Missing widget convert type");
      throw new RuntimeException("Missing widget convert type");
    }

    return ret;
  }

  abstract void add(String inUiObjectKey, IsWidget inUiO);
}