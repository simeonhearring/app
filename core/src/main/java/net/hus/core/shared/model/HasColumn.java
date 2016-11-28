package net.hus.core.shared.model;

import java.util.List;

public interface HasColumn<T>
{
  List<T> getColumn();

  boolean add(UIObject_ inObject);
}