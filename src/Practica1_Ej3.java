import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Practica1_Ej3 {
    public static void main(String[] args)
            throws FileNotFoundException, IOException, SAXException, ParserConfigurationException {
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        parserFactory.setNamespaceAware(true);
        GestionContenido gestor = new GestionContenido();
        SAXParser parser = parserFactory.newSAXParser();
        XMLReader reader = parser.getXMLReader();
        reader.setContentHandler(gestor);
        reader.parse(new InputSource("Becarios.xml"));
    }
}

class GestionContenido extends DefaultHandler {
    public GestionContenido(){
        super();
    }
    public void startDocument(){
        System.out.println("Comienzo del Documento XML");
    }
    public void endDocument(){
        System.out.println("Final del Documento XML");
    }
    public void startElement(String uri, String nombre, String nombreC, Attributes atts) {
        System.out.printf("\tPrincipio Elemento: %s %n",nombre);
    }
    public void endElement(String uri, String nombre, String nombreC) {
        System.out.printf("\tFin Elemento: %s %n", nombre);
    }
    public void characters(char[] ch, int inicio, int longitud) throws SAXException {
        String car = new String(ch, inicio, longitud);
        //quitar saltos de línea
        car = car.replaceAll("[\n]", "");
        System.out.printf("\t Contenido: %s %n", car);
    }
}

