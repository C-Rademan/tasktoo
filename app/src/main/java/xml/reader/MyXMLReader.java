package xml.reader;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class MyXMLReader extends DefaultHandler {
    public static void main(String[] args) {
        try {
            // Create a SAXParserFactory object
            SAXParserFactory factory = SAXParserFactory.newInstance();
            // Create a SAXParser object
            SAXParser saxParser = factory.newSAXParser();
            // Parse the XML file using the handler
            saxParser.parse(new File("example.xml"), new MyXMLReader());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start Element: " + qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.println("\tAttribute: " + attributes.getQName(i) + " = " + attributes.getValue(i));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length).trim();
        if (!content.isEmpty()) {
            System.out.println("Content: " + content);
        }
    }
}
