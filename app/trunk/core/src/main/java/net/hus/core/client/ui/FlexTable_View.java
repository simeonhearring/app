package net.hus.core.client.ui;

import org.gwtbootstrap3.client.ui.html.Span;
import org.gwtbootstrap3.extras.notify.client.ui.Notify;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.shared.model.FlexTable_.Table;

public class FlexTable_View extends Abstract_View<Table>
implements ClickHandler
{
  private FlexTable mView;

  public FlexTable_View(String inKey, FlexTable inView)
  {
    super(inKey);
    mView = inView;
    mView.addClickHandler(this);
  }

  public FlexTable_View(String inKey, FlexTable inView, Table inTable)
  {
    this(inKey, inView);
    setView(inTable);
  }

  @Override
  public void setView(Table inValue)
  {
    for (String[] object : inValue.getTable())
    {
      int col = 0;
      int row = mView.getRowCount();

      for (String val : object)
      {
        Span span = new Span();
        span.setText(val);
        span.getElement().setAttribute("contenteditable", "true");
        mView.setWidget(row, col++, span);
      }
    }
  }

  @Override
  public Widget asWidget()
  {
    return mView;
  }

  @Override
  public void onClick(ClickEvent inEvent)
  {
    save(values(), "Table"); // TODO
  }

  private Table values()
  {
    Table ret = new Table();
    for (int r = 1; r < mView.getRowCount(); r++)
    {
      int colCt = mView.getCellCount(r);
      String[] colVals = new String[colCt];
      for (int c = 0; c < colCt; c++)
      {
        Span span = (Span) mView.getWidget(r, c);
        colVals[c] = span.getText();
      }
      ret.add(colVals);
    }
    return ret;
  }
}