package net.hus.core.shared.command;

import java.util.ArrayList;
import java.util.List;

import net.hus.core.model.Value;
import net.hus.core.shared.rpc.CommandName;

@CommandName("ValueInsertCommand")
public class ValueInsertCommand extends AbstractCommand
{
  private static final long serialVersionUID = -6914844003117393436L;

  private List<Value> mValues = new ArrayList<>();

  public ValueInsertCommand()
  {
  }

  public ValueInsertCommand(Value inValue)
  {
    add(inValue);
  }

  public void add(Value inValue)
  {
    mValues.add(inValue);
  }

  public List<Value> getValues()
  {
    return mValues;
  }
}