import java.io.File;
import java.io.IOException;
import java.util.*;
import java.io.FileNotFoundException;
import javax.xml.parsers.*;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class XMLConfigManager97  extends ConfigManager97{

    public XMLConfigManager97(ArrayList<Item97> components){
        super(components);
    }

    public ArrayList<Item97> parseFile() throws FileNotFoundException{
        ArrayList<Item97> components = new ArrayList<Item97>();
        Item97 comp;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("C:\\Users\\Asus\\IdeaProjects\\Assignment03_SDP\\src\\formatXML97.xml"));
            doc.getDocumentElement().normalize();

            Node component = doc.getDocumentElement();
            if(component.getNodeType() == Node.ELEMENT_NODE){
                Element e = (Element) component;
            }
            NodeList componentList = component.getChildNodes();
            for(int i = 0 ; i < componentList.getLength() ; i++){
                Node c = componentList.item(i);
                if(c.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) c;
                    comp = new Item97(element.getTagName(), element.getAttribute("value"), Integer.parseInt(element.getAttribute("X")), Integer.parseInt(element.getAttribute("Y")), Integer.parseInt(element.getAttribute("height")), Integer.parseInt(element.getAttribute("width")), element.getAttribute("font"), Integer.parseInt(element.getAttribute("fontSize")));
                    components.add(comp);
                }
            }
           
           

        }catch(ParserConfigurationException e){
            e.printStackTrace();
        }catch(SAXException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

        return components;
    }
    
}
