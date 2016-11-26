package net.hus.core.client.model.admin;

import java.util.List;
import java.util.Map;

import net.hus.core.client.model.admin.LookupDisplay.Action;
import net.hus.core.client.ui.common.Global;
import net.hus.core.client.ui.common.RpcCallback;
import net.hus.core.client.ui.event.AdminEvent;
import net.hus.core.shared.command.AdminDataCommand;
import net.hus.core.shared.command.LookupSaveCommand;
import net.hus.core.shared.model.AdminData;
import net.hus.core.shared.model.EventType;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.Lookup;
import net.hus.core.shared.model.Lookup.Group;
import net.hus.core.shared.model.Lookups;
import net.hus.core.shared.model.Lookups.Type;

public class LookupPresenter extends RpcCallback<AdminDataCommand>
implements Action, AdminEvent.Handler
{
  private LookupDisplay mDisplay;

  public LookupPresenter(LookupDisplay inDisplay)
  {
    Global.addHandler(AdminEvent.TYPE, this);
    mDisplay = inDisplay;
    mDisplay.setAction(this);
  }

  @Override
  public void dispatch(AdminEvent inEvent)
  {
    process(inEvent.getType(), inEvent.getData());
  }

  @Override
  public void onRpcSuccess(AdminDataCommand inCommand)
  {
    process(inCommand.getType(), inCommand.getData());
  }

  private void process(EventType inType, AdminData inData)
  {
    switch (inType)
    {
      case ALL:
        addLookupGroups(inData);
        break;
      case LOOKUP:
        mDisplay.addValues(inData.getLookups());
        break;
      default:
        break;
    }
  }

  private void addLookupGroups(AdminData inData)
  {
    mDisplay.setUp();

    Lookups lookups = new Lookups();
    lookups.setLookups(inData.getLookupGroups());

    mDisplay.clearLookupGroups();

    Map<Type, List<Lookup>> groups = lookups.getGroup();
    mDisplay.addLookupGroups(Type.Custom.name(), groups.get(Type.Custom));
    mDisplay.addLookupGroups(Type.Application.name(), groups.get(Type.Application));

    mDisplay.refreshLookupGroups();
  }

  private boolean inValid(String... inName)
  {
    for (String value : inName)
    {
      if ("".equals(value.trim()))
      {
        return true;
      }
    }
    return false;
  }

  @Override
  public void select(String inGroup)
  {
    Global.fire(new AdminDataCommand(inGroup, EventType.LOOKUP), this);
  }

  @Override
  public void createLookups(final String inName)
  {
    if (inValid(inName))
    {
      mDisplay.warn("'Lookup Name' is required!");
      return;
    }

    Lookup lookup = new Lookup();
    lookup.setGroup(Group.LOOKUP);
    lookup.setName(Field.officialName(inName));

    lookup.setDisplay(inName);
    lookup.setSort(0);

    Global.fire(new LookupSaveCommand(lookup), new RpcCallback<LookupSaveCommand>()
    {
      @Override
      public void onRpcSuccess(LookupSaveCommand inCommand)
      {
        mDisplay.notify("Saved ... " + inName);
        mDisplay.reset();
        Global.fire(new AdminEvent(EventType.REFRESH, null));
      }
    });
  }

  @Override
  public void createLookup(final String inGroup, final String inName, String inAbbr, int inSort)
  {
    if (inValid(inGroup, inName))
    {
      mDisplay.warn("'Select Lookup' & 'Name' are required!");
      return;
    }

    Lookup lookup = new Lookup();
    lookup.setGroup(inGroup);
    lookup.setName(Field.officialName(inName));
    lookup.setAbbreviation(inAbbr);

    lookup.setDisplay(inName);
    lookup.setSort(inSort);

    Global.fire(new LookupSaveCommand(lookup), new RpcCallback<LookupSaveCommand>()
    {
      @Override
      public void onRpcSuccess(LookupSaveCommand inCommand)
      {
        mDisplay.notify("Saved ... " + inName);
        mDisplay.reset();
        select(inGroup);
      }
    });
  }

  @Override
  public void saveLookups(final String inName, final String inDisplay)
  {
    if (inValid(inName, inDisplay))
    {
      mDisplay.warn("'Select Lookup' & 'Display' are required!");
      return;
    }

    Lookup lookup = new Lookup();
    lookup.setGroup(Group.LOOKUP);
    lookup.setName(inName);

    lookup.setDisplay(inDisplay);
    lookup.setSort(0);

    Global.fire(new LookupSaveCommand(lookup), new RpcCallback<LookupSaveCommand>()
    {
      @Override
      public void onRpcSuccess(LookupSaveCommand inCommand)
      {
        mDisplay.notify("Saved ... " + inDisplay);
        mDisplay.reset();
        // Global.fire(new AdminEvent(EventType.REFRESH, null));
      }
    });
  }
}