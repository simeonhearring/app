package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.model.AbstractModel;
import net.hus.core.shared.model.Profile;

public class ProfileParser extends XStream implements Parser<Profile>
{
  public ProfileParser()
  {
    alias("Profile", Profile.class);
    aliasAttribute(Profile.class, "mType", "type");
    aliasAttribute(Profile.class, "mUserName", "userName");
    aliasAttribute(Profile.class, "mPassword", "password");
    aliasAttribute(Profile.class, "mCss", "css");
    aliasField("First", Profile.class, "mFirst");
    aliasField("Middle", Profile.class, "mMiddle");
    aliasField("Last", Profile.class, "mLast");
    aliasField("Page", Profile.class, "mPage");

    omitField(Profile.class, "mFvk");

    xs((XStream) this);
  }

  @Override
  public Profile fromXml(String inValue)
  {
    return (Profile) super.fromXML(inValue);
  }

  @Override
  public String toXml(Profile inObj)
  {
    return super.toXML(inObj);
  }

  @Override
  public void xs(Parser<Profile> inParser)
  {
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