package net.hus.core.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

import net.hus.core.client.service.rpc.RpcService;
import net.hus.core.client.service.rpc.RpcServiceAsync;
import net.hus.core.client.ui.common.Global;
import net.hus.core.client.ui.common.RpcCallback;
import net.hus.core.client.ui.event.AlertEvent;
import net.hus.core.client.ui.service.bus.GwtEventBus;
import net.hus.core.shared.command.LoggerCommand;
import net.hus.core.shared.command.LoggerCommand.Level;
import net.hus.core.shared.command.ServerInfoDataCommand;

public class MyEntryPoint extends RpcCallback<ServerInfoDataCommand> implements
com.google.gwt.core.client.EntryPoint, ClickHandler, AlertEvent.Handler
{
  @Override
  public void onModuleLoad()
  {
    Global.setRpcService((RpcServiceAsync) GWT.create(RpcService.class));
    Global.setEventBus(new GwtEventBus());
    Global.addHandler(AlertEvent.TYPE, this);

    addUi(RootPanel.get());
  }

  private void addUi(HasWidgets inHasWidgets)
  {
    HorizontalPanel panel = new HorizontalPanel();
    inHasWidgets.add(panel);

    Button sendButton = new Button("Send", this);
    panel.add(sendButton);

    TextBox nameField = new TextBox();
    nameField.setText("GWT User");
    panel.add(nameField);

    LoggerCommand command = new LoggerCommand(Level.DEBUG, "Application Started...");
    Global.fire(command, command);
  }

  @Override
  public void onClick(ClickEvent inEvent)
  {
    ServerInfoDataCommand command = new ServerInfoDataCommand();
    Global.fire(command, this);
  }

  @Override
  public void onRpcSuccess(ServerInfoDataCommand inResult)
  {
    PopupPanel panel = new PopupPanel(true, false);
    panel.add(new Label(inResult.getData(), false));
    panel.center();
  }

  @Override
  public void dispatch(AlertEvent inEvent)
  {
    Window.alert(inEvent.getMessage());
  }
}
