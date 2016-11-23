package net.hus.core.client.model.admin;

import net.hus.core.client.model.admin.ProfileDisplay.Action;
import net.hus.core.client.ui.common.Global;
import net.hus.core.client.ui.common.RpcCallback;
import net.hus.core.client.ui.event.AdminEvent;
import net.hus.core.shared.command.AdminDataCommand;
import net.hus.core.shared.command.LookupXLSaveCommand;
import net.hus.core.shared.model.AdminData;
import net.hus.core.shared.model.EventType;
import net.hus.core.shared.model.Profile;

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
        mDisplay.addProfiles(inData.getProfiles());
        mDisplay.addPages(inData.getPages());
        break;
      }
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

  @Override
  public void select(String inProfile)
  {
    Global.fire(new AdminDataCommand(inProfile, EventType.PROFILE), this);
  }

  @Override
  public void saveProfile(String inFirst, String inMiddle, String inLast, String inUserName,
      String inPassword, String inPage)
  {
    mProfile.setFirst(inFirst);
    mProfile.setMiddle(inMiddle);
    mProfile.setLast(inLast);
    mProfile.setUserName(inUserName);
    mProfile.setPassword(inPassword);
    mProfile.getPage().setComponentsName(inPage);

    Global.fire(new LookupXLSaveCommand(mProfile), new RpcCallback<LookupXLSaveCommand>()
    {
      @Override
      public void onRpcSuccess(LookupXLSaveCommand inCommand)
      {
        mDisplay.notify("saved");
      }
    });
  }
}