package net.hus.core.client.ui.home;

import org.gwtbootstrap3.client.ui.Carousel;
import org.gwtbootstrap3.client.ui.CarouselControl;
import org.gwtbootstrap3.client.ui.CarouselIndicator;
import org.gwtbootstrap3.client.ui.CarouselIndicators;
import org.gwtbootstrap3.client.ui.Heading;
import org.gwtbootstrap3.client.ui.Image;
import org.gwtbootstrap3.client.ui.html.Paragraph;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.model.home.CarouselDisplay;

public class CarouselView extends Composite implements CarouselDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, CarouselView>
  {
  }

  @UiField
  Image mImg1, mImg2, mImg3, mImg4;

  @UiField
  Heading mHead1, mHead2, mHead3, mHead4;

  @UiField
  Paragraph mPar1, mPar2, mPar3, mPar4;

  @UiField
  CarouselControl mLeft, mRight;

  @UiField
  CarouselIndicators mIndicators;

  @UiField
  Carousel mCarousel;

  @UiField
  CarouselIndicator mInd0, mInd1, mInd2, mInd3;

  public CarouselView()
  {
    initWidget(BINDER.createAndBindUi(this));
  }

  public void setUniqueId(String inId)
  {
    mCarousel.setId(inId);
    String dataTarget = "#" + inId;
    mInd0.setDataTarget(dataTarget);
    mInd1.setDataTarget(dataTarget);
    mInd2.setDataTarget(dataTarget);
    mInd3.setDataTarget(dataTarget);
    mLeft.setDataTarget(dataTarget);
    mRight.setDataTarget(dataTarget);
  }

  @Override
  public void setIndicatorsVisible(boolean inVisible)
  {
    mIndicators.setVisible(inVisible);
  }

  @Override
  public void setControlsVisible(boolean inVisible)
  {
    mLeft.setVisible(inVisible);
    mRight.setVisible(inVisible);
  }
}