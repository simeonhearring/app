package net.hus.core.server.command;

import net.hus.core.shared.command.AdminDataCommand;
import net.hus.core.shared.model.AdminData;
import net.hus.core.shared.model.Lookup.Group;
import net.hus.core.shared.rpc.common.RpcResponse;

public class AdminDataCommandBean extends AbstractCommandBean<AdminDataCommand>
{
  @Override
  public RpcResponse execute(AdminDataCommand inCommand)
  {
    AdminData data = new AdminData();

    switch (inCommand.getType())
    {
      case ALL:
        addAll(data);
        break;
      case FIELD:
        addField(data, inCommand.getFieldId());
        break;
      case GROUP:
        addGroup(data, inCommand.getFgg());
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

  private void addField(AdminData inData, Long inFieldId)
  {
    inData.setField(mCoreDao.fields().select(inFieldId));
  }

  private void addGroup(AdminData inData, String inGroup)
  {
    inData.setFieldGroup(mCoreDao.fields().select(inGroup));
  }

  private void addFieldGroups(AdminData inData)
  {
    inData.setFieldGroups(mCoreDao.lookups().select(Group.FIELD_GROUP.name()));
  }

  private void addLookupGroups(AdminData inData)
  {
    inData.setLookupGroups(mCoreDao.lookups().selectGrps());
  }

  private void addFields(AdminData inData)
  {
    inData.setFields(mCoreDao.lookups().select(Group.FIELD.name()));
  }

  private void addAll(AdminData inData)
  {
    addFields(inData);
    Long fieldId = inData.getFields().get(0).getAltId();

    addField(inData, fieldId);
    addLookupGroups(inData);
    addFieldGroups(inData);
  }
}