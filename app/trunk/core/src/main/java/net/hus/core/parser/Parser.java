package net.hus.core.parser;

public interface Parser<M>
{
  M fromXml(String inValue);

  String toXml(M inObj);
}