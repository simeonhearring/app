package net.hus.core.client.common;

import com.google.gwt.user.client.ui.IsWidget;

import net.hus.core.model.TableKey;

/**
 * Parent for all ui components.
 *
 * TODO consider renaming
 *
 * @author simeonhearring
 * @since October 2016
 *
 * @param <T>
 *          Type of ui object. i.e. Button, CheckBox.
 */
public interface View<T> extends IsWidget
{
  void setView(T inView);

  void setFieldName(String inName);

  void setTableKey(TableKey inTableKey);
}