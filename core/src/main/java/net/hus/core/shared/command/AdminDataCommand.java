package net.hus.core.shared.command;

import net.hus.core.shared.model.AdminData;
import net.hus.core.shared.model.EventType;
import net.hus.core.shared.rpc.CommandName;

@CommandName("AdminDataCommand")
public class AdminDataCommand extends AbstractDataCommand<AdminData>
{
  private static final long serialVersionUID = -8790279100272573634L;

  private EventType mType;

  private Long mFieldId;
  private String mFgg;

  AdminDataCommand()
  {
  }

  public AdminDataCommand(EventType inType)
  {
    mType = inType;
  }

  public AdminDataCommand(Long inFieldId, EventType inType)
  {
    mType = inType;
    mFieldId = inFieldId;
  }

  public AdminDataCommand(String inFgg, EventType inType)
  {
    mType = inType;
    mFgg = inFgg;
  }

  public Long getFieldId()
  {
    return mFieldId;
  }

  public EventType getType()
  {
    return mType;
  }

  public String getFgg()
  {
    return mFgg;
  }

  public String getEventTypeKey()
  {
    return mFgg;
  }
}