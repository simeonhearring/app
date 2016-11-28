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
      case REFRESH:
      case ALL:
        addAll(data);
        break;
      case FIELD:
        addField(data, inCommand.getFieldId());
        break;
      case FIELDS:
        addFields(data, inCommand.getEventTypeKey());
        break;
      case LOOKUP:
        addLookup(data, inCommand.getEventTypeKey());
        break;
      case PROFILES:
        addProfiles(data);
        break;
      case TABLES:
        addTables(data);
        break;
      case PROFILE:
        addProfile(data, inCommand.getEventTypeKey());
        break;
      case PAGE:
        addPage(data, inCommand.getEventTypeKey());
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
    inData.setFieldGroup(mCoreDao.fields(inFgg));
  }

  private void addFieldGroups(AdminData inData)
  {
    inData.setFieldGroups(mCoreDao.lookups().select(Group.FGG.name()));
  }

  private void addFields(AdminData inData)
  {
    inData.setFields(mCoreDao.lookups().select(Group.FIELD.name()));
  }

  private void addLookup(AdminData inData)
  {
    inData.setLookupGroups(mCoreDao.lookups().select(Group.LOOKUP.name()));
  }

  private void addLookup(AdminData inData, String inGroupName)
  {
    inData.setLookupGroup(mCoreDao.lookups().select(Group.LOOKUP.name(), inGroupName));
  }

  private void addProfiles(AdminData inData)
  {
    inData.setProfiles(mCoreDao.lookups().select(Group.PROFILE.name()));
  }

  private void addProfile(AdminData inData, String inUserName)
  {
    inData.setProfile(mCoreDao.profile(inUserName));
  }

  private void addPages(AdminData inData)
  {
    inData.setPages(mCoreDao.lookups().select(Group.COMPONENTS.name()));
  }

  private void addPage(AdminData inData, String inComponentName)
  {
    inData.setPage(mCoreDao.components(inComponentName));
    String fgg = inData.getPage().getFieldTKG().getFgg();
    addFields(inData, fgg);
  }

  private void addTables(AdminData inData)
  {
    inData.setTables(mCoreDao.lookups().select(Group.FVT.name()));
  }

  private void addCommands(AdminData inData)
  {
    inData.setCommands(mCoreDao.lookups().select(Group.COMMAND.name()));
  }

  private void addAll(AdminData inData)
  {
    addFields(inData);
    addField(inData, inData.getDefaultField());

    addLookup(inData);
    // no default

    addFieldGroups(inData);
    addFields(inData, inData.getDefaultFieldGroup());

    addProfiles(inData);
    // no default

    addPages(inData);
    // no default

    addTables(inData);
    // no default

    addCommands(inData);
    // no default
  }
}