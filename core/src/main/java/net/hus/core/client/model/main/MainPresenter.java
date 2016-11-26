package net.hus.core.client.model.main;

import java.util.List;
import java.util.Map.Entry;

import net.hus.core.client.common.PageDisplay;
import net.hus.core.client.ui.common.Global;
import net.hus.core.client.ui.common.RpcCallback;
import net.hus.core.client.ui.event.ProfileEvent;
import net.hus.core.client.ui.event.ValuesEvent;
import net.hus.core.client.ui.manage.UiManager;
import net.hus.core.shared.command.ComponentsCommand;
import net.hus.core.shared.command.ProfileCommand;
import net.hus.core.shared.model.Components;
import net.hus.core.shared.model.ComponentsQuery;
import net.hus.core.shared.model.FieldTKG;
import net.hus.core.shared.model.Page.Section;
import net.hus.core.shared.model.Profile;
import net.hus.core.shared.model.UIObject_;
import net.hus.core.shared.model.Value;

public class MainPresenter implements ProfileEvent.Handler, ValuesEvent.Handler
{
  private MainDisplay mDisplay;

  private UiManager mManager;

  public MainPresenter(MainDisplay inDisplay)
  {
    Global.addHandler(ProfileEvent.TYPE, this);
    Global.addHandler(ValuesEvent.TYPE, this);

    mDisplay = inDisplay;
    mManager = new UiManager(mDisplay.getUiCreate());

    profile(Profile.Name.login.name());
  }

  private void profile(String inName)
  {
    Global.fire(new ProfileCommand(inName), new RpcCallback<ProfileCommand>()
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

        addValuesToComponents(components.getFieldTKG(), components.getValues());

        addFieldTKGToButtons(components);
      }
    });
  }

  private PageDisplay addPageToMain(Components inComponents)
  {
    PageDisplay ret = PageLocater.page(mDisplay, inComponents.getFieldTKG());
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

    mManager.manage(inComponents.getFieldTKG(), inComponents.getValues());
  }

  private void addValuesToComponents(FieldTKG inFieldTKG, List<Value> inValues)
  {
    mManager.update(inValues, inFieldTKG);
  }

  private void addFieldTKGToButtons(Components inComponents)
  {
    mManager.update(inComponents.getFieldTKG());
  }

  @Override
  public void dispatch(ProfileEvent inEvent)
  {
    profile(inEvent.getName());
  }

  @Override
  public void dispatch(ValuesEvent inEvent)
  {
    addValuesToComponents(inEvent.getTKG(), inEvent.getValues().getValues());
  }
}