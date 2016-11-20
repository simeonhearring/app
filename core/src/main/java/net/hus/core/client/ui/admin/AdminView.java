package net.hus.core.client.ui.admin;

import org.gwtbootstrap3.client.ui.Column;
import org.gwtbootstrap3.client.ui.Row;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.model.admin.AdminDisplay;
import net.hus.core.client.model.admin.FieldGroupsDisplay;
import net.hus.core.client.model.admin.FieldsDisplay;
import net.hus.core.client.ui.page.AbstractRowView;
import net.hus.core.shared.model.Page.Section;

public class AdminView extends AbstractRowView implements AdminDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, AdminView>
  {
  }

  @UiField
  Row mRow0;

  @UiField
  Column mL01, mC01, mR01;

  @UiField
  FieldsView mFields;

  @UiField
  FieldGroupsView mGroups;

  public AdminView()
  {
    initWidget(BINDER.createAndBindUi(this));
    mC01.setId(Section.Name.ADMINC01.name());
  }

  @Override
  public Row[] getRow()
  {
    Row[] ret =
      {
          mRow0
      };
    return ret;
  }

  @Override
  public FieldsDisplay getFields()
  {
    return mFields;
  }

  @Override
  public FieldGroupsDisplay getGroups()
  {
    return mGroups;
  }
}