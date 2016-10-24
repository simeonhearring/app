package net.hus.core.client.model;

import com.google.gwt.user.client.ui.IsWidget;

import net.hus.core.shared.model.UIObject_;

public interface UiConverter
{
  IsWidget match(UIObject_ inUiO);
}