package net.hus.core.client.model.admin;

import org.gwtbootstrap3.client.ui.constants.IconType;

import net.hus.core.client.common.Callback;

public interface ActionDisplay
{
  void setCallback(Callback<IconType> inCallback);
}