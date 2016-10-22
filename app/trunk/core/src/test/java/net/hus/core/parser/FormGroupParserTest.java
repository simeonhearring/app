package net.hus.core.parser;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.client.ui.FormGroup_;
import net.hus.core.client.ui.FormGroup_Test;
import net.hus.core.util.ResourceUtil;

public class FormGroupParserTest
{
  @Test
  public void test()
  {
    FormGroupParser parser = new FormGroupParser();

    FormGroup_ model = FormGroup_Test.newFormGroup();

    String expected = ResourceUtil.contents("net/hus/core/client/ui/FormGroup_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }
}