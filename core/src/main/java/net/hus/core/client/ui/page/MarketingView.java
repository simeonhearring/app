package net.hus.core.client.ui.page;

import org.gwtbootstrap3.client.ui.Column;
import org.gwtbootstrap3.client.ui.Row;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.model.page.MarketingDisplay;
import net.hus.core.client.model.select.SelectFVKDisplay;
import net.hus.core.client.ui.select.SelectFVKView;

public class MarketingView extends AbstractRowView implements MarketingDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, MarketingView>
  {
  }

  @UiField
  SelectFVKView mSelect;

  @UiField
  Row mRow1;

  @UiField
  Row mRow2;

  @UiField
  Row mRow3;

  @UiField
  Column mMarR1L01, mMarR1C01, mMarR201, mMarR202, mMarR203, mMarR204, mMarR301, mMarR302, mMarR303,
  mMarR304, mMarR305, mMarR306;

  public MarketingView()
  {
    initWidget(BINDER.createAndBindUi(this));
  }

  @Override
  public Row[] getRow()
  {
    return new Row[]
        {
            mRow1,
            mRow2,
            mRow3
        };
  }

  @Override
  public SelectFVKDisplay getSelect()
  {
    return mSelect;
  }
}