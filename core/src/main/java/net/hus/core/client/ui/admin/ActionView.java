package net.hus.core.client.ui.admin;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.model.admin.ActionDisplay;
import net.hus.core.client.ui.common.AbstractView;

public class ActionView extends AbstractView implements ActionDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, ActionView>
  {
  }

  public ActionView()
  {
    initWidget(BINDER.createAndBindUi(this));
  }
}