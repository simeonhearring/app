package net.hus.core.client.ui.admin;

import org.gwtbootstrap3.client.ui.html.Paragraph;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.common.UIObjectDisplay;
import net.hus.core.client.ui.common.AbstractView;
import net.hus.core.shared.model.UIObject_;

public class FormGroupView extends AbstractView implements UIObjectDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, FormGroupView>
  {
  }

  @UiField
  Paragraph mName;

  // private FormGroup_ mUiObject;

  public FormGroupView(UIObject_ inUiObject)
  {
    initWidget(BINDER.createAndBindUi(this));

    mName.setText(inUiObject.getClass().getSimpleName());

    // mUiObject = (FormGroup_) inUiObject;
  }
}