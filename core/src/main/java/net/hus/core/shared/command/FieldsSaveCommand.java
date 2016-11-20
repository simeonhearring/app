package net.hus.core.shared.command;

import java.util.List;

import net.hus.core.shared.rpc.CommandName;

@CommandName("FieldsSaveCommand")
public class FieldsSaveCommand extends AbstractCommand
{
  private static final long serialVersionUID = -497636990200967152L;

  private String mFgg;
  private List<Long> mFieldIds;

  FieldsSaveCommand()
  {
  }

  public FieldsSaveCommand(String inFgg, List<Long> inFieldIds)
  {
    mFgg = inFgg;
    mFieldIds = inFieldIds;
  }

  public String getFgg()
  {
    return mFgg;
  }

  public List<Long> getFieldIds()
  {
    return mFieldIds;
  }
}