package net.hus.core.client.ui.components;

import java.util.Date;

import org.gwtbootstrap3.extras.notify.client.ui.Notify;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.common.Component;
import net.hus.core.client.ui.common.Global;
import net.hus.core.client.ui.common.RpcCallback;
import net.hus.core.shared.command.TableInsertCommand;
import net.hus.core.shared.command.ValueInsertCommand;
import net.hus.core.shared.components.FlexTable_.Table;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.FieldTKG;
import net.hus.core.shared.model.Value;

public abstract class AbstractComposite_View<C extends Widget, V> extends Composite
    implements Component<V>
{
  protected FieldTKG mTableFvk;
  protected Field mField;
  private String mLabel;

  @Override
  public void setField(Field inField)
  {
    mField = inField;
  }

  @Override
  public void setFieldTKG(FieldTKG inTableFvk)
  {
    mTableFvk = inTableFvk;
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
    value.setTableFvk(mTableFvk);
    value.setAsOf(new Date());
    value.setField(mField);
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