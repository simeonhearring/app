package net.hus.core.client.model.page;

import net.hus.core.client.common.PageDisplay;
import net.hus.core.client.model.select.SelectFVKDisplay;

public interface FVKDisplay extends PageDisplay
{
  SelectFVKDisplay getSelect();
}