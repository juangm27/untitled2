import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Practica1Ej2 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("Becarios.xml"));
            document.getDocumentElement().normalize();
            System.out.printf("Elemento raiz: %s %n", document.getDocumentElement().getNodeName());

            NodeList becarios= document.getElementsByTagName("becario");
            System.out.printf("Nodos becario a recorrer: %d %n", becarios.getLength());
            for (int i=0; i < becarios.getLength(); i ++){
                Node bec = becarios.item(i); //obtener un nodo empleado
                if (bec.getNodeType() == Node.ELEMENT_NODE){ //tipo nodo
                    //obtener los elementos del nodo
                    Element elemento= (Element) bec;

                    System.out.printf("Nombre: %s %n", elemento.getElementsByTagName ("nombre").item(0).getTextContent());

                    System.out.printf("Apellido: %s %n", elemento.getElementsByTagName ("apellido").item(0).getTextContent());

                    System.out.printf("Sexo: %s %n", elemento.getElementsByTagName ("sexo").item(0).getTextContent());

                    System.out.printf("Edad: %s %n", elemento.getElementsByTagName ("edad").item(0).getTextContent());

                    System.out.printf("Suspensos: %s %n", elemento.getElementsByTagName ("suspensos").item(0).getTextContent());

                    System.out.printf("Residencia: %s %n", elemento.getElementsByTagName ("residencia").item(0).getTextContent());

                    System.out.printf("Ingresos: %s %n", elemento.getElementsByTagName ("ingresos").item(0).getTextContent());
                }
            }
        }catch (Exception e) {e.printStackTrace();}
    }
}
