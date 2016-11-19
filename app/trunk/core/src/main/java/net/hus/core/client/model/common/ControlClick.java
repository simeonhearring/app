package net.hus.core.client.model.common;

import org.gwtbootstrap3.client.ui.constants.ButtonSize;
import org.gwtbootstrap3.client.ui.constants.Toggle;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;

/**
 * LEGACY
 */
public interface ControlClick extends Control, Source
{
  HandlerRegistration addClickHandler(ClickHandler inHandler);

  void setSize(ButtonSize inSize);

  void setDataToggle(Toggle inToggle);
}