package net.hus.core.client.ui;

import java.util.List;

import org.gwtbootstrap3.client.ui.Alert;
import org.gwtbootstrap3.client.ui.Badge;
import org.gwtbootstrap3.client.ui.FieldSet;
import org.gwtbootstrap3.client.ui.FormGroup;
import org.gwtbootstrap3.client.ui.FormLabel;
import org.gwtbootstrap3.client.ui.Input;
import org.gwtbootstrap3.client.ui.base.AbstractTextWidget;
import org.gwtbootstrap3.client.ui.base.ComplexWidget;
import org.gwtbootstrap3.client.ui.base.ValueBoxBase;
import org.gwtbootstrap3.client.ui.constants.FormGroupSize;
import org.gwtbootstrap3.client.ui.constants.InputSize;
import org.gwtbootstrap3.client.ui.constants.Pull;
import org.gwtbootstrap3.client.ui.constants.ValidationState;

import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;

public class Convert
{
  public FormLabel convert(FormLabel_ inUiO)
  {
    FormLabel ret = new FormLabel();

    create((UIObject) ret, (UIObject_) inUiO);
    create(ret, inUiO);

    Boolean showRequiredIndicator = inUiO.getShowRequiredIndicator();
    if (showRequiredIndicator != null)
    {
      ret.setShowRequiredIndicator(showRequiredIndicator);
    }

    return ret;
  }

  public FormGroup convert(FormGroup_ inUiO)
  {
    FormGroup ret = new FormGroup();

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

  public FieldSet convert(FieldSet_ inUiO)
  {
    FieldSet ret = new FieldSet();

    create((UIObject) ret, (UIObject_) inUiO);
    create(ret, inUiO);

    ret.setEnabled(inUiO.isEnabled());

    return ret;
  }

  public Input convert(Input_ inUiO)
  {
    Input ret = new Input();

    create((UIObject) ret, (UIObject_) inUiO);
    create(ret, inUiO);

    ret.setType(inUiO.getType());
    String min = inUiO.getMin();
    if (min != null)
    {
      ret.setMin(min);
    }
    String max = inUiO.getMax();
    if (max != null)
    {
      ret.setMax(max);
    }

    return ret;
  }

  public Badge convert(Badge_ inUiO)
  {
    Badge ret = new Badge();

    create(ret, inUiO);

    ret.setText(inUiO.getText());

    return ret;
  }

  public Alert convert(Alert_ inUiO)
  {
    Alert ret = new Alert();

    create(ret, inUiO);

    ret.setText(inUiO.getText());
    ret.setType(inUiO.getType());
    ret.setDismissable(inUiO.isDismissable());
    ret.setFade(inUiO.isFade());

    return ret;
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

    for (UIObject_ uiObject_ : collection)
    {
      inUiO.add(match(uiObject_));
    }
  }

  private Widget match(UIObject_ inUiO)
  {
    Widget ret = null;

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
    else
    {
      throw new RuntimeException("Missing Widget convert type");
    }

    return ret;
  }

  private <T> void create(ValueBoxBase<T> inUiO, ValueBoxBase_<T> inUiO_)
  {
    Boolean allowBlank = inUiO_.getAllowBlank();
    Boolean autoComplete = inUiO_.getAutoComplete();
    Integer maxLength = inUiO_.getMaxLength();
    String placeholder = inUiO_.getPlaceholder();
    InputSize size = inUiO_.getSize();
    T value = inUiO_.getValue();

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
    if (value != null)
    {
      inUiO.setValue(value);
    }
  }

  private void create(UIObject inUiO, UIObject_ inUiO_)
  {
    String height = inUiO_.getHeight();
    String width = inUiO_.getWidth();
    String title = inUiO_.getTitle();
    String stylePrimaryName = inUiO_.getStylePrimaryName();
    String styleName = inUiO_.getStyleName();

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
}