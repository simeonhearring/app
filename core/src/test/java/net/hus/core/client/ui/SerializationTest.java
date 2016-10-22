package net.hus.core.client.ui;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Assert;

import net.hus.core.util.ServerErrorUtil;

public class SerializationTest
{
  public static void canSerializeObj(UIObject_ inObject) throws IOException, ClassNotFoundException
  {
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    ObjectOutputStream oos = new ObjectOutputStream(out);
    oos.writeObject(inObject);
    oos.close();

    byte[] bytes = out.toByteArray();
    InputStream in = new ByteArrayInputStream(bytes);
    ObjectInputStream ois = new ObjectInputStream(in);
    Object o = ois.readObject();

    String expected = ServerErrorUtil.objectToString(inObject, true);
    String actual = ServerErrorUtil.objectToString(o, true);
    Assert.assertEquals(expected, actual);
  }
}