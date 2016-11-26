package net.hus.core.client.ui.manage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.ui.IsWidget;

import net.hus.core.client.common.UiCreate;
import net.hus.core.client.common.View;
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
  public void add(String inUiObjectKey, IsWidget inUiO)
  {
    mContent.put(inUiObjectKey, inUiO);
  }

  protected UiObjects get(String... inUiObjectKey)
  {
    UiObjects ret = new UiObjects();
    for (String uiobjectkey : inUiObjectKey)
    {
      IsWidget uiobject = mContent.get(uiobjectkey);
      if (uiobject != null && uiobject instanceof View)
      {
        ret.add((View) uiobject);
      }
    }
    return ret;
  }

  public void manage(FieldTKG inFieldTKG, List<Value> inValues)
  {
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

  // TODO does makeSaveable need to be called each time Value is set?
  private void update(Value inValue, FieldTKG inFieldTKG)
  {
    Field field = inValue.getField();

    String labelKey = Field.Component.FL00_.name() + field.getId();
    get(labelKey).setValue(inValue);

    String valueKey = Field.Component.FV00_.name() + field.getId();

    // TODO should field be set first for Array/FlexTable?
    get(valueKey).setValue(inValue);
    get(valueKey).makeSaveable(inValue.getLabel(), inFieldTKG, field);
  }
}