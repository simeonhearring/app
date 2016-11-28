package net.hus.core.client.model.select;

import net.hus.core.client.model.select.SelectFVKDisplay.Action;
import net.hus.core.client.ui.common.Global;
import net.hus.core.client.ui.common.RpcCallback;
import net.hus.core.client.ui.event.ValuesEvent;
import net.hus.core.shared.command.LookupCommand;
import net.hus.core.shared.command.ValuesCommand;
import net.hus.core.shared.model.FieldTKG;

public class SelectFVKPresenter extends RpcCallback<LookupCommand> implements Action
{
  private FieldTKG mTKG;
  private FVKDisplay mFVKDisplay;
  private SelectFVKDisplay mDisplay;

  public SelectFVKPresenter(FieldTKG inTKG, FVKDisplay inDisplay)
  {
    mTKG = inTKG;
    mFVKDisplay = inDisplay;
    mDisplay = mFVKDisplay.getSelect();
    mDisplay.setAction(this);

    setLookupGroup(mTKG.getFvt());
  }

  public void setLookupGroup(String inGroup)
  {
    Global.fire(new LookupCommand(null, inGroup), this);
  }

  @Override
  public void onRpcSuccess(LookupCommand inCommand)
  {
    mDisplay.addKeys(inCommand.getData().getOptions());
  }

  @Override
  public void select(String inValue)
  {
    mTKG.setFvk(inValue);

    Global.fire(new ValuesCommand(mTKG), new RpcCallback<ValuesCommand>()
    {
      @Override
      public void onRpcSuccess(ValuesCommand inCommand)
      {
        Global.fire(new ValuesEvent(mTKG, inCommand.getValues()));
      }
    });
  }

  public FVKDisplay getDisplay()
  {
    return mFVKDisplay;
  }
}