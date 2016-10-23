package net.hus.core.shared.model;

import java.io.IOException;

import org.gwtbootstrap3.client.ui.constants.ColumnOffset;
import org.gwtbootstrap3.client.ui.constants.ColumnPull;
import org.gwtbootstrap3.client.ui.constants.ColumnPush;
import org.gwtbootstrap3.client.ui.constants.ColumnSize;
import org.junit.Before;
import org.junit.Test;

import net.hus.core.shared.model.Column_;
import net.hus.core.shared.model.UIObject_;

public class Column_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newColumn();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  public static Column_ newColumn()
  {
    Column_ ret = new Column_();

    ret.setSize(ColumnSize.SM_1);
    ret.addSize(ColumnSize.SM_5, ColumnSize.MD_5);
    ret.addPull(ColumnPull.SM_5, ColumnPull.MD_5);
    ret.addPush(ColumnPush.SM_5, ColumnPush.MD_5);
    ret.addOffset(ColumnOffset.SM_5, ColumnOffset.MD_5);

    ComplexWidget_Test.initComplexWidget(ret);

    return ret;
  }
}