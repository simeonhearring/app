package net.hus.core.client.ui;

import java.util.Date;

import org.gwtbootstrap3.extras.notify.client.ui.Notify;

import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.common.Component;
import net.hus.core.client.ui.common.Global;
import net.hus.core.client.ui.common.RpcCallback;
import net.hus.core.model.Field;
import net.hus.core.model.TableKey;
import net.hus.core.model.Value;
import net.hus.core.shared.command.TableInsertCommand;
import net.hus.core.shared.command.ValueInsertCommand;
import net.hus.core.shared.model.FlexTable_.Table;
import net.hus.core.shared.util.NumberUtil;

public abstract class Abstract_View<C extends Widget, V> implements Component<V>
{
  private TableKey mTableKey;
  private Long mFieldId;
  private String mLabel;

  protected C mComponent;

  public Abstract_View(String inKey, C inComponent)
  {
    mFieldId = extractFieldId(inKey);
    mComponent = inComponent;
  }

  @Override
  public final Widget asWidget()
  {
    return mComponent;
  }

  @Override
  public void setTableKey(TableKey inTableKey)
  {
    mTableKey = inTableKey;
  }

  // TODO what if it is a name
  private Long extractFieldId(String inKey)
  {
    String id = inKey.replaceAll(Field.Component.FV00_.name(), "");
    return NumberUtil.toLong(id);
  }

  @Override
  public void setLabel(String inLabel)
  {
    mLabel = inLabel;
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
        Notify.notify("Saved... '" + mLabel + "' to " + inDisplay);
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
        Notify.notify("Saved... " + mLabel);
      }
    });
  }
}