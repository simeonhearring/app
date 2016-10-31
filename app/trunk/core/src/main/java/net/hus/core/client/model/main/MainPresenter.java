package net.hus.core.client.model.main;

import java.util.List;
import java.util.Map.Entry;

import net.hus.core.client.common.PageDisplay;
import net.hus.core.client.ui.common.Global;
import net.hus.core.client.ui.common.RpcCallback;
import net.hus.core.client.ui.common.UiManager;
import net.hus.core.model.Page.Section;
import net.hus.core.model.Profile;
import net.hus.core.shared.command.ComponentsCommand;
import net.hus.core.shared.command.ProfileCommand;
import net.hus.core.shared.model.Components;
import net.hus.core.shared.model.UIObject_;

public class MainPresenter
{
  private MainDisplay mDisplay;

  private UiManager mManager;

  public MainPresenter(MainDisplay inDisplay)
  {
    mDisplay = inDisplay;

    mManager = new UiManager(mDisplay.getUiCreate());

    profile();
  }

  private void profile()
  {
    Global.fire(new ProfileCommand("simeonhearring"), new RpcCallback<ProfileCommand>()
    {
      @Override
      public void onRpcSuccess(ProfileCommand inResult)
      {
        Profile profile = inResult.getData();
        components(profile.getPage().getComponentsName(), profile.fvk());
      }
    });
  }

  private void components(String inComponentName, String inFvk)
  {
    Global.fire(new ComponentsCommand(inComponentName, inFvk), new RpcCallback<ComponentsCommand>()
    {
      @Override
      public void onRpcSuccess(ComponentsCommand inResult)
      {
        Components components = inResult.getComponents();

        PageDisplay page = addPageToMain(components);

        addComponentsToPage(components, page);

        addValuesToComponents(components);
      }
    });
  }

  private PageDisplay addPageToMain(Components inComponents)
  {
    PageDisplay ret = PageLocater.page(mDisplay, inComponents.getTableFvk().getPage());
    mDisplay.clear();
    mDisplay.add(ret);
    return ret;
  }

  private void addComponentsToPage(Components inComponents, PageDisplay inPage)
  {
    for (Entry<Section.Name, List<UIObject_>> value : inComponents.components().entrySet())
    {
      Section.Name section = value.getKey();
      for (UIObject_ uivalue : value.getValue())
      {
        inPage.add(section, mManager.match(uivalue));
      }
    }
  }

  private void addValuesToComponents(Components inComponents)
  {
    mManager.update(inComponents.getValues(), inComponents.getTableFvk());
  }
}