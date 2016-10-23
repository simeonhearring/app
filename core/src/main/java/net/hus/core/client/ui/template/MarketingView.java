package net.hus.core.client.ui.template;

import org.gwtbootstrap3.client.ui.Column;
import org.gwtbootstrap3.client.ui.Row;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.model.template.MarketingDisplay;
import net.hus.core.client.ui.common.AbstractView;
import net.hus.core.model.Template.Section;

public class MarketingView extends AbstractView implements MarketingDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, MarketingView>
  {
  }

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

    mMarR1L01.setId("MARR1L01");
    mMarR1C01.setId("MARR1C01");
    mMarR201.setId("MARR201");
    mMarR202.setId("MARR202");
    mMarR203.setId("MARR203");
    mMarR204.setId("MARR204");
    mMarR301.setId("MARR301");
    mMarR302.setId("MARR302");
    mMarR303.setId("MARR303");
    mMarR304.setId("MARR304");
    mMarR305.setId("MARR305");
    mMarR306.setId("MARR306");
  }

  @Override
  public void add(Section.Name inSection, IsWidget inWidget)
  {
    Column column = (Column) find(inSection.name(), mRow1, mRow2, mRow3);
    column.add(inWidget);
  }
}