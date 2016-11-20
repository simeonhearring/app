package net.hus.core.shared.command;

import net.hus.core.shared.model.FieldsData;
import net.hus.core.shared.rpc.CommandName;

@CommandName("FieldsDataCommand")
public class FieldsDataCommand extends AbstractDataCommand<FieldsData>
{
  private static final long serialVersionUID = -8790279100272573634L;

  private Type mType;
  private Long mFieldId;
  private String mGroup;

  FieldsDataCommand()
  {
  }

  public FieldsDataCommand(Type inType)
  {
    mType = inType;
  }

  public FieldsDataCommand(Type inType, Long inFieldId)
  {
    mType = inType;
    mFieldId = inFieldId;
  }

  public FieldsDataCommand(Type inType, String inGroup)
  {
    mType = inType;
    mGroup = inGroup;
  }

  public Long getFieldId()
  {
    return mFieldId;
  }

  public Type getType()
  {
    return mType;
  }

  public String getGroup()
  {
    return mGroup;
  }

  public enum Type
  {
    ALL,
    FIELD,
    GROUPS,
    GROUP;
  }
}