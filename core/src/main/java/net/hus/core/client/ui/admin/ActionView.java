package net.hus.core.client.ui.admin;

import org.gwtbootstrap3.client.ui.Icon;
import org.gwtbootstrap3.client.ui.constants.IconType;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.common.Callback;
import net.hus.core.client.model.admin.ActionDisplay;
import net.hus.core.client.ui.common.AbstractView;

public class ActionView extends AbstractView implements ActionDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, ActionView>
  {
  }

  @UiField
  Icon mSave, mRemove, mRefresh;

  private Callback<IconType> mCallback;

  public ActionView()
  {
    initWidget(BINDER.createAndBindUi(this));
  }

  @UiHandler(
      {
        "mSave",
        "mRemove",
        "mRefresh"
      })
  public void onClickBind(ClickEvent inEvent)
  {
    if (mSave.equals(inEvent.getSource()))
    {
      mCallback.onDone(mSave.getType());
    }
    else if (mRefresh.equals(inEvent.getSource()))
    {
      mCallback.onDone(mRefresh.getType());
    }
    else if (mRemove.equals(inEvent.getSource()))
    {
      mCallback.onDone(mRemove.getType());
    }
  }

  @Override
  public void setCallback(Callback<IconType> inCallback)
  {
    mCallback = inCallback;
  }
}