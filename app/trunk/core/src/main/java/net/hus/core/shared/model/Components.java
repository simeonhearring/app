package net.hus.core.shared.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.hus.core.model.Page.Section;
import net.hus.core.model.TableFvk;
import net.hus.core.model.Value;

public class Components implements Serializable
{
  private static final long serialVersionUID = 1058892144882503748L;

  private List<TableFvk> mTableFvks = new ArrayList<>();

  private List<UIObject_> mList = new ArrayList<>();

  private List<Value> mValues;

  public void add(UIObject_ inUiO)
  {
    mList.add(inUiO);
  }

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

  private void find(List<ListBox_> inListBoxes, List<UIObject_> inSearching)
  {
    if (inSearching != null)
    {
      for (UIObject_ value : inSearching)
      {
        if (value instanceof ComplexPanel_)
        {
          find(inListBoxes, ((ComplexPanel_) value).getCollection());
        }
        else if (value instanceof ListBox_)
        {
          inListBoxes.add((ListBox_) value);
        }
      }
    }
  }

  public TableFvk getTableFvk()
  {
    return getTableFvks().get(0);
  }

  public List<TableFvk> getTableFvks()
  {
    return mTableFvks;
  }

  public void setTableFvks(List<TableFvk> inTableKeys)
  {
    mTableFvks = inTableKeys;
  }
}