package net.hus.core.client.ui.event;

import net.hus.core.shared.model.CssFileName;

public class CssChangeEvent extends Event<CssChangeEvent.Handler>
{
  public interface Handler extends EventHandler
  {
    void dispatch(CssChangeEvent inEvent);
  }

  public static final Type<Handler> TYPE = new Type<>();

  private final String mCssFileName;

  public CssChangeEvent(CssFileName inCssFileName)
  {
    this(inCssFileName.getFileName());
  }

  public CssChangeEvent(String inCssFileName)
  {
    mCssFileName = inCssFileName;
  }

  public String getCssFileName()
  {
    return mCssFileName;
  }

  public boolean isExternal()
  {
    return mCssFileName.startsWith("http");
  }

  @Override
  public Type<Handler> getAssociatedType()
  {
    return TYPE;
  }

  @Override
  protected void dispatch(Handler inHandler)
  {
    inHandler.dispatch(this);
  }
}