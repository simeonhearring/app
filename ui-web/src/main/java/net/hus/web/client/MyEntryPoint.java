package net.hus.web.client;

import com.google.gwt.user.client.ui.RootPanel;

import net.hus.core.client.AbstractEntryPoint;
import net.hus.core.client.model.main.MainPresenter;
import net.hus.core.client.ui.event.LoadMainEvent;
import net.hus.core.client.ui.main.MainView;

public class MyEntryPoint extends AbstractEntryPoint
{
  @Override
  public void dispatch(LoadMainEvent inEvent)
  {
    MainView main = new MainView();
    new MainPresenter(main);
    RootPanel.get().add(main);
  }
}