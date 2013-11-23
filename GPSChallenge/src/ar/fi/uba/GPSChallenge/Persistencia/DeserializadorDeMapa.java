package ar.fi.uba.GPSChallenge.Persistencia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.soap.Node;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import ar.fi.uba.GPSChallenge.Modelo.*;

public class DeserializadorDeMapa {

	public Mapa deserializarMapa(Element element) {
		Mapa mapa = new Mapa();
		NodeList nodoMapa = element.getChildNodes();
		Node nodoFilas = (Node)nodoMapa.item(0);
		mapa.setFilas(Integer.parseInt(nodoFilas.getTextContent()));
		Node nodoColumnas = (Node)nodoMapa.item(1);
		mapa.setColumnas(Integer.parseInt(nodoColumnas.getTextContent()));
		Node nodoCuadras = (Node)nodoMapa.item(2);
		NodeList listaCuadras = nodoCuadras.getChildNodes();
		for (int i = 0; i<listaCuadras.getLength();i++){
			Cuadra cuadra = new Cuadra();
			NodeList nodoCuadra = (NodeList)listaCuadras.item(i);
			cuadra = this.deserializarCuadra(nodoCuadra);
			mapa.agregarCuadra(cuadra);
			
		}
		mapa.setLargada();
		mapa.setMeta();
		return mapa;
		}

	private Cuadra deserializarCuadra(NodeList nodoCuadra) {
		
		NodeList nodoEsquinaInicial = (NodeList)nodoCuadra.item(0);
		Esquina esquinaInicial = new Esquina();
		esquinaInicial = this.deserializarEsquina(nodoEsquinaInicial);
		NodeList nodoEsquinaFinal = (NodeList)nodoCuadra.item(1);
		Esquina esquinaFinal = new Esquina();
		esquinaFinal = this.deserializarEsquina(nodoEsquinaFinal);
		NodeList nodoImprevistos = (NodeList)nodoCuadra.item(2);
		List<Imprevisto> listaImprevistos = new ArrayList<Imprevisto>();
		listaImprevistos = this.deserializarImprevistos(nodoImprevistos);
		Cuadra cuadra = new Cuadra(esquinaInicial,esquinaFinal);
		Iterator<Imprevisto> iteradorImprevistos = listaImprevistos.iterator();
		while (iteradorImprevistos.hasNext()){
			Imprevisto unImprevisto = (Imprevisto)iteradorImprevistos.next();
			cuadra.agregarImprevisto(unImprevisto);
		}
		return cuadra;
		
	}

	private List<Imprevisto> deserializarImprevistos(NodeList nodoImprevistos) {
		
		List<Imprevisto> listaImprevistos = new ArrayList<Imprevisto>();
		for(int i = 0; i<nodoImprevistos.getLength(); i++){
			Node nodoImprevisto = (Node)nodoImprevistos.item(i);
			String tipoDeImprevisto = nodoImprevisto.getNodeName();
			switch (tipoDeImprevisto){
				case "ObstaculoPozos": 
					ObstaculoPozos obstaculoPozos = new ObstaculoPozos();
					listaImprevistos.add(obstaculoPozos);
				    break;
				case "ObstaculoPolicial": 
					ObstaculoPolicial obstaculoPolicial = new ObstaculoPolicial();
					listaImprevistos.add(obstaculoPolicial);
				    break;
				case "ObstaculoPiquete": 
					ObstaculoPiquete obstaculoPiquete = new ObstaculoPiquete();
					listaImprevistos.add(obstaculoPiquete);
				    break;
				case "SopresaFavorable":
					SorpresaFavorable sorpresaFavorable = new SorpresaFavorable();
					listaImprevistos.add(sorpresaFavorable);
					break;
				case "SopresaDesfavorable":
					SorpresaDesfavorable sorpresaDesfavorable = new SorpresaDesfavorable();
					listaImprevistos.add(sorpresaDesfavorable);
					break;
				case "SorpresaCambioDeVehiculo":
					SorpresaCambioDeVehiculo sorpresaCambioDeVehiculo = new SorpresaCambioDeVehiculo();
					listaImprevistos.add(sorpresaCambioDeVehiculo);
					break;
			}
		}
		return listaImprevistos;
	}

	private Esquina deserializarEsquina(NodeList nodoEsquina) {
		NodeList nodoPosicion = (NodeList)nodoEsquina.item(0);
		Posicion posicion = this.deserializarPosicion(nodoPosicion);
		Esquina esquina = new Esquina(posicion);
		return esquina;
		
		
	}

	private Posicion deserializarPosicion(NodeList nodoPosicion) {
		Node nodoFila = (Node)nodoPosicion.item(0);
		Node nodoColumna = (Node)nodoPosicion.item(1);
		Posicion posicion = new Posicion();
		posicion.setFila(Integer.parseInt(nodoFila.getTextContent()));
		posicion.setColumna(Integer.parseInt(nodoColumna.getTextContent()));
		return posicion;
	}

}
