package net.hus.core.client.model.admin;

import net.hus.core.client.model.admin.ProfileDisplay.Action;
import net.hus.core.client.ui.common.Global;
import net.hus.core.client.ui.common.RpcCallback;
import net.hus.core.client.ui.event.AdminEvent;
import net.hus.core.shared.command.AdminDataCommand;
import net.hus.core.shared.command.LookupXLSaveCommand;
import net.hus.core.shared.model.AdminData;
import net.hus.core.shared.model.EventType;
import net.hus.core.shared.model.Page;
import net.hus.core.shared.model.Profile;
import net.hus.core.shared.util.RandomUtil;

public class ProfilePresenter extends RpcCallback<AdminDataCommand>
implements Action, AdminEvent.Handler
{
  private ProfileDisplay mDisplay;

  private Profile mProfile;

  public ProfilePresenter(ProfileDisplay inDisplay)
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
      {
        mDisplay.reset();
        mDisplay.addProfiles(inData.getProfiles());
        mDisplay.addPages(inData.getPages());
        break;
      }
      case PROFILES:
        mDisplay.addProfiles(inData.getProfiles());
        break;
      case PROFILE:
        addProfile(inData.getProfile());
        break;
      default:
        break;
    }
  }

  private void addProfile(Profile inProfile)
  {
    mProfile = inProfile;
    mDisplay.addProfile(mProfile);
  }

  private void refresh()
  {
    Global.fire(new AdminDataCommand((String) null, EventType.PROFILES), this);
  }

  @Override
  public void select(String inProfile)
  {
    Global.fire(new AdminDataCommand(inProfile, EventType.PROFILE), this);
  }

  @Override
  public void saveProfile(String inFirst, String inMiddle, String inLast, String inPassword,
      String inPage)
  {
    mProfile.setFirst(inFirst);
    mProfile.setMiddle(inMiddle);
    mProfile.setLast(inLast);
    mProfile.setPassword(inPassword);
    mProfile.getPage().setComponentsName(inPage);

    Global.fire(new LookupXLSaveCommand(mProfile), new RpcCallback<LookupXLSaveCommand>()
    {
      @Override
      public void onRpcSuccess(LookupXLSaveCommand inCommand)
      {
        mDisplay.notify("Saved ... " + mProfile.getName());
        refresh();
      }
    });
  }

  @Override
  public void createProfile(String inUserName, String inFirst, String inLast, String inPage)
  {
    final Profile p = new Profile();
    p.setUserName(inUserName);
    p.setFirst(inFirst);
    p.setLast(inLast);
    p.setPassword(RandomUtil.random(5));
    p.setPage(new Page(null, inPage));

    Global.fire(new LookupXLSaveCommand(p), new RpcCallback<LookupXLSaveCommand>()
    {
      @Override
      public void onRpcSuccess(LookupXLSaveCommand inCommand)
      {
        mDisplay.notify("Saved ... " + p.getName());
        refresh();
      }
    });
  }
}