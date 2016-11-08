package net.hus.core.client.ui.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.ui.IsWidget;

import net.hus.core.client.common.Component;
import net.hus.core.client.common.UiCreate;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.FieldTKG;
import net.hus.core.shared.model.Value;

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
  protected Components<Object> get(String... inKey)
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

  /*
   * updates buttons.
   */
  public void update(FieldTKG inFieldTKG)
  {
    for (String value : mContent.keySet())
    {
      if (value != null && value.startsWith(Field.Component.BTN00_.name()))
      {
        get(value).makeClickable(inFieldTKG);
      }
    }
  }

  /*
   * updates field Label & field Value. add Field, TKG, & save label.
   */
  public void update(List<Value> inValues, FieldTKG inFieldTKG)
  {
    for (Value value : inValues)
    {
      update(value, inFieldTKG);
    }
  }

  private void update(Value inValue, FieldTKG inFieldTKG)
  {
    Field field = inValue.getField();

    String labelKey = Field.Component.FL00_.name() + field.getId();
    String valueKey = Field.Component.FV00_.name() + field.getId();

    get(labelKey).setValue(inValue.getLabel());
    if (field.isArray())
    {
      get(valueKey).setValue(inValue.getTable());
    }
    else
    {
      get(valueKey).setValue(inValue.getValue());
    }
    get(valueKey).makeSaveable(inValue.getLabel(), inFieldTKG, field);
  }
}