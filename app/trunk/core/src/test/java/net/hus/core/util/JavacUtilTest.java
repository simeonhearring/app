package net.hus.core.util;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.shared.model.CustomCommand;

public class JavacUtilTest
{
  @Test
  public void testCompileFile()
  {
    String spath = "src/test/resources/";
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

  @Test
  public void testCompileInstance()
  {
    String name = "Hello";

    StringBuilder sb = new StringBuilder();
    sb.append("import net.hus.core.shared.model.CustomCommand;");
    sb.append("public class ").append(name).append(" implements CustomCommand, Runnable");
    sb.append("{");
    sb.append("  @Override");
    sb.append("  public void run() ");
    sb.append("  {");
    sb.append("    System.out.println(\"This is in Hello CustomCommand file\");");
    sb.append("  }");
    sb.append("}");

    Assert.assertEquals(true, JavacUtil.compile(name, sb.toString()));
    Object obj = JavacUtil.instance(name);
    Assert.assertTrue(obj instanceof CustomCommand);
    ((Runnable) obj).run();
  }

  @Test
  public void testCompilePackage()
  {
    String name = "Packaged";
    String pack = "net.hus.core.util";

    StringBuilder sb = new StringBuilder();
    sb.append("package ").append(pack).append(";");
    sb.append("public class ").append(name).append(" implements Runnable");
    sb.append("{");
    sb.append("  @Override");
    sb.append("  public void run() ");
    sb.append("  {");
    sb.append("    System.out.println(\"This is in Hello CustomCommand file\");");
    sb.append("  }");
    sb.append("}");

    Assert.assertEquals(true, JavacUtil.compile(name, sb.toString()));
    Object obj = JavacUtil.instance(pack + "." + name);
    Assert.assertEquals(true, obj != null);
  }
}