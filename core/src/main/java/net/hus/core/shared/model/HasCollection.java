package net.hus.core.shared.model;

import java.util.List;

public interface HasCollection<T>
{
  List<T> getCollection();

  boolean add(UIObject_ inUiObject);
}
