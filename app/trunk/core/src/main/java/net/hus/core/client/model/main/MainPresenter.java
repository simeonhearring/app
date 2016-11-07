package net.hus.core.client.model.main;

import java.util.List;
import java.util.Map.Entry;

import net.hus.core.client.common.PageDisplay;
import net.hus.core.client.ui.common.Global;
import net.hus.core.client.ui.common.RpcCallback;
import net.hus.core.client.ui.common.UiManager;
import net.hus.core.client.ui.event.ProfileEvent;
import net.hus.core.shared.command.ComponentsCommand;
import net.hus.core.shared.command.ProfileCommand;
import net.hus.core.shared.components.Components;
import net.hus.core.shared.components.UIObject_;
import net.hus.core.shared.model.ComponentsQuery;
import net.hus.core.shared.model.Page.Section;

public class MainPresenter implements ProfileEvent.Handler
{
  private MainDisplay mDisplay;

  private UiManager mManager;

  public MainPresenter(MainDisplay inDisplay)
  {
    Global.addHandler(ProfileEvent.TYPE, this);

    mDisplay = inDisplay;
    mManager = new UiManager(mDisplay.getUiCreate());
    profile("login", true);
  }

  private void profile(String inName, boolean inApp)
  {
    Global.fire(new ProfileCommand(inName, inApp), new RpcCallback<ProfileCommand>()
    {
      @Override
      public void onRpcSuccess(ProfileCommand inCommand)
      {
        components(inCommand.getData());
      }
    });
  }

  private void components(ComponentsQuery inQuery)
  {
    Global.fire(new ComponentsCommand(inQuery), new RpcCallback<ComponentsCommand>()
    {
      @Override
      public void onRpcSuccess(ComponentsCommand inCommand)
      {
        Components components = inCommand.getComponents();

        PageDisplay page = addPageToMain(components);

        addComponentsToPage(components, page);

        addValuesToComponents(components);

        addFieldTKGToButtons(components);
      }
    });
  }

  private PageDisplay addPageToMain(Components inComponents)
  {
    PageDisplay ret = PageLocater.page(mDisplay, inComponents.getFieldTKG().getPage());
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
    mManager.update(inComponents.getValues(), inComponents.getFieldTKG());
  }

  private void addFieldTKGToButtons(Components inComponents)
  {
    mManager.update(inComponents.getFieldTKG());
  }

  @Override
  public void dispatch(ProfileEvent inEvent)
  {
    profile(inEvent.getName(), false);
  }
}