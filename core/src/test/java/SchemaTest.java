import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import junit.framework.Assert;

public class SchemaTest
{
  private static final String PATH = "src/main/resources/";
  private static final String XML = "Page.xml";
  private static final String XSD = "Components.xsd";

  @Test
  public void test2()
  {
    boolean valid = validate(XML, XSD);
    // Assert.assertEquals("%s validation = %b.", true, valid);
    System.out.printf("%s validation = %b.", XSD, valid);
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

  // @Test
  public void test() throws ParserConfigurationException, SAXException, IOException
  {
    // parse an XML document into a DOM tree
    DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    Document document = parser.parse(new File(PATH + XML));

    // create a SchemaFactory capable of understanding WXS schemas
    SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

    // load a WXS schema, represented by a Schema instance
    Source schemaFile = new StreamSource(new File(PATH + XSD));
    Schema schema = factory.newSchema(schemaFile);

    // create a Validator instance, which can be used to validate an instance
    // document
    Validator validator = schema.newValidator();

    // validate the DOM tree
    try
    {
      validator.validate(new DOMSource(document));
    }
    catch (SAXException e)
    {
      e.printStackTrace();
      Assert.fail();
    }
  }
}