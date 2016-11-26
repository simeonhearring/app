package net.hus.core.client.model.page;

import net.hus.core.client.common.PageDisplay;
import net.hus.core.client.model.select.SelectFVKDisplay;

public interface WebDisplay extends PageDisplay
{
  SelectFVKDisplay getSelect();
}