package net.hus.core.client.common;

import com.google.gwt.user.client.ui.IsWidget;

import net.hus.core.model.TableFvk;

/**
 * Parent for all Model View UI Components wrappers.
 *
 * @author simeonhearring
 * @since October 2016
 *
 * @param <V>
 *          Data type of value set in component. i.e. String, Integer, Array.
 */
public interface Component<V> extends IsWidget
{
  void setValue(V inValue);

  void setLabel(String inLabel);

  void setTableKey(TableFvk inTFvk);
}