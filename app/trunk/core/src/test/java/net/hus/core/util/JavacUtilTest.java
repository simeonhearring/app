package net.hus.core.util;

import org.junit.Test;

import junit.framework.Assert;

public class JavacUtilTest
{
  @Test
  public void testCompileFile()
  {
    String spath = "";
    String name = "HelloWorld2";
    String ext = ".java";

    Assert.assertEquals(true, JavacUtil.compile(spath + name + ext));
    JavacUtil.run(name);
    Assert.assertTrue(true); // no fail
  }

  @Test
  public void testCompileString()
  {
    String name = "HelloWorld3";

    StringBuilder sb = new StringBuilder();
    sb.append("public class ").append(name).append(" implements Runnable");
    sb.append("{");
    sb.append("  @Override");
    sb.append("  public void run() ");
    sb.append("  {");
    sb.append("    System.out.println(\"This is in HelloWorld3 file\");");
    sb.append("  }");
    sb.append("}");

    Assert.assertEquals(true, JavacUtil.compile(name, sb.toString()));
    JavacUtil.run(name);
    Assert.assertTrue(true); // no fail
  }
}