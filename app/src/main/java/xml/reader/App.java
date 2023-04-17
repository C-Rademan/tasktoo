/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package xml.reader;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
        try {
            // Get the input stream to the XML file
            InputStream inputStream = App.class.getClassLoader().getResourceAsStream("data.xml");

            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder from the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input stream into a Document
            Document doc = builder.parse(inputStream);

            // Get the root element
            Node root = doc.getDocumentElement();
            System.out.println("Root element: " + root.getNodeName());

            // Get the nodes with the tag name "person"
            NodeList nodeList = doc.getElementsByTagName("person");

            // Print the contents of each "person" node
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                System.out.println("Person #" + (i+1) + ": " + node.getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
