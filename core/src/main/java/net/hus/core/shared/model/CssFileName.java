package net.hus.core.shared.model;

import net.hus.core.shared.util.StringUtil;

public enum CssFileName implements EnumDisplay
{
  cerulean,
  cosmo,
  flatly,
  journal,
  lumen,
  paper,
  readable,
  sandstone,
  simplex,
  slate,
  spacelab,
  superhero,
  united,
  yeti,;

  public String getFileName()
  {
    return name() + ".bootstrap.min.css";
  }

  @Override
  public String display()
  {
    return StringUtil.toTitle(name());
  }
}