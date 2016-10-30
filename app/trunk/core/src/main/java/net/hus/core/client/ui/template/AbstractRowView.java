package net.hus.core.client.ui.template;

import org.gwtbootstrap3.client.ui.Column;
import org.gwtbootstrap3.client.ui.Row;

import com.google.gwt.user.client.ui.IsWidget;

import net.hus.core.client.ui.common.AbstractView;
import net.hus.core.model.Template.Section;

public abstract class AbstractRowView extends AbstractView
{
  public abstract Row[] getRow();

  public void add(Section.Name inSection, IsWidget inWidget)
  {
    add(inSection.name(), inWidget);
  }

  public void add(String inSection, IsWidget inWidget)
  {
    Column column = (Column) find(inSection, getRow());
    column.add(inWidget);
  }
}
