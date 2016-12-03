package net.hus.core.server.command;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.Field.Type;
import net.hus.core.shared.model.FieldTKG;
import net.hus.core.shared.model.Value;

public class ValuesCommandBeanTest
{
  private ValuesCommandBean mBean;

  @Before
  public void before()
  {
    mBean = new ValuesCommandBean();
  }

  @Test
  public void test()
  {
    List<Value> list = new ArrayList<>();

    list.add(newValue(Type.STRING, 1L, 0));
    list.add(newValue(Type.STRING, 2L, 0));
    list.add(newValue(Type.TABLE, 3L, 0));
    list.add(newValue(Type.STRING, 10L, 0));
    list.add(newValue(Type.STRING, 10L, 1));
    list.add(newValue(Type.STRING, 10L, 2));
    list.add(newValue(Type.STRING, 11L, 0));
    list.add(newValue(Type.STRING, 4L, 0));

    List<Value> results = mBean.checkForArrays(list, new FieldTKG("P1", "6", "FG1"));

    Assert.assertEquals(4, results.size());
    Assert.assertEquals(4, list.get(2).getValues().getValues().size());
  }

  @Test
  public void test1()
  {
    List<Value> list = new ArrayList<>();

    list.add(newValue(Type.STRING, 1L, 0));
    list.add(newValue(Type.STRING, 2L, 0));
    list.add(newValue(Type.TABLE, 3L, 0));
    list.add(newValue(Type.STRING, 4L, 0));

    List<Value> results = mBean.checkForArrays(list, new FieldTKG("P1", "6", "FG1"));

    Assert.assertEquals(4, results.size());
    Assert.assertEquals(0, list.get(2).getValues().getValues().size());
  }

  private static Value newValue(Type inType, Long inFieldId, int inPos)
  {
    Value value = new Value();
    value.setField(new Field(inFieldId));
    value.getField().getProperties().getArray().setFields(10L, 11L, 12L);
    value.getField().getProperties().getArray().setFvt("P1");
    value.getField().setType(inType);
    value.setPos(inPos);
    return value;
  }
}
