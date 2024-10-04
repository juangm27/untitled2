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
            DOMImplementation implementacion = builder.getDOMImplementation();
            Document documento = implementacion.createDocument(null, "Becarios", null);
            Element raiz= documento.createElement("becario");
            documento.getDocumentElement().appendChild(raiz);

            CrearElemento("nombre",b.nombre, raiz, documento);
            CrearElemento("apellido",b.apellido, raiz, documento);
            CrearElemento("sexo",b.sexo, raiz, documento);
            CrearElemento("edad", String.valueOf(b.edad), raiz, documento);
            CrearElemento("suspensos", String.valueOf(b.edad), raiz, documento);
            CrearElemento("residencia",b.residencia, raiz, documento);
            CrearElemento("ingresos", String.valueOf(b.ingresosAnuales), raiz, documento);

            Source s = new DOMSource(documento);
            Result r = new StreamResult(new java.io.File("Becarios.xml"));
            Transformer t = TransformerFactory.newInstance().newTransformer();
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            t.transform(s, r);
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
