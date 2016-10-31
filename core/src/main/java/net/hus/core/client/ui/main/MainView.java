package net.hus.core.client.ui.main;

import org.gwtbootstrap3.client.ui.gwt.FlowPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.common.Display;
import net.hus.core.client.common.UiCreate;
import net.hus.core.client.model.main.MainDisplay;
import net.hus.core.client.model.page.BlogDisplay;
import net.hus.core.client.model.page.LoginDisplay;
import net.hus.core.client.model.page.MarketingDisplay;
import net.hus.core.client.model.page.WebDisplay;
import net.hus.core.client.ui.common.AbstractView;
import net.hus.core.client.ui.common.GwtUiCreate;
import net.hus.core.client.ui.page.BlogView;
import net.hus.core.client.ui.page.LoginView;
import net.hus.core.client.ui.page.MarketingView;
import net.hus.core.client.ui.page.WebView;

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
  public WebDisplay getWeb()
  {
    return new WebView();
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

  @Override
  public UiCreate getUiCreate()
  {
    return new GwtUiCreate();
  }
}