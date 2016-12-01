package net.hus.core.shared.model;

import net.hus.core.shared.util.EnumUtil;
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

  private static final String SUFFIX = ".bootstrap.min.css";

  public String getFileName()
  {
    return name() + SUFFIX;
  }

  @Override
  public String display()
  {
    return StringUtil.toTitle(name());
  }

  public static Enum<?> css(String inCss)
  {
    return inCss == null ? null : EnumUtil.valueOf(inCss.replaceAll(SUFFIX, ""), values());
  }
}