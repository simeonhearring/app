package net.hus.core.client.ui.page;

import org.gwtbootstrap3.client.ui.Column;
import org.gwtbootstrap3.client.ui.Row;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.model.page.LoginDisplay;
import net.hus.core.shared.model.Page.Section;

public class LoginView extends AbstractRowView implements LoginDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, LoginView>
  {
  }

  @UiField
  Row mRow;

  @UiField
  Column mL01, mC01, mR01;

  public LoginView()
  {
    initWidget(BINDER.createAndBindUi(this));

    mL01.setId(Section.Name.LOGINL01.name());
    mC01.setId(Section.Name.LOGINC01.name());
    mR01.setId(Section.Name.LOGINR01.name());
  }

  @Override
  public Row[] getRow()
  {
    return new Row[]
    {
        mRow
    };
  }
}