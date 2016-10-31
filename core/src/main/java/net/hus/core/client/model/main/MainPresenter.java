package net.hus.core.client.model.main;

import java.util.List;
import java.util.Map.Entry;

import net.hus.core.client.common.PageDisplay;
import net.hus.core.client.ui.common.Global;
import net.hus.core.client.ui.common.RpcCallback;
import net.hus.core.client.ui.common.UiManager;
import net.hus.core.model.Page;
import net.hus.core.model.Page.Section;
import net.hus.core.shared.command.ComponentsCommand;
import net.hus.core.shared.command.TemplateCommand;
import net.hus.core.shared.model.Components;
import net.hus.core.shared.model.UIObject_;

public class MainPresenter
{
  private MainDisplay mDisplay;

  private PageDisplay mPage;

  private UiManager mManager;

  public MainPresenter(MainDisplay inDisplay)
  {
    mDisplay = inDisplay;

    mManager = new UiManager(mDisplay.getUiCreate());

    page();
  }

  private PageDisplay page(Page.Name inPage)
  {
    PageDisplay ret = null;

    switch (inPage)
    {
      case BLOG:
        ret = mDisplay.getBlog();
        break;
      case WEB:
        ret = mDisplay.getWeb();
        break;
      case MARKET:
        ret = mDisplay.getMarketing();
        break;
      case LOGIN:
        ret = mDisplay.getLogin();
        break;

      default:
        ret = mDisplay.getLogin();
        break;
    }
    return ret;
  }

  private void page()
  {
    Global.fire(new TemplateCommand(), new RpcCallback<TemplateCommand>()
    {
      @Override
      public void onRpcSuccess(TemplateCommand inResult)
      {
        mPage = page(inResult.getData().getName());
        mDisplay.add(mPage);

        components();
      }
    });
  }

  private void components()
  {
    Global.fire(new ComponentsCommand("Components1", "-2"), new RpcCallback<ComponentsCommand>()
    {
      @Override
      public void onRpcSuccess(ComponentsCommand inResult)
      {
        Components components = inResult.getComponents();

        // add components
        for (Entry<Section.Name, List<UIObject_>> value : components.components().entrySet())
        {
          for (UIObject_ uivalue : value.getValue())
          {
            mPage.add(value.getKey(), mManager.match(uivalue));
          }
        }

        // update labels & fields & table key
        mManager.update(components.getValues(), components.getTableKey());
      }
    });
  }
}