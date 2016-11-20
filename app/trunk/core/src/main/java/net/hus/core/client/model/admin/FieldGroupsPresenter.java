package net.hus.core.client.model.admin;

import net.hus.core.client.model.admin.FieldGroupsDisplay.Action;

public class FieldGroupsPresenter implements Action
{
  private FieldGroupsDisplay mDisplay;

  public FieldGroupsPresenter(FieldGroupsDisplay inDisplay)
  {
    mDisplay = inDisplay;
    mDisplay.setAction(this);
  }
}