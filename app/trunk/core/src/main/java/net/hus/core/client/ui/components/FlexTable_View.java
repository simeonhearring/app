package net.hus.core.client.ui.components;

import org.gwtbootstrap3.client.ui.Heading;
import org.gwtbootstrap3.client.ui.Icon;
import org.gwtbootstrap3.client.ui.constants.HeadingSize;
import org.gwtbootstrap3.client.ui.html.Span;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.TextDecoration;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.shared.model.Field.Array;
import net.hus.core.shared.model.Table;
import net.hus.core.shared.model.Value;
import net.hus.core.shared.util.StringUtil;

public class FlexTable_View extends AbstractComposite_View<FlexTable>
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, FlexTable_View>
  {
  }

  @UiField
  FlexTable mComponent;

  @UiField
  Icon mAdd0, mSave0, mAdd1, mSave1;

  private int mShowBottomAtRow = 10;
  private boolean mAltColor = true;
  private String mAltOdd = "FFF";
  private String mAltEven = "#CCC";
  private HeadingSize mHeadSize = HeadingSize.H2;

  public FlexTable_View()
  {
    initWidget(BINDER.createAndBindUi(this));
  }

  @Override
  public FlexTable getComponent()
  {
    return mComponent;
  }

  @UiHandler(
      {
        "mAdd0",
        "mSave0",
        "mAdd1",
        "mSave1"
      })
  public void add(ClickEvent inEvent)
  {
    if (mAdd0.equals(inEvent.getSource()) || mAdd1.equals(inEvent.getSource()))
    {
      addRow(mComponent.getCellCount(0), "--Enter info--");
    }
    else if (mSave0.equals(inEvent.getSource()) || mSave1.equals(inEvent.getSource()))
    {
      save(values());
    }
  }

  @Override
  public void addChangeHandler()
  {
  }

  @Override
  public void setValue(Value inValue)
  {
    mComponent.removeAllRows();

    setProperties(inValue.getField().getArray().getProperties());
    addHeaders(inValue.getField().getArray().getLabels());

    Table table = inValue.getTable();
    if (table != null && table.getTable() != null)
    {
      int headColCt = mComponent.getCellCount(0);

      for (String[] value : table.getTable())
      {
        addRow(headColCt, value);
      }
    }
  }

  private void setProperties(Array.Properties inArrayProp)
  {
    if (inArrayProp != null)
    {
      Integer showBottomAtRow = inArrayProp.getShowBottomAtRow();
      Boolean altColor = inArrayProp.getAltRow();
      String altEven = inArrayProp.getAltEvenColor();
      String altOdd = inArrayProp.getAltOddColor();
      HeadingSize headSize = inArrayProp.getHeadingSize();

      if (showBottomAtRow != null)
      {
        mShowBottomAtRow = showBottomAtRow;
      }
      if (altColor != null)
      {
        mAltColor = altColor;
      }
      if (altEven != null)
      {
        mAltEven = altEven;
      }
      if (altOdd != null)
      {
        mAltOdd = altOdd;
      }
      if (headSize != null)
      {
        mHeadSize = headSize;
      }
    }
  }

  private void addRow(int inHeadColCt, String... inValues)
  {
    int col = 0;
    int row = mComponent.getRowCount();

    mAdd1.setVisible(row >= mShowBottomAtRow);
    mSave1.setVisible(row >= mShowBottomAtRow);

    if (inValues != null)
    {
      for (String val : inValues)
      {
        Span span = new Span();
        span.setText(val);
        span.getElement().setAttribute("contenteditable", "true");
        mComponent.setWidget(row, col++, span);
      }
    }

    completeRow(inHeadColCt, col, row);

    if (mAltColor)
    {
      mComponent.getRowFormatter().getElement(row).getStyle().setBackgroundColor(altColor(row));
    }
  }

  private String altColor(int inRow)
  {
    return inRow % 2 == 0 ? mAltEven : mAltOdd;
  }

  private void completeRow(int inHeadColCt, int inCol, int inRow)
  {
    if (inCol < inHeadColCt)
    {
      for (; inCol < inHeadColCt; inCol++)
      {
        Span span = new Span();
        span.getElement().setAttribute("contenteditable", "true");
        mComponent.setWidget(inRow, inCol, span);
      }
    }
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

  private void addHeaders(String[] inLabels)
  {
    int col = 0;
    for (String value : inLabels)
    {
      Heading heading = new Heading(mHeadSize, value);
      heading.getElement().getStyle().setTextDecoration(TextDecoration.UNDERLINE);
      mComponent.setWidget(0, col++, heading);
    }
  }
}