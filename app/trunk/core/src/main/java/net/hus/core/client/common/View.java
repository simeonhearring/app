package net.hus.core.client.common;

import com.google.gwt.user.client.ui.IsWidget;

public interface View<T> extends IsWidget
{
  void setView(T inView);

  void setFieldName(String inName);
}