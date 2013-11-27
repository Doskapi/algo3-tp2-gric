package ar.fi.uba.GPSChallenge.Persistencia;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import ar.fi.uba.GPSChallenge.Modelo.*;

public class PersistidorCuadra {
	
	private static String XML_CUADRA = System.getProperty("user.home") + System.getProperty("file.separator") + "Cuadra.xml";
	
	public void persistirCuadra(){	
		Esquina esquinaInicial = new Esquina(new Posicion(1,3));
		Esquina esquinaFinal = new Esquina(new Posicion(1,4));
		Cuadra cuadra = new Cuadra(esquinaInicial, esquinaFinal);
		cuadra.agregarImprevisto(new ObstaculoPolicial());
		cuadra.agregarImprevisto(new SorpresaFavorable());
		try{
			JAXBContext context = JAXBContext.newInstance(Posicion.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			File XMLfile = new File(XML_CUADRA);
			m.marshal(cuadra, XMLfile);
			m.marshal(cuadra, System.out);
		}
		catch(JAXBException e){
			e.printStackTrace();
		}
	}
}
