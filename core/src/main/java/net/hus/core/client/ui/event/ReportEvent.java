package net.hus.core.client.ui.event;

public class ReportEvent extends Event<ReportEvent.Handler>
{
  public interface Handler extends EventHandler
  {
    void dispatch(ReportEvent inEvent);
  }

  public static final Type<Handler> TYPE = new Type<>();

  private final String mName;

  public ReportEvent(String inName)
  {
    mName = inName;
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

  public String getName()
  {
    return mName;
  }
}