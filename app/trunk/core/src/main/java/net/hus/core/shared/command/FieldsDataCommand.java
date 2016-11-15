package net.hus.core.shared.command;

import net.hus.core.shared.model.FieldsData;
import net.hus.core.shared.rpc.CommandName;

@CommandName("FieldsDataCommand")
public class FieldsDataCommand extends AbstractDataCommand<FieldsData>
{
  private static final long serialVersionUID = -8790279100272573634L;

  private Type mType;
  private Long mFieldId;

  FieldsDataCommand()
  {
  }

  public FieldsDataCommand(Type inType, Long inFieldId)
  {
    mType = inType;
    mFieldId = inFieldId;
  }

  public Long getFieldId()
  {
    return mFieldId;
  }

  public Type getType()
  {
    return mType;
  }

  public enum Type
  {
    ALL,
    SINGLE;
  }
}