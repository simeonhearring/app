package net.hus.core.client.ui.admin;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.model.admin.FieldGroupsDisplay;
import net.hus.core.client.ui.common.AbstractView;
import net.hus.core.shared.model.Page.Section.Name;

public class FieldGroupsView extends AbstractView implements FieldGroupsDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, FieldGroupsView>
  {
  }

  private Action mAction;

  public FieldGroupsView()
  {
    initWidget(BINDER.createAndBindUi(this));
  }

  @Override
  public void setAction(Action inAction)
  {
    mAction = inAction;
  }

  @Override
  public void add(Name inSection, IsWidget inComponent)
  {
    // do nothing
  }
}