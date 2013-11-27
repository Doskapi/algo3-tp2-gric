package ar.fi.uba.GPSChallenge.Persistencia;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import ar.fi.uba.GPSChallenge.Modelo.*;

public class DespersistidorCuadra {
	
	private static String XML_CUADRA = System.getProperty("user.home") + System.getProperty("file.separator") + "Cuadra.xml";
	
	public Cuadra despersistirCuadra(){
		Cuadra cuadra = new Cuadra();
		try{
			JAXBContext context = JAXBContext.newInstance(Posicion.class);
			Unmarshaller m = context.createUnmarshaller();
			File XMLfile = new File(XML_CUADRA);
			cuadra = (Cuadra) m.unmarshal(XMLfile);
			ArrayList<Imprevisto> listaImprevistosACastear = new ArrayList<Imprevisto>();
			listaImprevistosACastear = cuadra.getImprevistos();
			ArrayList<Imprevisto> listaImprevistosCasteados = new ArrayList<Imprevisto>();
			Iterator<Imprevisto> iteradorDeImprevistos = listaImprevistosACastear.iterator();
			while (iteradorDeImprevistos.hasNext()){
				Imprevisto imprevisto = (Imprevisto)iteradorDeImprevistos.next();
				String tipoDeImprevisto = imprevisto.getTipoDeImprevisto();
				switch (tipoDeImprevisto){
					case "ObstaculoPozos":
						listaImprevistosCasteados.add(new ObstaculoPozos());
						break;
					case "ObstaculoPolicial":
						listaImprevistosCasteados.add(new ObstaculoPolicial());
						break;
					case "ObstaculoPiquete":
						listaImprevistosCasteados.add(new ObstaculoPiquete());
						break;
					case "SorpresaFavorable":
						listaImprevistosCasteados.add(new SorpresaFavorable());
						break;
					case "SorpresaDesfavorable":
						listaImprevistosCasteados.add(new SorpresaDesfavorable());
						break;
					case "SorpresaCambioDeVehiculo":
						listaImprevistosCasteados.add(new SorpresaCambioDeVehiculo());
						break;
				}
			}
			cuadra.setImprevistos(listaImprevistosCasteados);
		}
		catch(JAXBException e){
			e.printStackTrace();
		}
		return cuadra;
	}
}