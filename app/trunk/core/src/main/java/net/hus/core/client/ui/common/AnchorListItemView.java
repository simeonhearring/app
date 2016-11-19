package net.hus.core.client.ui.common;

import org.gwtbootstrap3.client.ui.AnchorListItem;
import org.gwtbootstrap3.client.ui.constants.ButtonSize;
import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.client.ui.constants.Toggle;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.Event;

import net.hus.core.client.model.common.AnchorListItemDisplay;

/**
 * LEGACY
 */
public class AnchorListItemView extends AbstractView implements AnchorListItemDisplay
{
  AnchorListItem mAnchor;

  public AnchorListItemView(AnchorListItem inAnchor)
  {
    mAnchor = inAnchor;
  }

  @Override
  public void setActive(boolean inActive)
  {
    mAnchor.setActive(inActive);
  }

  @Override
  public boolean isSource(Event<?> inEvent)
  {
    return mAnchor.getWidget(0).equals(inEvent.getSource());
  }

  @Override
  public HandlerRegistration addClickHandler(ClickHandler inHandler)
  {
    return mAnchor.addClickHandler(inHandler);
  }

  @Override
  public void setText(String inText)
  {
    mAnchor.setText(inText);
  }

  public void setIcon(IconType inIconType)
  {
    mAnchor.setIcon(inIconType);
  }

  @Override
  public void setEnabled(boolean inEnabled)
  {
    mAnchor.setEnabled(inEnabled);
  }

  @Override
  public boolean isEnabled()
  {
    return mAnchor.isEnabled();
  }

  @Override
  public Widget asWidget()
  {
    return mAnchor;
  }

  @Override
  public boolean isVisible()
  {
    return mAnchor.isVisible();
  }

  @Override
  public void setVisible(boolean inVisible)
  {
    mAnchor.setVisible(inVisible);
  }

  @Override
  public String getText()
  {
    return mAnchor.getText();
  }

  @Override
  public void setSize(ButtonSize inSize)
  {
  }

  @Override
  public void setDataToggle(Toggle inToggle)
  {
    mAnchor.setDataToggle(inToggle);
  }
}