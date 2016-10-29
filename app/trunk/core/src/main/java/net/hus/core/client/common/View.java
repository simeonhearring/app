package net.hus.core.client.common;

import com.google.gwt.user.client.ui.IsWidget;

import net.hus.core.model.TableKey;

public interface View<T> extends IsWidget
{
  void setView(T inView);

  void setFieldName(String inName);

  void setTableKey(TableKey inTableKey);
}