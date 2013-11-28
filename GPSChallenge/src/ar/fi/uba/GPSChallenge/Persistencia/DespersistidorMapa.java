package ar.fi.uba.GPSChallenge.Persistencia;

import java.io.File;
import java.util.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import ar.fi.uba.GPSChallenge.Modelo.*;

public class DespersistidorMapa {
	
	public Mapa despersistirMapa(String rutaDeArchivo){
		Mapa mapa = new Mapa();
		try{
			JAXBContext context = JAXBContext.newInstance(Mapa.class);
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
			
			
			
			
//			Imprevisto imprevistoActual;
			
			
			
			
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