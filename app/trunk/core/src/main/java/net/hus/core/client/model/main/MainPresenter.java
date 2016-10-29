package net.hus.core.client.model.main;

import java.util.List;
import java.util.Map.Entry;

import net.hus.core.client.common.Template;
import net.hus.core.client.model.UiManager;
import net.hus.core.client.ui.common.Global;
import net.hus.core.client.ui.common.RpcCallback;
import net.hus.core.shared.command.ComponentsCommand;
import net.hus.core.shared.command.TemplateCommand;
import net.hus.core.shared.model.Components;
import net.hus.core.shared.model.UIObject_;

public class MainPresenter
{
  private MainDisplay mDisplay;

  private Template mTemplate;

  private UiManager mManager;

  public MainPresenter(MainDisplay inDisplay)
  {
    mDisplay = inDisplay;

    mManager = mDisplay.getManager();

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
        mTemplate = template(inResult.getData().getName());
        mDisplay.add(mTemplate);
        uiObject();
      }
    });
  }

  public void uiObject()
  {
    Global.fire(new ComponentsCommand("Page1", "-2"), new RpcCallback<ComponentsCommand>()
    {
      @Override
      public void onRpcSuccess(ComponentsCommand inResult)
      {
        Components components = inResult.getComponents();

        // add components
        for (Entry<String, List<UIObject_>> value : components.components().entrySet())
        {
          for (UIObject_ uivalue : value.getValue())
          {
            mTemplate.add(value.getKey(), mManager.match(uivalue));
          }
        }

        // update labels & fields & table key
        mManager.update(components.getValues(), components.geTableKey());
      }
    });
  }
}