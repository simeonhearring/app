package net.hus.core.client.ui;

import java.util.Date;

import org.gwtbootstrap3.extras.notify.client.ui.Notify;

import net.hus.core.client.common.View;
import net.hus.core.client.ui.common.Global;
import net.hus.core.client.ui.common.RpcCallback;
import net.hus.core.model.Field;
import net.hus.core.model.Value;
import net.hus.core.shared.command.ValueInsertCommand;
import net.hus.core.shared.util.NumberUtil;

public abstract class Abstract_View implements View
{
  private Long mFieldId;

  public Abstract_View(String inKey)
  {
    mFieldId = extractFieldId(inKey);
  }

  private Long extractFieldId(String inKey)
  {
    String id = inKey.replaceAll(Field.Component.FV00_.name(), "");
    return NumberUtil.toLong(id);
  }

  protected void save(String inValue, final String inDisplay)
  {
    Value value = new Value();
    value.setValue(inValue);
    value.setKey("JUNIT"); // TODO
    value.setAsOf(new Date());
    value.setField(new Field(mFieldId));

    Global.fire(new ValueInsertCommand(value), new RpcCallback<ValueInsertCommand>()
    {
      @Override
      public void onRpcSuccess(ValueInsertCommand inResult)
      {
        Notify.notify("Saved... " + inDisplay);
      }
    });
  }
}