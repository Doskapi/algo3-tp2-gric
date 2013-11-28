package ar.fi.uba.GPSChallenge.Persistencia;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import ar.fi.uba.GPSChallenge.Modelo.*;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Dificil;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Facil;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Mapa;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Moderado;

public class DespersistidorPartida {

	public Partida despersistirPartida(String rutaDelArchivo){
		Partida partidaDespersistida = new Partida();
		try{
			JAXBContext context = JAXBContext.newInstance(Partida.class);
			Unmarshaller m = context.createUnmarshaller();
			File XMLfile = new File(rutaDelArchivo);
			partidaDespersistida = (Partida) m.unmarshal(XMLfile);
			String rutaMapa = partidaDespersistida.getRutaMapa();
			DespersistidorMapa despersistidorMapa = new DespersistidorMapa();
			Mapa mapa = despersistidorMapa.despersistirMapa(rutaMapa);
			partidaDespersistida.setMapa(mapa);
			String tipoNivel = partidaDespersistida.getNivel().getTipoNivel();
			switch(tipoNivel){
			case ("Facil"):
				partidaDespersistida.setNivel(new Facil());
				break;
				
			case ("Moderado"):
				partidaDespersistida.setNivel(new Moderado());
				break;
				
			case ("Dificil"):
				partidaDespersistida.setNivel(new Dificil());
				break;
			}
			
		}
		catch(JAXBException e){
			e.printStackTrace();
		}
		return partidaDespersistida;
	}
}