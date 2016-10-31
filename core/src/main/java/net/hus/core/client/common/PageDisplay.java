package net.hus.core.client.common;

import com.google.gwt.user.client.ui.IsWidget;

import net.hus.core.model.Page.Section;

/**
 * Page layout separated by Sections to be filled with Components.
 *
 * @author simeonhearring
 * @since October 2016
 */
public interface PageDisplay extends Display
{
  void add(Section.Name inSection, IsWidget inComponent);

  void add(String inSection, IsWidget inComponent);
}