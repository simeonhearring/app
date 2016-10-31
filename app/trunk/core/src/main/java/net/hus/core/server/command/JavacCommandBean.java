package net.hus.core.server.command;

import net.hus.core.shared.command.ComponentsCommand;
import net.hus.core.shared.rpc.common.RpcResponse;

public class JavacCommandBean extends AbstractCommandBean<ComponentsCommand>
{
  @Override
  public RpcResponse execute(ComponentsCommand inCommand)
  {
    int errorCode = com.sun.tools.javac.Main.compile(new String[]
        {
            "-classpath",
            "bin",
            "-d",
            "/temp/dynacode_classes",
            "dynacode/sample/PostmanImpl.java"
        });

    return inCommand;
  }
}