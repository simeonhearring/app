package net.hus.core.client.ui.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.ui.IsWidget;

import net.hus.core.client.common.Component;
import net.hus.core.client.common.UiCreate;
import net.hus.core.model.Field;
import net.hus.core.model.FieldTKG;
import net.hus.core.model.Value;

/**
 * Responsible for adding and updating all UI Objects.
 *
 * @author simeonhearring
 * @since October 2016
 */
public class UiManager extends UiConverter
{
  private Map<String, IsWidget> mContent = new HashMap<>();

  public UiManager(UiCreate inUiCreate)
  {
    super(inUiCreate);
  }

  @Override
  public void add(String inKey, IsWidget inUiO)
  {
    mContent.put(inKey, inUiO);
  }

  @SuppressWarnings("unchecked")
  public Components<Object> get(String... inKey)
  {
    Components<Object> ret = new Components<>();
    for (String key : inKey)
    {
      IsWidget uiobject = mContent.get(key);
      if (uiobject != null && uiobject instanceof Component<?>)
      {
        ret.add((Component<Object>) uiobject);
      }
    }
    return ret;
  }

  public void update(FieldTKG inFvk)
  {
    for (String value : mContent.keySet())
    {
      if (value != null && value.startsWith(Field.Component.BTN00_.name()))
      {
        get(value).setFvk(inFvk);
      }
    }
  }

  public void update(List<Value> inValues, FieldTKG inFvk)
  {
    for (Value value : inValues)
    {
      update(inFvk, value, value.getField());
    }
  }

  private void update(FieldTKG inFvk, Value inValue, Field inField)
  {
    String labelKey = Field.Component.FL00_.name() + inField.getId();
    String valueKey = Field.Component.FV00_.name() + inField.getId();

    get(labelKey).setValue(inValue.getLabel());
    get(valueKey).setFieldNameTk(inValue.getLabel(), inFvk, inField);
    if (inValue.getField().isArray())
    {
      get(valueKey).setValue(inValue.getTable());
    }
    else
    {
      get(valueKey).setValue(inValue.getValue());
    }
  }
}