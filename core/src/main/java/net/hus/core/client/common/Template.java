package net.hus.core.client.common;

import com.google.gwt.user.client.ui.IsWidget;

import net.hus.core.model.Template.Section;

/**
 * Page layout separated by Sections to be filled with ui components.
 *
 * TODO Consider renaming
 *
 * @author simeonhearring
 * @since October 2016
 */
public interface Template extends Display
{
  void add(Section.Name inSection, IsWidget inWidget);

  void add(String inSection, IsWidget inWidget);
}