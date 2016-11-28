package net.hus.core.shared.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
public class Components extends AbstractModel implements Serializable, LookupXL
{
  private static final long serialVersionUID = 1058892144882503748L;

  private List<FieldTKG> mFieldTKGs = new ArrayList<>();

  private List<UIObject_> mList = new ArrayList<>();

  private List<Value> mValues;

  private Map<Integer, UIObject_> mJsonMap;
  private int mJsonCount;

  private String mName;
  private String mDisplay;

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

  public String toJson()
  {
    mJsonCount = 0;
    mJsonMap = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    json(getList(), sb);
    return sb.toString();
  }

  public UIObject_ get(int inNodeId)
  {
    return mJsonMap.get(inNodeId);
  }

  public int get(String inKey)
  {
    int ret = 0;
    for (Entry<Integer, UIObject_> value : mJsonMap.entrySet())
    {
      if (inKey.equals(value.getValue().getKey()))
      {
        ret = value.getKey().intValue();
      }
    }
    return ret;
  }

  @SuppressWarnings(
      {
        "unchecked",
        "rawtypes"
      })
  private <C extends UIObject_> void json(List<C> inList, StringBuilder inSb)
  {
    inSb.append("[");

    boolean notFirst = false;

    for (UIObject_ value : inList)
    {
      String simpleName = value.getSimpleName();
      mJsonMap.put(mJsonCount++, value);

      if (notFirst)
      {
        inSb.append(",");
      }
      notFirst = true;

      inSb.append("{\"text\":").append(" \"" + simpleName + "\"");

      if (value instanceof HasColumn<?>)
      {
        collection(inSb, ((HasColumn) value).getColumn());
      }
      else if (value instanceof HasCollection<?>)
      {
        collection(inSb, ((HasCollection) value).getCollection());
      }
      else
      {
        inSb.append(",\"tags\": [\"0\"]");
      }
      inSb.append("}");
    }

    inSb.append("]");
  }

  private <C extends UIObject_> void collection(StringBuilder inSb, List<C> inCollection)
  {
    if (inCollection != null && inCollection.size() != 0)
    {
      inSb.append(",\"tags\": [\"").append(inCollection.size()).append("\"]");
      inSb.append(",\"nodes\": ");
      json(inCollection, inSb);
    }
    else
    {
      inSb.append(",\"tags\": [\"0\"]");
    }
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

  public FieldTKG initTKG()
  {
    FieldTKG ret = new FieldTKG();
    mFieldTKGs.add(ret);
    return ret;
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
    HR,
    BR,
    ROW,
    TEXT_BOX,
    TYPEAHEAD,
    CONTAINER,
    ITEM;

    @Override
    public String display()
    {
      return StringUtil.toTitle(name().replaceAll("_", " ")).replaceAll(" ", "");
    }
  }

  public List<UIObject_> getList()
  {
    if (mList == null)
    {
      mList = new ArrayList<>();
    }
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
    return getName();
  }

  @Override
  public String displayXL()
  {
    return getDisplay();
  }

  public String getName()
  {
    return mName;
  }

  public void setName(String inName)
  {
    mName = inName;
  }

  public String getDisplay()
  {
    return mDisplay;
  }

  public void setDisplay(String inDisplay)
  {
    mDisplay = inDisplay;
  }
}