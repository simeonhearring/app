package net.hus.core.client.ui.main;

import org.gwtbootstrap3.client.ui.gwt.FlowPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.common.Display;
import net.hus.core.client.model.main.MainDisplay;
import net.hus.core.client.model.template.BlogDisplay;
import net.hus.core.client.model.template.LoginDisplay;
import net.hus.core.client.model.template.MarketingDisplay;
import net.hus.core.client.model.template.WebPageDisplay;
import net.hus.core.client.ui.common.AbstractView;
import net.hus.core.client.ui.template.BlogView;
import net.hus.core.client.ui.template.LoginView;
import net.hus.core.client.ui.template.MarketingView;
import net.hus.core.client.ui.template.WebPageView;

public class MainView extends AbstractView implements MainDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, MainView>
  {
  }

  @UiField
  FlowPanel mMain;

  public MainView()
  {
    initWidget(BINDER.createAndBindUi(this));
  }

  @Override
  public void add(IsWidget inWidget)
  {
    mMain.add(inWidget);
  }

  @Override
  public void add(Display inDisplay)
  {
    mMain.add(inDisplay);
  }

  @Override
  public void clear()
  {
    mMain.clear();
  }

  @Override
  public BlogDisplay getBlog()
  {
    return new BlogView();
  }

  @Override
  public WebPageDisplay getWebPage()
  {
    return new WebPageView();
  }

  @Override
  public MarketingDisplay getMarketing()
  {
    return new MarketingView();
  }

  @Override
  public LoginDisplay getLogin()
  {
    return new LoginView();
  }
}