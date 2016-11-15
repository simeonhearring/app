package net.hus.core.client.model.admin;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;

import net.hus.core.client.ui.common.Global;
import net.hus.core.client.ui.common.RpcCallback;
import net.hus.core.shared.command.FieldsDataCommand;
import net.hus.core.shared.command.FieldsDataCommand.Type;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.Lookup;

public class FieldsPresenter extends RpcCallback<FieldsDataCommand>
implements ValueChangeHandler<String>
{
  private FieldsDisplay mDisplay;

  public FieldsPresenter(FieldsDisplay inDisplay)
  {
    mDisplay = inDisplay;
    mDisplay.addValueChangeHandler(this);
    Global.fire(new FieldsDataCommand(Type.ALL, null), this);
  }

  @Override
  public void onRpcSuccess(FieldsDataCommand inCommand)
  {
    switch (inCommand.getType())
    {
      case ALL:
        addFields(inCommand.getData().data());
        break;
      case SINGLE:
        addField(inCommand.getData().getField());
        break;
      default:
        break;
    }
  }

  private void addField(Field inField)
  {
    mDisplay.add(inField);
  }

  private void addFields(Map<String, List<Lookup>> inData)
  {
    mDisplay.clear();
    for (Entry<String, List<Lookup>> value : inData.entrySet())
    {
      mDisplay.add(value.getKey(), value.getValue());
    }
    mDisplay.refresh();
  }

  @Override
  public void onValueChange(ValueChangeEvent<String> inEvent)
  {
    Long value = mDisplay.getFieldId(inEvent);
    Global.fire(new FieldsDataCommand(Type.SINGLE, value), this);
  }
}