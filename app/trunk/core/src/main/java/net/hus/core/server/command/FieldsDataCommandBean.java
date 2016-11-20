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
        addAll(data);
        break;
      case FIELD:
        addField(data, inCommand.getFieldId());
        break;
      case GROUP:
        addGroup(data, inCommand.getGroup());
        break;
      case GROUPS:
      {
        addFieldGroups(data);
        addFields(data);
        break;
      }
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

  private void addGroup(FieldsData inData, String inGroup)
  {
    inData.setFieldGroup(mCoreDao.fields().select(inGroup));
  }

  private void addFieldGroups(FieldsData inData)
  {
    inData.setFieldGroups(mCoreDao.lookups().select(Group.FIELD_GROUP.name()));
  }

  private void addLookupGroups(FieldsData inData)
  {
    inData.setLookupGroups(mCoreDao.lookups().selectGrps());
  }

  private void addFields(FieldsData inData)
  {
    inData.setFields(mCoreDao.lookups().select(Group.FIELD.name()));
  }

  private void addAll(FieldsData inData)
  {
    addFields(inData);
    Long fieldId = inData.getFields().get(0).getAltId();

    addField(inData, fieldId);
    addLookupGroups(inData);
    addFieldGroups(inData);
  }
}