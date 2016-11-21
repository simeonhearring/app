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

    // for (EventType value : inCommand.getType())
    // {
    switch (inCommand.getType())
    {
      case ALL:
        addAll(data);
        break;
      case FIELD:
        addField(data, inCommand.getFieldId());
        break;
      case FIELDS:
        addFields(data, inCommand.getFgg());
        break;
      case LOOKUP:
        addLookup(data, inCommand.getFgg());
        break;
      default:
        break;
    }
    // }

    inCommand.setData(data);

    return inCommand;
  }

  private void addField(AdminData inData, Long inFieldId)
  {
    inData.setField(mCoreDao.fields().select(inFieldId));
  }

  private void addFields(AdminData inData, String inFgg)
  {
    inData.setFieldGroup(mCoreDao.fields().select(inFgg));
  }

  private void addFieldGroups(AdminData inData)
  {
    inData.setFieldGroups(mCoreDao.lookups().select(Group.FIELD_GROUP.name()));
  }

  private void addFields(AdminData inData)
  {
    inData.setFields(mCoreDao.lookups().select(Group.FIELD.name()));
  }

  private void addLookup(AdminData inData)
  {
    inData.setLookupGroups(mCoreDao.lookups().select(Group.LOOKUP.name()));
  }

  private void addLookup(AdminData inData, String inGroup)
  {
    inData.setLookupGroup(mCoreDao.lookups().select(inGroup));
  }

  private void addAll(AdminData inData)
  {
    addFields(inData);
    Long fieldId = inData.getFields().get(0).getAltId();
    addField(inData, fieldId);

    addLookup(inData);
    String grp = inData.getLookupGroups().get(0).getName();
    addLookup(inData, grp);

    addFieldGroups(inData);
    String fgg = inData.getFieldGroups().get(0).getName();
    addFields(inData, fgg);
  }
}