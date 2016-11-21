package net.hus.core.client.model.admin;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.gwtbootstrap3.client.ui.constants.ValidationState;

import net.hus.core.client.model.admin.FieldDisplay.Action;
import net.hus.core.client.ui.common.Global;
import net.hus.core.client.ui.common.RpcCallback;
import net.hus.core.client.ui.event.AdminEvent;
import net.hus.core.shared.command.AdminDataCommand;
import net.hus.core.shared.command.FieldSaveCommand;
import net.hus.core.shared.model.AdminData;
import net.hus.core.shared.model.EventType;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.Field.DataType;
import net.hus.core.shared.model.Lookup;
import net.hus.core.shared.util.EnumUtil;

public class FieldPresenter extends RpcCallback<AdminDataCommand>
implements Action, AdminEvent.Handler
{
  private FieldDisplay mDisplay;

  private Field mField;

  public FieldPresenter(FieldDisplay inDisplay)
  {
    Global.addHandler(AdminEvent.TYPE, this);
    mDisplay = inDisplay;
    mDisplay.setAction(this);
  }

  @Override
  public void dispatch(AdminEvent inEvent)
  {
    process(inEvent.getType(), inEvent.getData());
  }

  @Override
  public void onRpcSuccess(AdminDataCommand inCommand)
  {
    process(inCommand.getType(), inCommand.getData());
  }

  private void process(EventType inType, AdminData inData)
  {
    switch (inType)
    {
      case ALL:
        addFields(inData.data(), inData.getField(), inData.getLookupGroups());
        break;
      case FIELD:
        set(inData.getField());
        break;
      default:
        break;
    }
  }

  @Override
  public void saveField()
  {
    Global.fire(new FieldSaveCommand(mField), new RpcCallback<FieldSaveCommand>()
    {
      @Override
      public void onRpcSuccess(FieldSaveCommand inCommand)
      {
        mDisplay.notify("Saved ... " + mField.getName());
      }
    });
  }

  @Override
  public void refreshFields()
  {
    Global.fire(new AdminDataCommand(EventType.ALL), this);
  }

  @Override
  public ValidationState addField(String inName, String inType)
  {
    ValidationState ret = ValidationState.NONE;

    if (!"".equals(inName))
    {
      set(new Field(inName, EnumUtil.valueOf(inType, Field.Type.values())));
      saveField();
    }
    else
    {
      ret = ValidationState.ERROR;
      mDisplay.notify("Name is required!");
    }

    return ret;
  }

  @Override
  public void select(Long inFieldId)
  {
    Global.fire(new AdminDataCommand(inFieldId, EventType.FIELD), this);
  }

  @Override
  public void update(DataType inType, String inValue)
  {
    mField.update(inType, inValue);
    mDisplay.notify("Updated ... " + inType.display() + " [" + inValue + "].");
  }

  @Override
  public void updateArray(String[] inLabels)
  {
    StringBuilder sb = new StringBuilder();
    for (String value : inLabels)
    {
      sb.append(value).append(",");
    }
    update(DataType.ARRAY_LABELS, sb.toString());
    update(DataType.ARRAY_SIZE, String.valueOf(inLabels.length));
  }

  @Override
  public String arrayLabel(int inPos)
  {
    return mField.getArrayLabel(inPos);
  }

  private void set(Field inField)
  {
    mField = inField;
    mDisplay.set(mField);
  }

  private void addFields(Map<String, List<Lookup>> inData, Field inField,
      List<String> inLookupGroups)
  {
    mDisplay.clearFields();
    for (Entry<String, List<Lookup>> value : inData.entrySet())
    {
      mDisplay.addFields(value.getKey(), value.getValue());
    }
    mDisplay.refreshFields();

    set(inField);

    mDisplay.addLookup(inLookupGroups);
  }
}