package net.hus.core.shared.components;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.hus.core.shared.model.FieldTKG;
import net.hus.core.shared.model.LookupOptions;
import net.hus.core.shared.model.Page.Section;
import net.hus.core.shared.model.Value;

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

  public List<LookupOptions> getLookupOptions()
  {
    List<LookupOptions> ret = new ArrayList<>();
    find(ret, mList);
    return ret;
  }

  private static void find(List<LookupOptions> inAddTo, List<UIObject_> inSearchingIn)
  {
    if (inSearchingIn != null)
    {
      for (UIObject_ value : inSearchingIn)
      {
        if (value instanceof ComplexPanel_)
        {
          find(inAddTo, ((ComplexPanel_) value).getCollection());
        }
        else if (value instanceof LookupOptions)
        {
          inAddTo.add((LookupOptions) value);
        }
      }
    }
  }

  public FieldTKG getFieldTKG()
  {
    return mFieldTKGs.get(0);
  }

  public enum Type
  {
    ALERT,
    BADGE,
    BUTTON,
    CHECKBOX,
    COLUMN,
    DATE_PICKER,
    FIELD_SET,
    FLEX_TABLE,
    FORM_GROUP,
    FORM_LABEL,
    HEADING,
    ICON,
    INPUT,
    LABEL,
    LIST_BOX,
    PANEL,
    PANEL_BODY,
    PANEL_FOOTER,
    PANEL_HEADER,
    ROW,
    TEXT_BOX,
    TYPEAHEAD;

    public String display()
    {
      return null;
    }
  }
}