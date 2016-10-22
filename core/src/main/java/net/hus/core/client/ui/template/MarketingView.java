package net.hus.core.client.ui.template;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.model.template.MarketingDisplay;
import net.hus.core.client.ui.common.AbstractView;

public class MarketingView extends AbstractView implements MarketingDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, MarketingView>
  {
  }

  public MarketingView()
  {
    initWidget(BINDER.createAndBindUi(this));
  }
}