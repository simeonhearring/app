package net.hus.core.client.ui.event;

import net.hus.core.shared.model.FieldTKG;
import net.hus.core.shared.model.Values;

public class ValuesEvent extends Event<ValuesEvent.Handler>
{
  public interface Handler extends EventHandler
  {
    void dispatch(ValuesEvent inEvent);
  }

  public static final Type<Handler> TYPE = new Type<>();

  private final FieldTKG mTKG;
  private final Values mValues;

  public ValuesEvent(FieldTKG inTKG, Values inValues)
  {
    mTKG = inTKG;
    mValues = inValues;
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

  public FieldTKG getTKG()
  {
    return mTKG;
  }

  public Values getValues()
  {
    return mValues;
  }
}