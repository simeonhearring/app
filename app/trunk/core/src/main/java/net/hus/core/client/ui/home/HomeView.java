package net.hus.core.client.ui.home;

import org.gwtbootstrap3.client.ui.Column;
import org.gwtbootstrap3.client.ui.Row;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.model.home.HomeDisplay;
import net.hus.core.client.ui.page.AbstractRowView;
import net.hus.core.shared.model.Page.Section;

public class HomeView extends AbstractRowView implements HomeDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, HomeView>
  {
  }

  @UiField
  Row mRow0;

  @UiField
  Column mL01, mC01, mR01;

  @UiField
  CarouselView mCarousel;

  public HomeView()
  {
    initWidget(BINDER.createAndBindUi(this));
    mC01.setId(Section.Name.ADMINC01.name());

    // about
    // mCarousel.mImg1.setUrl("img/header3.jpg");
    // mCarousel.mImg2.setUrl("img/header5.jpg");
    // mCarousel.mImg3.setUrl("img/header6.jpg");
    // mCarousel.mImg4.setUrl("img/header2.jpg");

    // home
    mCarousel.mImg1.setUrl("img/header1.jpg");
    mCarousel.mImg2.setUrl("img/header8.jpg");
    mCarousel.mImg3.setUrl("img/header9.jpg");
    mCarousel.mImg4.setUrl("img/header7.jpg");
  }

  @Override
  public Row[] getRow()
  {
    Row[] ret =
      {
          mRow0
      };
    return ret;
  }
}