package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.model.Profile;

public class ProfileParser extends XStream implements Parser<Profile>
{
  public ProfileParser()
  {
    alias("Profile", Profile.class);
    aliasAttribute(Profile.class, "mUserName", "userName");
    aliasAttribute(Profile.class, "mPassword", "password");
    aliasField("First", Profile.class, "mFirst");
    aliasField("Middle", Profile.class, "mMiddle");
    aliasField("Last", Profile.class, "mLast");
    aliasField("Page", Profile.class, "mPage");

    AppProfileParser.xs(this);
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
}