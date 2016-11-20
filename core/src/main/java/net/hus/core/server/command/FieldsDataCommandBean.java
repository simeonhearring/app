package net.hus.core.server.command;

import net.hus.core.shared.command.FieldsDataCommand;
import net.hus.core.shared.model.FieldsData;
import net.hus.core.shared.model.Lookup.Group;
import net.hus.core.shared.rpc.common.RpcResponse;

public class FieldsDataCommandBean extends AbstractCommandBean<FieldsDataCommand>
{
  @Override
  public RpcResponse execute(FieldsDataCommand inCommand)
  {
    FieldsData data = new FieldsData();

    switch (inCommand.getType())
    {
      case ALL:
        addFields(data);
        break;
      case SINGLE:
        addField(data, inCommand.getFieldId());
        break;
      case GROUPS:
        addFieldGroup(data);
        break;
      default:
        break;
    }

    inCommand.setData(data);

    return inCommand;
  }

  private void addField(FieldsData inData, Long inFieldId)
  {
    inData.setField(mCoreDao.fields().select(inFieldId));
  }

  private void addFieldGroup(FieldsData inData)
  {
    inData.setFieldGroup(mCoreDao.lookups().select(Group.FIELD_GROUP.name()));
  }

  private void addLookupGroups(FieldsData inData)
  {
    inData.setLookupGroups(mCoreDao.lookups().selectGrps());
  }

  private void addFields(FieldsData data)
  {
    data.setFields(mCoreDao.lookups().select(Group.FIELD.name()));
    Long fieldId = data.getFields().get(0).getAltId();

    addField(data, fieldId);
    addLookupGroups(data);
    addFieldGroup(data);
  }
}