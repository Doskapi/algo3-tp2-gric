package ar.fi.uba.GPSChallenge.Persistencia;

import java.io.File;
import java.util.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import ar.fi.uba.GPSChallenge.Modelo.*;
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
			List<Cuadra> listaCuadras = new ArrayList<Cuadra>();
			List<Cuadra> listaCuadrasCasteadas = new ArrayList<Cuadra>();
			listaCuadras = mapa.getCuadras();
			Cuadra cuadraActual;
			ArrayList<Imprevisto> listaImprevistos = new ArrayList<Imprevisto>();
			ArrayList<Imprevisto> listaImprevistosCasteados = new ArrayList<Imprevisto>();
			Iterator<Cuadra> iteradorCuadras = listaCuadras.iterator();
			while (iteradorCuadras.hasNext()){
				cuadraActual = iteradorCuadras.next();
				listaImprevistos = cuadraActual.getImprevistos();
				Iterator<Imprevisto> iteradorImprevistos = listaImprevistos.iterator();
				while (iteradorImprevistos.hasNext()){
					Imprevisto imprevisto = (Imprevisto)iteradorImprevistos.next();
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
					cuadraActual.setImprevistos(listaImprevistosCasteados);
				}
				listaCuadrasCasteadas.add(cuadraActual);				
			}
			mapa.setCuadras(listaCuadrasCasteadas);
		}
		catch(JAXBException e){
			e.printStackTrace();
		}
		return mapa;
	}
}