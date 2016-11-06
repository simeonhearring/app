package net.hus.core.client.ui.page;

import org.gwtbootstrap3.client.ui.Column;
import org.gwtbootstrap3.client.ui.Row;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.model.page.WebDisplay;
import net.hus.core.shared.model.Page.Section;

public class WebView extends AbstractRowView implements WebDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, WebView>
  {
  }

  @UiField
  Row mRow;

  @UiField
  Column mL01, mC01, mR01;

  public WebView()
  {
    initWidget(BINDER.createAndBindUi(this));

    mL01.setId(Section.Name.WEBL01.name());
    mC01.setId(Section.Name.WEBC01.name());
    mR01.setId(Section.Name.WEBR01.name());
  }

  @Override
  public Row[] getRow()
  {
    return new Row[]
        {
            mRow
        };
  }
}