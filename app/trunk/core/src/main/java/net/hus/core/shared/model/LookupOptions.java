package net.hus.core.shared.model;

public interface LookupOptions
{
  void add(Lookup inLookup);

  Field.Lookup.Location getLocation();

  String[] getLookupGroups();
}