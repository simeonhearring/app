package net.hus.core.client.ui.components;

import org.gwtbootstrap3.client.ui.html.Span;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.shared.components.FlexTable_.Table;
import net.hus.core.shared.model.FieldTKG;
import net.hus.core.shared.util.StringUtil;

public class FlexTable_View extends AbstractComposite_View<FlexTable, Table> implements ClickHandler
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, FlexTable_View>
  {
  }

  @UiField
  FlexTable mComponent;

  public FlexTable_View()
  {
    initWidget(BINDER.createAndBindUi(this));
  }

  public FlexTable getComponent()
  {
    return mComponent;
  }

  @Override
  public void setFieldTKG(FieldTKG inFTKG)
  {
    super.setFieldTKG(inFTKG);
    mComponent.addClickHandler(this);
  }

  @Override
  public void setValue(Table inValue)
  {
    if (inValue != null && inValue.getTable() != null)
    {
      int headColCt = mComponent.getCellCount(0);

      for (String[] object : inValue.getTable())
      {
        int col = 0;
        int row = mComponent.getRowCount();

        for (String val : object)
        {
          Span span = new Span();
          span.setText(val);
          span.getElement().setAttribute("contenteditable", "true");
          mComponent.setWidget(row, col++, span);
        }

        if (col < headColCt)
        {
          for (; col < headColCt; col++)
          {
            Span span = new Span();
            span.getElement().setAttribute("contenteditable", "true");
            mComponent.setWidget(row, col, span);
          }
        }
      }
    }
  }

  @Override
  public void onClick(ClickEvent inEvent)
  {
    save(values());
  }

  private Table values()
  {
    Table ret = new Table();
    for (int r = 1; r < mComponent.getRowCount(); r++)
    {
      int colCt = mComponent.getCellCount(r);
      String[] colVals = new String[colCt];
      for (int c = 0; c < colCt; c++)
      {
        Span span = (Span) mComponent.getWidget(r, c);
        if (span != null)
        {
          colVals[c] = StringUtil.nullIfEmpty(span.getText());
        }
      }
      ret.add(colVals);
    }
    return ret;
  }
}