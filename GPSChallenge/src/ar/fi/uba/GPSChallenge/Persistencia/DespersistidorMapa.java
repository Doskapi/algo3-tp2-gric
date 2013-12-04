package ar.fi.uba.GPSChallenge.Persistencia;

import java.io.File;
import java.util.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import ar.fi.uba.GPSChallenge.Modelo.Imprevistos.Imprevisto;
import ar.fi.uba.GPSChallenge.Modelo.Imprevistos.ObstaculoPiquete;
import ar.fi.uba.GPSChallenge.Modelo.Imprevistos.ObstaculoPolicial;
import ar.fi.uba.GPSChallenge.Modelo.Imprevistos.ObstaculoPozos;
import ar.fi.uba.GPSChallenge.Modelo.Imprevistos.SorpresaCambioDeVehiculo;
import ar.fi.uba.GPSChallenge.Modelo.Imprevistos.SorpresaDesfavorable;
import ar.fi.uba.GPSChallenge.Modelo.Imprevistos.SorpresaFavorable;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Cuadra;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Mapa;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Posicion;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Auto;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.CuatroPorCuatro;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Moto;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Vehiculo;

public class DespersistidorMapa {
	
	public Mapa despersistirMapa(String rutaDeArchivo){
		Mapa mapa = new Mapa();
		try{
			JAXBContext context = JAXBContext.newInstance(Posicion.class);
			Unmarshaller m = context.createUnmarshaller();
			File XMLfile = new File(rutaDeArchivo);
			mapa = (Mapa) m.unmarshal(XMLfile);
			Vehiculo vehiculo = mapa.getVehiculo();
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
			mapa.setVehiculo(vehiculo);
			List<Cuadra> cuadras = new ArrayList<Cuadra>();
			List<Cuadra> cuadrasCasteadas = new ArrayList<Cuadra>();
			cuadras = mapa.getCuadras();
			Iterator<Cuadra> iteradorCuadras = cuadras.iterator();
			while(iteradorCuadras.hasNext()){
				Cuadra cuadraActual = iteradorCuadras.next();
				List<Imprevisto> imprevistos = new ArrayList<Imprevisto>();
				imprevistos = cuadraActual.getImprevistos();
				ArrayList<Imprevisto> imprevistosCasteados = new ArrayList<Imprevisto>();
				Iterator<Imprevisto> iteradorImprevistos = imprevistos.iterator();
				while(iteradorImprevistos.hasNext()){
					String tipoImprevisto = iteradorImprevistos.next().getTipoDeImprevisto();
					switch(tipoImprevisto){
					case("SorpresaFavorable"):
						imprevistosCasteados.add(new SorpresaFavorable());
						break;
					case("SorpresaCambioDeVehiculo"):
						imprevistosCasteados.add(new SorpresaCambioDeVehiculo());
						break;
					case("SorpresaDesfavorable"):
						imprevistosCasteados.add(new SorpresaDesfavorable());
						break;
					case("ObstaculoPozos"):
						imprevistosCasteados.add(new ObstaculoPozos());
						break;
					case("ObstaculoPiquete"):
						imprevistosCasteados.add(new ObstaculoPiquete());
						break;
					case("ObstaculoPolicial"):
						imprevistosCasteados.add(new ObstaculoPolicial());
						break;	
					}
					cuadraActual.setImprevistos(imprevistosCasteados);
				}
				cuadrasCasteadas.add(cuadraActual);
			}
			mapa.setCuadras(cuadrasCasteadas);
		}
		catch(JAXBException e){
			e.printStackTrace();
		}
		return mapa;
	}
}