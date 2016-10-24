package net.hus.core.client.ui.template;

import org.gwtbootstrap3.client.ui.Column;
import org.gwtbootstrap3.client.ui.Row;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.model.template.BlogDisplay;
import net.hus.core.client.ui.common.AbstractView;
import net.hus.core.model.Template.Section;

public class BlogView extends AbstractView implements BlogDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, BlogView>
  {
  }

  @UiField
  Row mRow;

  @UiField
  Column mBlogL01, mBlogC01;

  public BlogView()
  {
    initWidget(BINDER.createAndBindUi(this));

    mBlogL01.setId(Section.Name.BLOGL01.name());
    mBlogC01.setId(Section.Name.BLOGC01.name());
  }

  @Override
  public void add(Section.Name inSection, IsWidget inWidget)
  {
    add(inSection.name(), inWidget);
  }

  @Override
  public void add(String inSection, IsWidget inWidget)
  {
    Column column = (Column) find(inSection, mRow);
    column.add(inWidget);
  }
}