package ar.fi.uba.GPSChallenge.Persistencia;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Posicion;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Auto;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.CuatroPorCuatro;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Moto;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Vehiculo;

public class DespersistidorVehiculo {
	
	public Vehiculo despersistirVehiculo(String rutaDelArchivo){
		Vehiculo vehiculo = new Vehiculo();
		try{
			JAXBContext context = JAXBContext.newInstance(Posicion.class);
			Unmarshaller m = context.createUnmarshaller();
			File XMLfile = new File(rutaDelArchivo);
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