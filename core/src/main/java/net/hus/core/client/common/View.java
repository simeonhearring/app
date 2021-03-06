package net.hus.core.client.common;

import com.google.gwt.user.client.ui.IsWidget;

import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.FieldTKG;
import net.hus.core.shared.model.Value;

/**
 * Parent for all Model View UI Components wrappers.
 *
 * @author simeonhearring
 * @since October 2016
 *
 * @param <V>
 *          Data type of value set in component. i.e. String, Integer, Array.
 */
public interface View extends IsWidget
{
  void setLabel(String inLabel);

  void setValue(Value inValue);

  void setFieldTKG(FieldTKG inFieldTKG);

  void setField(Field inField);

  void setPos(int inPos);

  void addChangeHandler();

  IsWidget getComponent();
}