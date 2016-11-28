package net.hus.core.client.common;

import org.gwtbootstrap3.client.ui.constants.IconType;

/**
 *
 *
 * @author simeonhearring
 * @since November 2016
 */
public interface UIObjectDisplay extends Display
{
  void setCallback(Callback<IconType> inCallback);
}