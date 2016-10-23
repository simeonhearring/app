package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.model.Icon_;

public class Icon_Parser extends ComplexWidget_Parser
{
  public Icon_Parser()
  {
    super();
    xs(this);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("Icon", Icon_.class);
    inXs.aliasAttribute(Icon_.class, "mType", "type");
    inXs.aliasAttribute(Icon_.class, "mSize", "size");
    inXs.aliasAttribute(Icon_.class, "mRotate", "rotate");
    inXs.aliasAttribute(Icon_.class, "mFlip", "flip");
    inXs.aliasAttribute(Icon_.class, "mEmphasis", "emphasis");
    inXs.aliasAttribute(Icon_.class, "mBorder", "border");
    inXs.aliasAttribute(Icon_.class, "mSpin", "spin");
    inXs.aliasAttribute(Icon_.class, "mPulse", "pulse");
    inXs.aliasAttribute(Icon_.class, "mInverse", "inverse");
    inXs.aliasAttribute(Icon_.class, "mStackTop", "stackTop");
    inXs.aliasAttribute(Icon_.class, "mStackBase", "stackBase");
    inXs.aliasAttribute(Icon_.class, "mFixedWidth", "fixedWidth");
  }
}