package net.hus.core.shared.components;

import java.io.Serializable;
import java.util.Arrays;

public class Response implements Serializable
{
  private static final long serialVersionUID = -2170096903629071259L;

  private String[] mData;

  public Response()
  {
  }

  public Response(String... inData)
  {
    mData = inData;
  }

  public String[] getData()
  {
    return mData;
  }

  public void setData(String... inData)
  {
    mData = inData;
  }

  @Override
  public String toString()
  {
    return "Response [mData=" + Arrays.toString(mData) + "]";
  }
}