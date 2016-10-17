package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.mapper.MapperWrapper;

public class XStreamOmitMissingFields extends XStream
{
  public XStreamOmitMissingFields()
  {
    super();
  }

  @Override
  protected MapperWrapper wrapMapper(MapperWrapper inNext)
  {
    return new MapperWrapper(inNext)
    {
      @SuppressWarnings("rawtypes")
      @Override
      public boolean shouldSerializeMember(Class inDefinedIn, String inFieldName)
      {
        if (inDefinedIn == Object.class)
        {
          return false;
        }
        return super.shouldSerializeMember(inDefinedIn, inFieldName);
      }
    };
  }
}