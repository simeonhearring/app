package net.hus.core.client.model.main;

import java.util.List;
import java.util.Map.Entry;

import net.hus.core.client.common.PageDisplay;
import net.hus.core.client.ui.common.Global;
import net.hus.core.client.ui.common.RpcCallback;
import net.hus.core.client.ui.common.UiManager;
import net.hus.core.client.ui.event.ProfileEvent;
import net.hus.core.model.Page.Section;
import net.hus.core.model.Profile;
import net.hus.core.shared.command.ComponentsCommand;
import net.hus.core.shared.command.ProfileCommand;
import net.hus.core.shared.model.Components;
import net.hus.core.shared.model.UIObject_;
import net.hus.core.shared.util.RandomUtil;

public class MainPresenter implements ProfileEvent.Handler
{
  private MainDisplay mDisplay;

  private UiManager mManager;

  public MainPresenter(MainDisplay inDisplay)
  {
    Global.addHandler(ProfileEvent.TYPE, this);

    mDisplay = inDisplay;
    mManager = new UiManager(mDisplay.getUiCreate());

    login();
  }

  private void login()
  {
    Global.fire(new ProfileCommand("login", true), new RpcCallback<ProfileCommand>()
    {
      @Override
      public void onRpcSuccess(ProfileCommand inCommand)
      {
        Profile profile = inCommand.getData();
        components(profile.getPage().getComponentsName(),
            Global.getIpAddress() + "." + RandomUtil.random(5));
      }
    });
  }

  private void profile(String inName)
  {
    Global.fire(new ProfileCommand(inName), new RpcCallback<ProfileCommand>()
    {
      @Override
      public void onRpcSuccess(ProfileCommand inCommand)
      {
        Profile profile = inCommand.getData();
        components(profile.getPage().getComponentsName(), profile.fvk());
      }
    });
  }

  private void components(String inComponentName, String inFvk)
  {
    Global.fire(new ComponentsCommand(inComponentName, inFvk), new RpcCallback<ComponentsCommand>()
    {
      @Override
      public void onRpcSuccess(ComponentsCommand inCommand)
      {
        Components components = inCommand.getComponents();

        PageDisplay page = addPageToMain(components);

        addComponentsToPage(components, page);

        addValuesToComponents(components);

        addFvkToButtons(components);
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

  private void addFvkToButtons(Components inComponents)
  {
    mManager.update(inComponents.getTableFvk());
  }

  @Override
  public void dispatch(ProfileEvent inEvent)
  {
    profile(inEvent.getName());
  }
}