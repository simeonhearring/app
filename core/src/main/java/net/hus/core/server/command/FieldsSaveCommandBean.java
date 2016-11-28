package net.hus.core.server.command;

import net.hus.core.shared.command.FieldsSaveCommand;
import net.hus.core.shared.model.Fields;
import net.hus.core.shared.rpc.common.RpcResponse;

public class FieldsSaveCommandBean extends AbstractCommandBean<FieldsSaveCommand>
{
  @Override
  public RpcResponse execute(FieldsSaveCommand inCommand)
  {
    Fields fields = mCoreDao.fields(inCommand.getFgg());
    mCoreDao.fields().upsert(fields.upsert(inCommand.getFgg(), inCommand.getFieldIds()));
    mCoreDao.fields().delete(fields.delete(inCommand.getFgg(), inCommand.getFieldIds()));
    mCoreDao.fields2lookup();
    return inCommand;
  }
}