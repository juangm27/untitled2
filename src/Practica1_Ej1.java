import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class Practica1_Ej1 {
    public static void main(String[] args) throws RuntimeException {
        File fichero = new File("datosbeca.bin");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(fichero))){
            Becario b= (Becario) ois.readObject();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "Becarios", null);
            Element raiz= document.createElement("becario");
            document.getDocumentElement().appendChild(raiz);

            CrearElemento("nombre",b.nombre, raiz, document);
            CrearElemento("apellido",b.apellido, raiz, document);
            CrearElemento("sexo",b.sexo, raiz, document);
            CrearElemento("edad", String.valueOf(b.edad), raiz, document);
            CrearElemento("suspensos", String.valueOf(b.edad), raiz, document);
            CrearElemento("residencia",b.residencia, raiz, document);
            CrearElemento("ingresos", String.valueOf(b.ingresosAnuales), raiz, document);
            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File("Becarios.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
        } catch (IOException | ParserConfigurationException | ClassNotFoundException | TransformerException e) {
            throw new RuntimeException(e);
        }
    }
    static void CrearElemento(String datoBeca, String valor, Element raiz, Document document) {
        Element elem = document.createElement(datoBeca);
        Text text = document.createTextNode(valor);
        raiz.appendChild(elem);
        elem.appendChild(text);
    }
}
