package ar.fi.uba.GPSChallengeTests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import ar.fi.uba.GPSChallenge.Modelo.*;
import ar.fi.uba.GPSChallenge.Persistencia.*;
import junit.framework.TestCase;
import org.junit.Test;

public class DeserializadorMapaTests extends TestCase {
	
	@Test
	public void testCreoUnDeserializador(){
		DeserializadorDeMapa deserializador = new DeserializadorDeMapa();
		assertNotNull (deserializador);
	}
	
	@Test
	public void testUnDeserializadorDeserializaUnMapa(){
		String archivo = "/home/nacho/workspace/GPSChallenge/src/ar/fi/uba/GPSChallenge/Persistencia/";
		DeserializadorDeMapa deserializador = new DeserializadorDeMapa();
		try {
				Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(archivo));
				Element element = doc.getDocumentElement();
				Mapa mapa = deserializador.deserializarMapa(element);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
}
