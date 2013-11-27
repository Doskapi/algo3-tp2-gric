package ar.fi.uba.GPSChallenge.Persistencia;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import ar.fi.uba.GPSChallenge.Modelo.*;

public class DespersistidorVehiculo {
private static String XML_VEHICULO = System.getProperty("user.home") + System.getProperty("file.separator") + "Vehiculo.xml";
	
	public Vehiculo despersistirVehiculo(){
		Vehiculo vehiculo = new Vehiculo();
		try{
			JAXBContext context = JAXBContext.newInstance(Posicion.class);
			Unmarshaller m = context.createUnmarshaller();
			File XMLfile = new File(XML_VEHICULO);
			vehiculo = (Vehiculo) m.unmarshal(XMLfile);
			String tipoEstado = vehiculo.getEstado().getTipoEstado();
			switch (tipoEstado){
				case "Auto":
					vehiculo.setEstado(new Auto());
					break;
				case "Moto":
					vehiculo.setEstado(new Moto());
					break;
				case "CuatroPorCuatro":
					vehiculo.setEstado(new CuatroPorCuatro());
					break;
			}
		}
		catch(JAXBException e){
			e.printStackTrace();
		}
		return vehiculo;
	}
}