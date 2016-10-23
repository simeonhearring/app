package net.hus.core.client.common;

import com.google.gwt.user.client.ui.IsWidget;

import net.hus.core.model.Template.Section;

public interface Template extends Display
{
  void add(Section.Name inSection, IsWidget inWidget);
}