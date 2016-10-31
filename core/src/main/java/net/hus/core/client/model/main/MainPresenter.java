package net.hus.core.client.model.main;

import java.util.List;
import java.util.Map.Entry;

import net.hus.core.client.common.PageDisplay;
import net.hus.core.client.ui.common.Global;
import net.hus.core.client.ui.common.RpcCallback;
import net.hus.core.client.ui.common.UiManager;
import net.hus.core.model.Page;
import net.hus.core.model.Page.Section;
import net.hus.core.model.Profile;
import net.hus.core.shared.command.ComponentsCommand;
import net.hus.core.shared.command.ProfileCommand;
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
    Global.fire(new ComponentsCommand(inComponentName, inFvk),
        new RpcCallback<ComponentsCommand>()
    {
      @Override
      public void onRpcSuccess(ComponentsCommand inResult)
      {
        Components components = inResult.getComponents();

            // add page
        Page.Name page = components.getTableFvk().getPage();
        mPage = PageLocater.page(mDisplay, page);
        mDisplay.add(mPage);

        // add components
        for (Entry<Section.Name, List<UIObject_>> value : components.components().entrySet())
        {
          Section.Name section = value.getKey();
          for (UIObject_ uivalue : value.getValue())
          {
            mPage.add(section, mManager.match(uivalue));
          }
        }

        // update labels & fields & table key
        mManager.update(components.getValues(), components.getTableFvk());
      }
    });
  }
}