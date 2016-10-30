package net.hus.core.client.ui;

import java.util.Date;

import org.gwtbootstrap3.extras.notify.client.ui.Notify;

import net.hus.core.client.common.View;
import net.hus.core.client.ui.common.Global;
import net.hus.core.client.ui.common.RpcCallback;
import net.hus.core.model.Field;
import net.hus.core.model.TableKey;
import net.hus.core.model.Value;
import net.hus.core.shared.command.TableInsertCommand;
import net.hus.core.shared.command.ValueInsertCommand;
import net.hus.core.shared.model.FlexTable_.Table;
import net.hus.core.shared.util.NumberUtil;

public abstract class Abstract_View<T> implements View<T>
{
  private TableKey mTableKey;
  private Long mFieldId;
  private String mFieldName;

  public Abstract_View(String inKey)
  {
    mFieldId = extractFieldId(inKey);
  }

  @Override
  public void setTableKey(TableKey inTableKey)
  {
    mTableKey = inTableKey;
  }

  // what if it is a name
  private Long extractFieldId(String inKey)
  {
    String id = inKey.replaceAll(Field.Component.FV00_.name(), "");
    return NumberUtil.toLong(id);
  }

  @Override
  public void setFieldName(String inFieldName)
  {
    mFieldName = inFieldName;
  }

  private Value newValue(String inValue)
  {
    Value value = new Value();
    value.setValue(inValue);
    value.setTableKey(mTableKey);
    value.setAsOf(new Date());
    value.setField(new Field(mFieldId));
    return value;
  }

  private Value newValue(Table inValue)
  {
    Value value = newValue((String) null);
    value.setTable(inValue);
    return value;
  }

  protected void save(String inValue, final String inDisplay)
  {
    Value value = newValue(inValue);

    Global.fire(new ValueInsertCommand(value), new RpcCallback<ValueInsertCommand>()
    {
      @Override
      public void onRpcSuccess(ValueInsertCommand inResult)
      {
        Notify.notify("Saved... '" + mFieldName + "' to " + inDisplay);
      }
    });
  }

  protected void save(Table inTable)
  {
    Value value = newValue(inTable);

    Global.fire(new TableInsertCommand(value), new RpcCallback<TableInsertCommand>()
    {
      @Override
      public void onRpcSuccess(TableInsertCommand inResult)
      {
        Notify.notify("Saved... " + mFieldName);
      }
    });
  }
}