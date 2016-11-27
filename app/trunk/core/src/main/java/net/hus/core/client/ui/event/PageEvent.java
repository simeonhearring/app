package net.hus.core.client.ui.event;

import net.hus.core.shared.model.PageQuery;

public class PageEvent extends Event<PageEvent.Handler>
{
  public interface Handler extends EventHandler
  {
    void dispatch(PageEvent inEvent);
  }

  public static final Type<Handler> TYPE = new Type<>();

  private final PageQuery mPageQuery;

  public PageEvent(PageQuery inPageQuery)
  {
    mPageQuery = inPageQuery;
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

  public PageQuery getPageQuery()
  {
    return mPageQuery;
  }
}