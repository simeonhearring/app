package net.hus.core.shared.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.hus.core.shared.model.Lookup.Group;
import net.hus.core.shared.model.Page.Section;
import net.hus.core.shared.util.StringUtil;

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
public class Components implements Serializable, LookupXL
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

  public FieldTKG getFieldTKG()
  {
    return mFieldTKGs.get(0);
  }

  public enum Type implements EnumDisplay
  {
    ALERT,
    BADGE,
    BUTTON,
    CHECK_BOX,
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

    @Override
    public String display()
    {
      return StringUtil.toTitle(name().replaceAll("_", " ")).replaceAll(" ", "");
    }
  }

  public List<UIObject_> getList()
  {
    return mList;
  }

  @Override
  public Group groupXL()
  {
    return Group.COMPONENTS;
  }

  @Override
  public String nameXL()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String displayXL()
  {
    // TODO Auto-generated method stub
    return null;
  }
}