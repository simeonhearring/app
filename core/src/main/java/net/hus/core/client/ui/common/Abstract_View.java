package net.hus.core.client.ui.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.extras.notify.client.ui.Notify;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.common.View;
import net.hus.core.shared.command.TableInsertCommand;
import net.hus.core.shared.command.ValueInsertCommand;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.FieldTKG;
import net.hus.core.shared.model.Table;
import net.hus.core.shared.model.Value;

public abstract class Abstract_View<C extends Widget> implements View, ClickHandler
{
  protected FieldTKG mFieldTKG;
  protected C mComponent;
  protected Field mField;
  private String mLabel;
  private int mPos;

  private List<HandlerRegistration> mRegistration = new ArrayList<>();

  public Abstract_View(C inComponent)
  {
    mComponent = inComponent;
  }

  @Override
  public C getComponent()
  {
    return mComponent;
  }

  @Override
  public void setField(Field inField)
  {
    mField = inField;
  }

  @Override
  public final Widget asWidget()
  {
    // not currently added to ui. here for testing.
    return mComponent;
  }

  @Override
  public void setFieldTKG(FieldTKG inFieldTKG)
  {
    mFieldTKG = inFieldTKG;
  }

  @Override
  public void setLabel(String inLabel)
  {
    mLabel = inLabel;
  }

  private Value newValue(String inValue, Long inValueId)
  {
    // duplicated See AbstractComposite_View.java
    Value value = new Value();
    value.setValue(inValue);
    value.setValueId(inValueId);
    value.setAsOf(new Date());
    value.setFieldTKG(mFieldTKG);
    value.setField(mField);
    value.setPos(mPos);
    return value;
  }

  private Value newValue(Table inValue)
  {
    Value value = newValue((String) null, null);
    value.setTable(inValue);
    return value;
  }

  protected void save(String inValue, final String inDisplay)
  {
    Value value = newValue(inValue, null);

    Global.fire(new ValueInsertCommand(value), new RpcCallback<ValueInsertCommand>()
    {
      @Override
      public void onRpcSuccess(ValueInsertCommand inResult)
      {
        Notify.notify("Saved... '" + mLabel + "' [" + mPos + "] to " + inDisplay);
      }
    });
  }

  protected void save(String inValue, Long inValueId, final String inDisplay)
  {
    Value value = newValue(inValue, inValueId);

    Global.fire(new ValueInsertCommand(value), new RpcCallback<ValueInsertCommand>()
    {
      @Override
      public void onRpcSuccess(ValueInsertCommand inResult)
      {
        Notify.notify("Saved... '" + mLabel + "' [" + mPos + "] to " + inDisplay);
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

  @Override
  public void onClick(ClickEvent inEvent)
  {
    if (inEvent.isAltKeyDown())
    {
      Notify.notify("FIELD INFO", mField.getInfo(), IconType.INFO_CIRCLE);
    }
  }

  protected void add(HandlerRegistration inRegistration)
  {
    mRegistration.add(inRegistration);
  }

  protected void clearRegistration()
  {
    for (HandlerRegistration value : mRegistration)
    {
      value.removeHandler();
    }
    mRegistration.clear();
  }

  @Override
  public void setPos(int inPos)
  {
    mPos = inPos;
  }
}