package net.hus.core.client.common;

public interface Callback<T>
{
  void onDone(T inValue);
}