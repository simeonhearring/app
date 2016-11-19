package net.hus.core.client.ui.main;

import org.gwtbootstrap3.client.ui.Label;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.model.main.FooterDisplay;
import net.hus.core.client.ui.common.AbstractView;

public class FooterView extends AbstractView implements FooterDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, FooterView>
  {
  }

  @UiField
  Label mVersion;

  public FooterView()
  {
    initWidget(BINDER.createAndBindUi(this));
    mVersion.setHTML("BETA");
    // mVersion.setHTML(MESSAGE.versionName() + " " + MESSAGE.environment() +
    // MESSAGE.buildNumber());
  }
}