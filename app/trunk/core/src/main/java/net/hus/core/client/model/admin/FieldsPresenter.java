package net.hus.core.client.model.admin;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.gwtbootstrap3.client.ui.constants.ValidationState;

import net.hus.core.client.model.admin.FieldsDisplay.Action;
import net.hus.core.client.ui.common.Global;
import net.hus.core.client.ui.common.RpcCallback;
import net.hus.core.shared.command.FieldSaveCommand;
import net.hus.core.shared.command.FieldsDataCommand;
import net.hus.core.shared.command.FieldsDataCommand.Type;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.Field.DataType;
import net.hus.core.shared.model.FieldsData;
import net.hus.core.shared.model.Lookup;
import net.hus.core.shared.util.EnumUtil;

public class FieldsPresenter extends RpcCallback<FieldsDataCommand> implements Action
{
  private FieldsDisplay mDisplay;

  private FieldsData mData;

  private Field mField;


  public FieldsPresenter(FieldsDisplay inDisplay)
  {
    mDisplay = inDisplay;
    mDisplay.setAction(this);
    refresh();
  }

  @Override
  public void onRpcSuccess(FieldsDataCommand inCommand)
  {
    mData = inCommand.getData();

    switch (inCommand.getType())
    {
      case ALL:
        addFields(mData.data(), mData.getField());
        break;
      case SINGLE:
        addField(mData.getField());
        break;
      default:
        break;
    }
  }

  private void addField(Field inField)
  {
    mField = inField;
    mDisplay.set(mField);
  }

  private void addFields(Map<String, List<Lookup>> inData, Field inField)
  {
    mDisplay.clear();
    for (Entry<String, List<Lookup>> value : inData.entrySet())
    {
      mDisplay.add(value.getKey(), value.getValue());
    }
    mDisplay.refresh();

    mDisplay.addLookup(mData.getLookupGroups());
    addField(inField);
  }

  @Override
  public void save()
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
  public void refresh()
  {
    Global.fire(new FieldsDataCommand(Type.ALL, null), this);
  }

  @Override
  public ValidationState add(String inName, String inType)
  {
    ValidationState ret = ValidationState.NONE;

    if (!"".equals(inName))
    {
      if (mData.exists(inName))
      {
        ret = ValidationState.ERROR;
        mDisplay.notify("Field already exists!");
      }
      else
      {
        addField(new Field(inName, EnumUtil.valueOf(inType, Field.Type.values())));
        save();
      }
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
    Global.fire(new FieldsDataCommand(Type.SINGLE, inFieldId), this);
  }

  @Override
  public void update(DataType inType, String inValue)
  {
    mField.update(inType, inValue);
  }

  public FieldsDisplay getDisplay()
  {
    return mDisplay;
  }
}