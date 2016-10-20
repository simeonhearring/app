package net.hus.core.shared.command;

@SuppressWarnings("serial")
public abstract class AbstractDataCommand<T> extends AbstractCommand
{
  T mData;

  public void setData(T inData)
  {
    mData = inData;
  }

  public T getData()
  {
    return mData;
  }
}
