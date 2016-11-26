package net.hus.core.client.model.select;

import java.util.List;

import net.hus.core.client.common.Display;
import net.hus.core.shared.model.Lookup;

public interface SelectFVKDisplay extends Display
{
  public interface Action
  {
    void select(String inValue);
  }

  void setAction(Action inAction);

  void addKeys(List<Lookup> inKeys);
}