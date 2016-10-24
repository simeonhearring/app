package net.hus.core.client.ui.template;

import org.gwtbootstrap3.client.ui.Column;
import org.gwtbootstrap3.client.ui.Row;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.model.template.WebPageDisplay;
import net.hus.core.client.ui.common.AbstractView;
import net.hus.core.model.Template.Section;

public class WebPageView extends AbstractView implements WebPageDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, WebPageView>
  {
  }

  @UiField
  Row mRow;

  @UiField
  Column mWebL01, mWebC01, mWebR01;

  public WebPageView()
  {
    initWidget(BINDER.createAndBindUi(this));

    mWebL01.setId(Section.Name.WEBL01.name());
    mWebC01.setId(Section.Name.WEBC01.name());
    mWebR01.setId(Section.Name.WEBR01.name());
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