package net.hus.core.shared.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Components implements Serializable
{
  private static final long serialVersionUID = 1058892144882503748L;

  private List<UIObject_> mList = new ArrayList<>();

  public void add(UIObject_ inUiO)
  {
    mList.add(inUiO);
  }

  public Map<String, List<UIObject_>> components()
  {
    Map<String, List<UIObject_>> ret = new HashMap<>();
    for (UIObject_ value : mList)
    {
      String section = value.getSection();
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
}