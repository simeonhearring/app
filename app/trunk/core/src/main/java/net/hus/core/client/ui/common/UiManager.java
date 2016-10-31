package net.hus.core.client.ui.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.ui.IsWidget;

import net.hus.core.client.common.Component;
import net.hus.core.client.common.UiCreate;
import net.hus.core.model.Field;
import net.hus.core.model.TableFvk;
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

  public void update(List<Value> inValues, TableFvk inTk)
  {
    for (Value value : inValues)
    {
      update(inTk, value, String.valueOf(value.getField().getId()));
      update(inTk, value, value.getField().getName());
    }
  }

  private void update(TableFvk inTk, Value inValue, String inFieldIdOrNme)
  {
    String labelKey = Field.Component.FL00_.name() + inFieldIdOrNme;
    String valueKey = Field.Component.FV00_.name() + inFieldIdOrNme;

    get(labelKey).setValue(inValue.getLabel());
    get(valueKey).setFieldNameTk(inValue.getLabel(), inTk);
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