package ar.fi.uba.GPSChallenge.Modelo.Mapa;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import ar.fi.uba.GPSChallenge.Modelo.Partida;


@XmlRootElement
@XmlSeeAlso({Partida.class})
public class Nivel {

	protected String rutaALaCarpetaMapas = System.getProperty("user.dir") + System.getProperty("file.separator") + "Mapas" + System.getProperty("file.separator");
	
	protected int movimientosLimite;
	
	protected int multiplicadorDePuntaje;
	
	protected String tipoNivel;
	
	public Mapa pedirUnMapa(){	
		return new Mapa(1,1);
	} 
	
	public Mapa pedirUnMapaParaTest(){
		return new Mapa(1,1);
	}
	
	@XmlElement
	public void setTipoNivel(String tipoNivel){
		this.tipoNivel = tipoNivel;
	}
	
	public String getTipoNivel(){
		return this.tipoNivel;
	}
	
	public int calcularPuntaje(int cantidadDeMovimientos){
		int puntaje;
		puntaje = ((this.movimientosLimite - cantidadDeMovimientos) * multiplicadorDePuntaje);
		if (puntaje <= 0){
			return 0;
		}
		else{
			return puntaje;
		}
	}
}
