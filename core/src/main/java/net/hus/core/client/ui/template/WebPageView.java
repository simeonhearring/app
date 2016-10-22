package net.hus.core.client.ui.template;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.model.template.WebPageDisplay;
import net.hus.core.client.ui.common.AbstractView;

public class WebPageView extends AbstractView implements WebPageDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, WebPageView>
  {
  }

  public WebPageView()
  {
    initWidget(BINDER.createAndBindUi(this));
  }
}