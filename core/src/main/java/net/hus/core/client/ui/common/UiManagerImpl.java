package net.hus.core.client.ui.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.ui.IsWidget;

import net.hus.core.client.common.View;
import net.hus.core.client.model.UiManager;
import net.hus.core.model.Field;
import net.hus.core.model.Value;

public class UiManagerImpl extends UiConverterImpl implements UiManager
{
  private Map<String, IsWidget> mContent = new HashMap<>();

  @Override
  public void add(String inKey, IsWidget inUiO)
  {
    mContent.put(inKey, inUiO);
  }

  @SuppressWarnings("unchecked")
  @Override
  public Views<Object> get(String... inKey)
  {
    Views<Object> ret = new Views<>();
    for (String key : inKey)
    {
      IsWidget uiobject = mContent.get(key);
      if (uiobject != null && uiobject instanceof View<?>)
      {
        ret.add((View<Object>) uiobject);
      }
    }
    return ret;
  }

  @Override
  public void update(List<Value> inValues)
  {
    for (Value value : inValues)
    {
      Long fieldId = value.getField().getId();
      String labelKey = Field.Component.FL00_.name() + fieldId;
      String valueKey = Field.Component.FV00_.name() + fieldId;

      get(labelKey).setViews(value.getLabel());
      get(valueKey).setName(value.getLabel());
      if (value.getField().isArray())
      {
        get(valueKey).setViews(value.getTable());
      }
      else
      {
        get(valueKey).setViews(value.getValue());
      }
    }
  }
}