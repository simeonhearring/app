import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.junit.Test;
import org.xml.sax.SAXException;

import junit.framework.Assert;

public class SchemaTest
{
  private static final String XML[] =
    {
        "Components1.xml",
        "Components2.xml"
    };

  private static final String XSD = "Components.xsd";

  @Test
  public void test()
  {
    for (String value : XML)
    {
      Assert.assertEquals(true, validate(value, XSD));
    }
  }

  private boolean validate(String inXmlFile, String inSchemaFile)
  {
    SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    try
    {
      Schema schema = schemaFactory.newSchema(new File(getResource(inSchemaFile)));

      Validator validator = schema.newValidator();
      validator.validate(new StreamSource(new File(getResource(inXmlFile))));
      return true;
    }
    catch (SAXException | IOException e)
    {
      e.printStackTrace();
      return false;
    }
  }

  private String getResource(String inFilename) throws FileNotFoundException
  {
    URL resource = getClass().getClassLoader().getResource(inFilename);
    Objects.requireNonNull(resource);
    return resource.getFile();
  }
}