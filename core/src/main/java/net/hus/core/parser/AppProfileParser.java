package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.model.AbstractModel;
import net.hus.core.shared.model.AppProfile;

public class AppProfileParser extends XStream implements Parser<AppProfile>
{
  public AppProfileParser()
  {
    alias("Profile", AppProfile.class);
    aliasField("Page", AppProfile.class, "mPage");
    omitField(AppProfile.class, "mFvk");

    xs((Parser<AppProfile>) this);
  }

  @Override
  public AppProfile fromXml(String inValue)
  {
    return (AppProfile) super.fromXML(inValue);
  }

  @Override
  public String toXml(AppProfile inObj)
  {
    return super.toXML(inObj);
  }

  @Override
  public void xs(Parser<AppProfile> inParser)
  {
    xs((XStream) this);
  }

  public static void xs(XStream inXs)
  {
    inXs.aliasAttribute(AbstractModel.class, "mId", "id");

    PageParser.xs(inXs);

    inXs.omitField(AbstractModel.class, "mCreated");
    inXs.omitField(AbstractModel.class, "mUpdated");
    inXs.omitField(AbstractModel.class, "mDelete");
    inXs.omitField(AbstractModel.class, "mDirty");
  }
}