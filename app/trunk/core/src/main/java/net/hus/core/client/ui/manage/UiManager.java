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

  /*
   * updates field Label & field Value. add Field, TKG, & save label.
   */
  @Override
  public void update(List<Value> inValues, FieldTKG inFieldTKG)
  {
    if (inValues != null)
    {
      for (Value value : inValues)
      {
        update(value, inFieldTKG);
      }
    }
  }

  // TODO does makeSaveable need to be called each time Value is set? remember
  // each field WILL have a value.
  private void update(Value inValue, FieldTKG inFieldTKG)
  {
    Field field = inValue.getField();

    String labelKey = Field.Component.FL00_.name() + field.getId() + "_" + inValue.getPos();
    get(labelKey).setValue(inValue);

    String valueKey = Field.Component.FV00_.name() + field.getId() + "_" + inValue.getPos();

    get(valueKey).addField(inValue.getLabel(), inFieldTKG, field, inValue.getPos());
    get(valueKey).setValue(inValue);
    get(valueKey).makeSaveable();
  }

  public void setValue(String inKey, Value inValue)
  {
    get(inKey).setValue(inValue);
  }

  @Override
  public void addField(String inValueKey, String inLabel, FieldTKG inTKG, Field inField, int inPos)
  {
    get(inValueKey).addField(inLabel, inTKG, inField, inPos);
  }

  @Override
  public void makeSavable(String inKey)
  {
    get(inKey).makeSaveable();
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
}