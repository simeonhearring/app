package net.hus.core.shared.command;

import net.hus.core.model.Value;
import net.hus.core.shared.model.FlexTable_.Table;
import net.hus.core.shared.rpc.CommandName;

@CommandName("TableInsertCommand")
public class TableInsertCommand extends AbstractCommand
{
  private static final long serialVersionUID = 3464151262330710928L;

  private Value mValue;
  private Table mTable;

  public TableInsertCommand()
  {
  }

  public TableInsertCommand(Value inValue, Table inTable)
  {
    mValue = inValue;
    mTable = inTable;
  }

  public Value getValue()
  {
    return mValue;
  }

  public Table getTable()
  {
    return mTable;
  }
}