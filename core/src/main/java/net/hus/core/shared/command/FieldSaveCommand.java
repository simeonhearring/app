package net.hus.core.shared.command;

import net.hus.core.shared.model.Field;
import net.hus.core.shared.rpc.CommandName;

@CommandName("FieldSaveCommand")
public class FieldSaveCommand extends AbstractCommand
{
  private static final long serialVersionUID = -7605712430201674417L;

  private Field mField;

  FieldSaveCommand()
  {
  }

  public FieldSaveCommand(Field inField)
  {
    mField = inField;
  }

  public Field getField()
  {
    return mField;
  }
}