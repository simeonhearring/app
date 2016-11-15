package net.hus.core.client.model.admin;

import java.util.List;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;

import net.hus.core.client.common.PageDisplay;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.Lookup;

public interface FieldsDisplay extends PageDisplay
{
  void add(String inType, List<Lookup> inFields);

  void add(Field inField);

  void refresh();

  void addValueChangeHandler(ValueChangeHandler<String> inHandler);

  Long getFieldId(ValueChangeEvent<String> inEvent);

  void clear();
}