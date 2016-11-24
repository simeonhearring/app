package net.hus.core.shared.components;

import net.hus.core.shared.model.Components.Type;

public class FormLabel_ extends AbstractTextWidget_
{
  private static final long serialVersionUID = 4179924023334732030L;

  private Boolean mShowRequiredIndicator;

  @Override
  public Type cType()
  {
    return Type.FORM_LABEL;
  }

  public Boolean getShowRequiredIndicator()
  {
    return mShowRequiredIndicator;
  }

  public void setShowRequiredIndicator(Boolean inShowRequiredIndicator)
  {
    mShowRequiredIndicator = inShowRequiredIndicator;
  }
}