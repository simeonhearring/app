package net.hus.core.shared.command;

import net.hus.core.shared.model.FieldsData;
import net.hus.core.shared.model.EventType;
import net.hus.core.shared.rpc.CommandName;

@CommandName("FieldsDataCommand")
public class FieldsDataCommand extends AbstractDataCommand<FieldsData>
{
  private static final long serialVersionUID = -8790279100272573634L;

  private EventType mType;
  private Long mFieldId;
  private String mFgg;

  FieldsDataCommand()
  {
  }

  public FieldsDataCommand(EventType inType)
  {
    mType = inType;
  }

  public FieldsDataCommand(EventType inType, Long inFieldId)
  {
    mType = inType;
    mFieldId = inFieldId;
  }

  public FieldsDataCommand(EventType inType, String inFgg)
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
}