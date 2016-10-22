package net.hus.core.client.model.main;

import net.hus.core.client.common.Global;
import net.hus.core.client.common.Template;
import net.hus.core.client.service.common.RpcCallback;
import net.hus.core.client.ui.Container_;
import net.hus.core.client.ui.Convert;
import net.hus.core.shared.command.TemplateCommand;
import net.hus.core.shared.command.UIObjectCommand;

public class MainPresenter
{
  private MainDisplay mDisplay;

  public MainPresenter(MainDisplay inDisplay)
  {
    mDisplay = inDisplay;

    template();
  }

  public MainDisplay getDisplay()
  {
    return mDisplay;
  }

  private Template template(String inTemplate)
  {
    Template ret = null;

    switch (inTemplate)
    {
      case "BLOG":
        ret = mDisplay.getBlog();
        break;
      case "WEB":
        ret = mDisplay.getWebPage();
        break;
      case "MARKETING":
        ret = mDisplay.getMarketing();
        break;

      default:
        ret = mDisplay.getBlog();
        break;
    }
    return ret;
  }

  public void template()
  {
    Global.fire(new TemplateCommand(), new RpcCallback<TemplateCommand>()
    {
      @Override
      public void onRpcSuccess(TemplateCommand inResult)
      {
        mDisplay.add(template(inResult.getData().getName()));
        uiObject();
      }
    });
  }

  public void uiObject()
  {
    Global.fire(new UIObjectCommand<Container_>(), new RpcCallback<UIObjectCommand<Container_>>()
    {
      @Override
      public void onRpcSuccess(UIObjectCommand<Container_> inResult)
      {
        Container_ uiObject_ = inResult.getUIObject();
        mDisplay.add(new Convert().convert(uiObject_));
      }
    });
  }
}