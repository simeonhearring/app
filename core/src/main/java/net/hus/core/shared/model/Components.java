package net.hus.core.shared.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.hus.core.model.FieldTKG;
import net.hus.core.model.Page.Section;
import net.hus.core.model.Value;

/**
 * Populated from XML (mFieldTKGs & mList). Values from database added after
 * (mValues).
 *
 * See Components on http://gwtbootstrap3.github.io/gwtbootstrap3-demo/
 *
 * See Lookup.Group.COMPONENTS
 *
 * @author simeonhearring
 * @since October 2016
 */
public class Components implements Serializable
{
  private static final long serialVersionUID = 1058892144882503748L;

  private List<FieldTKG> mFieldTKGs = new ArrayList<>();

  private List<UIObject_> mList = new ArrayList<>();

  private List<Value> mValues;

  public Map<Section.Name, List<UIObject_>> components()
  {
    Map<Section.Name, List<UIObject_>> ret = new HashMap<>();
    for (UIObject_ value : mList)
    {
      Section.Name section = value.getSection();
      if (section != null)
      {
        if (!ret.containsKey(section))
        {
          ret.put(section, new ArrayList<UIObject_>());
        }
        ret.get(section).add(value);
      }
    }
    return ret;
  }

  public void setValues(List<Value> inValues)
  {
    mValues = inValues;
  }

  public List<Value> getValues()
  {
    return mValues;
  }

  public List<ListBox_> getListBoxes()
  {
    List<ListBox_> ret = new ArrayList<>();
    find(ret, mList);
    return ret;
  }

  private static void find(List<ListBox_> inAddTo, List<UIObject_> inSearchingIn)
  {
    if (inSearchingIn != null)
    {
      for (UIObject_ value : inSearchingIn)
      {
        if (value instanceof ComplexPanel_)
        {
          find(inAddTo, ((ComplexPanel_) value).getCollection());
        }
        else if (value instanceof ListBox_)
        {
          inAddTo.add((ListBox_) value);
        }
      }
    }
  }

  public FieldTKG getFieldTKG()
  {
    return getFieldTKGs().get(0);
  }

  private List<FieldTKG> getFieldTKGs()
  {
    return mFieldTKGs;
  }
}