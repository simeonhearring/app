package net.hus.core.server.rpc;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import net.hus.core.client.service.rpc.RpcService;
import net.hus.core.server.command.CommandBean;
import net.hus.core.shared.command.LoggerCommand;
import net.hus.core.shared.exception.NotifyException;
import net.hus.core.shared.rpc.CommandName;
import net.hus.core.shared.rpc.HasCommandName;
import net.hus.core.shared.rpc.common.NotifyResponse;
import net.hus.core.shared.rpc.common.RpcCommand;
import net.hus.core.shared.rpc.common.RpcCommands;
import net.hus.core.shared.rpc.common.RpcResponse;
import net.hus.core.shared.util.StringUtil;
import net.hus.core.util.HostUtil;
import net.hus.core.util.ServerErrorUtil;

@SuppressWarnings("serial")
public class RpcServiceImpl extends RemoteServiceServlet implements RpcService
{
  private static final Logger LOGGER = Logger.getLogger(RpcServiceImpl.class);

  private ApplicationContext mAppContext;

  @Override
  public void init(ServletConfig inConfig) throws ServletException
  {
    super.init(inConfig);

    mAppContext = (ApplicationContext) inConfig.getServletContext()
        .getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
  }

  @Override
  public RpcResponse fire(RpcCommands inCommand)
  {
    for (RpcCommand value : inCommand.getRpcCommands())
    {
      inCommand.add(fire(value));
    }

    return inCommand;
  }

  @SuppressWarnings("unchecked")
  @Override
  public RpcResponse fire(RpcCommand inCommand)
  {
    RpcResponse ret = null;
    String bean = null;

    if (inCommand.isEncryptRequired() && !inCommand.isEncrypted())
    {
      ret = new NotifyResponse("Required encryption key is not present!");
    }
    else
    {
      try
      {
        inCommand.decrypt();
        inCommand.setUserInfo(StringUtil.ensure(inCommand.getUserInfo()) + " "
            + HostUtil.getRemoteAddr(getThreadLocalRequest()));
        inCommand.setIpAddress(HostUtil.getRemoteAddr(getThreadLocalRequest()));

        if (allowDebug(inCommand))
        {
          LOGGER.debug(debugRpcCommand(inCommand));
        }

        bean = getValidCommandBeanName(inCommand);

        LOGGER.warn("Executing rpc ... " + bean + " for " + inCommand.getUserInfo());

        ret = ((CommandBean<RpcCommand>) mAppContext.getBean(bean)).execute(inCommand);
      }
      catch (NotifyException e)
      {
        ret = new NotifyResponse(null, e.getNotifyMessage());
        e.printStackTrace();
        LOGGER.warn("Notify Exception executing rpc ... " + bean + " " + e.getNotifyMessage());
      }
      catch (Exception e)
      {
        ret = new NotifyResponse(null, e.getMessage());
        e.printStackTrace();
        LOGGER.error("Error executing rpc command " + bean, e);
      }
    }

    return ret;
  }

  private boolean allowDebug(RpcCommand inCommand)
  {
    return LOGGER.isDebugEnabled() && !(inCommand instanceof LoggerCommand);
  }

  private static String debugRpcCommand(Object inObject)
  {
    return ServerErrorUtil.objectToString(inObject, false);
  }

  private String getValidCommandBeanName(RpcCommand inCommand)
  {
    String beanName = null;

    if (inCommand instanceof HasCommandName)
    {
      beanName = ((HasCommandName) inCommand).commandName();
    }
    else
    {
      CommandName annotation = inCommand.getClass().getAnnotation(CommandName.class);
      if (annotation == null || annotation.value() == null || "".equals(annotation.value()))
      {
        throw new IllegalArgumentException("RpcCommand class ["
            + inCommand.getClass().getSimpleName() + "] must declare a CommandBean annotation.");
      }
      beanName = annotation.value();
    }

    if (!mAppContext.containsBean(beanName))
    {
      throw new IllegalArgumentException("Command bean [" + beanName + "] in RpcCommand class ["
          + inCommand.getClass().getSimpleName() + "] was not found in Application Context.");
    }

    return beanName;
  }
}