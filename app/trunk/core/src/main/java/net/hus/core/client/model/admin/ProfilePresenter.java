package net.hus.core.client.model.admin;

import net.hus.core.client.model.admin.ProfileDisplay.Action;
import net.hus.core.client.ui.common.Global;
import net.hus.core.client.ui.common.RpcCallback;
import net.hus.core.client.ui.event.AdminEvent;
import net.hus.core.shared.command.AdminDataCommand;
import net.hus.core.shared.model.AdminData;
import net.hus.core.shared.model.EventType;

public class ProfilePresenter extends RpcCallback<AdminDataCommand>
implements Action, AdminEvent.Handler
{
  private ProfileDisplay mDisplay;

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
        break;
      }
      case PROFILE:
        mDisplay.addProfile(inData.getProfile());
        break;
      default:
        break;
    }
  }

  @Override
  public void select(String inProfile)
  {
    Global.fire(new AdminDataCommand(inProfile, EventType.PROFILE), this);
  }
}