package net.hus.core.server.command;

import org.apache.log4j.Logger;

import net.hus.core.shared.command.JavacCommand;
import net.hus.core.shared.rpc.common.RpcResponse;
import net.hus.core.util.JavacUtil;

public class JavacCommandBean extends AbstractCommandBean<JavacCommand>
{
  private static final Logger LOGGER = Logger.getLogger(JavacCommandBean.class);

  public JavacCommandBean()
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

    LOGGER.info("BEFORE JAVAC");

    JavacUtil.compile(name, sb.toString());

    LOGGER.info("MID JAVAC");

    JavacUtil.run(name);

    LOGGER.info("AFTER JAVAC");
  }

  @Override
  public RpcResponse execute(JavacCommand inCommand)
  {
    return inCommand;
  }
}