package net.hus.core.shared.model;

import java.io.IOException;

import org.gwtbootstrap3.client.ui.constants.ColumnOffset;
import org.gwtbootstrap3.client.ui.constants.ColumnPull;
import org.gwtbootstrap3.client.ui.constants.ColumnPush;
import org.gwtbootstrap3.client.ui.constants.ColumnSize;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.parser.Column_Parser;
import net.hus.core.util.ResourceUtil;

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

  @Test
  public void canParse()
  {
    Column_Parser parser = new Column_Parser();

    Column_ model = Column_Test.newColumn();

    String expected = ResourceUtil.contents("net/hus/core/shared/model/Column_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
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