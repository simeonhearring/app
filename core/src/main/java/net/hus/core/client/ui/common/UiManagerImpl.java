package net.hus.core.client.ui.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.gwtbootstrap3.client.ui.TextBox;

import com.google.gwt.user.client.ui.IsWidget;

import net.hus.core.client.common.View;
import net.hus.core.client.model.UiManager;
import net.hus.core.client.ui.TextBox_View;
import net.hus.core.model.Field;
import net.hus.core.model.Value;

public class UiManagerImpl extends UiConverterImpl implements UiManager
{
  private Map<String, IsWidget> mContent = new HashMap<>();

  @Override
  public void add(String inKey, IsWidget inUiO)
  {
    if (inUiO instanceof TextBox)
    {
      TextBox_View uio = new TextBox_View((TextBox) inUiO);
      mContent.put(inKey, uio);
    }
    else
    {
      mContent.put(inKey, inUiO);
    }
  }

  @Override
  public Views get(String... inKey)
  {
    Views ret = new Views();
    for (String key : inKey)
    {
      IsWidget uiobject = mContent.get(key);
      if (uiobject != null && uiobject instanceof View)
      {
        ret.add((View) uiobject);
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
      get(valueKey).setViews(value.getValue());
    }
  }
}