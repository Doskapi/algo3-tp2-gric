package ar.fi.uba.GPSChallengeTests.Vehiculo;

import junit.framework.TestCase;

import org.junit.Test;

import ar.fi.uba.GPSChallenge.Modelo.Imprevistos.ObstaculoPiquete;
import ar.fi.uba.GPSChallenge.Modelo.Imprevistos.ObstaculoPolicial;
import ar.fi.uba.GPSChallenge.Modelo.Imprevistos.ObstaculoPozos;
import ar.fi.uba.GPSChallenge.Modelo.Imprevistos.SorpresaDesfavorable;
import ar.fi.uba.GPSChallenge.Modelo.Imprevistos.SorpresaFavorable;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Cuadra;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Esquina;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Mapa;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Posicion;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Auto;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.CuatroPorCuatro;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Este;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Moto;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Norte;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Oeste;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Sur;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Vehiculo;

public class VehiculoTest extends TestCase {

	@Test
	public void testCrearCuatroPorCuatro(){
		CuatroPorCuatro cuatroPorCuatro = new CuatroPorCuatro();
		Vehiculo vehiculo = new Vehiculo(cuatroPorCuatro);
		assertEquals(vehiculo.getEstado(),cuatroPorCuatro);
	}
	
	@Test
	public void testCrearAuto(){
		Auto auto = new Auto();
		Vehiculo vehiculo = new Vehiculo(auto);
		assertEquals(vehiculo.getEstado(),auto);
	}
	
	@Test
	public void testCrearMoto(){
		Moto moto = new Moto();
		Vehiculo vehiculo = new Vehiculo(moto);
		assertEquals(vehiculo.getEstado(),moto);
	}
	
	@Test
	public void testGetCantidadDeMovimientos(){
		
		Vehiculo vehiculo = new Vehiculo(new Moto());
		assertEquals(vehiculo.getCantidadDeMovimientos(),0);
	}
	
	@Test
	public void testSetCantidadDeMovimientos(){
		Vehiculo vehiculo = new Vehiculo(new Moto());
		vehiculo.setCantidadDeMovimientos(8);
		assertEquals(vehiculo.getCantidadDeMovimientos(), 8);
	}
	
	@Test
	public void testCrearAutoYLoColocoEnUnaEsquina(){
		Auto auto = new Auto();
		Vehiculo vehiculo = new Vehiculo(auto);
		assertEquals(vehiculo.getEstado(),auto);
		Esquina esquina = new Esquina(new Posicion(1,2));
		vehiculo.colocarEnEsquina(esquina);
		assertEquals(vehiculo.getEsquina(), esquina);
	}
	
	@Test
	public void testCrearAutoEnUnaEsquinaYSeMueveAlNorte(){
		Auto auto = new Auto();
		Vehiculo vehiculo = new Vehiculo(auto);
		assertEquals(vehiculo.getEstado(),auto);
		Esquina esquinaInicial = new Esquina(new Posicion(2,2));
		Esquina esquinaFinal = new Esquina(new Posicion(1,2));
		vehiculo.colocarEnEsquina(esquinaInicial);
		assertEquals(vehiculo.getEsquina(), esquinaInicial);
		vehiculo.mover(new Norte());
		assertEquals(vehiculo.getEsquina(), esquinaFinal);
	}
	
	@Test
	public void testCrearAutoEnUnaEsquinaYSeMueveAlSur(){
		Auto auto = new Auto();
		Vehiculo vehiculo = new Vehiculo(auto);
		assertEquals(vehiculo.getEstado(),auto);
		Esquina esquinaInicial = new Esquina(new Posicion(2,2));
		Esquina esquinaFinal = new Esquina(new Posicion(3,2));
		vehiculo.colocarEnEsquina(esquinaInicial);
		assertEquals(vehiculo.getEsquina(), esquinaInicial);
		vehiculo.mover(new Sur());
		assertEquals(vehiculo.getEsquina(), esquinaFinal);
	}
	
	@Test
	public void testCrearAutoEnUnaEsquinaYSeMueveAlEste(){
		Auto auto = new Auto();
		Vehiculo vehiculo = new Vehiculo(auto);
		assertEquals(vehiculo.getEstado(),auto);
		Esquina esquinaInicial = new Esquina(new Posicion(2,2));
		Esquina esquinaFinal = new Esquina(new Posicion(2,3));
		vehiculo.colocarEnEsquina(esquinaInicial);
		assertEquals(vehiculo.getEsquina(), esquinaInicial);
		vehiculo.mover(new Este());
		assertEquals(vehiculo.getEsquina(), esquinaFinal);
	}
	
	@Test
	public void testCrearAutoEnUnaEsquinaYSeMueveAlOeste(){
		Auto auto = new Auto();
		Vehiculo vehiculo = new Vehiculo(auto);
		assertEquals(vehiculo.getEstado(),auto);
		Esquina esquinaInicial = new Esquina(new Posicion(2,2));
		Esquina esquinaFinal = new Esquina(new Posicion(2,1));
		vehiculo.colocarEnEsquina(esquinaInicial);
		assertEquals(vehiculo.getEsquina(), esquinaInicial);
		vehiculo.mover(new Oeste());
		assertEquals(vehiculo.getEsquina(), esquinaFinal);
	}
	
	@Test
	public void testCrearAutoEnUnaEsquinaYAumentaSuCantidadDeMovimientosAlMoverse(){
		Auto auto = new Auto();
		Vehiculo vehiculo = new Vehiculo(auto);
		assertEquals(vehiculo.getEstado(),auto);
		vehiculo.setCantidadDeMovimientos(0);
		assertEquals(vehiculo.getCantidadDeMovimientos(), 0);
		Esquina esquinaInicial = new Esquina(new Posicion(2,2));
		Esquina esquinaFinal = new Esquina(new Posicion(2,1));
		vehiculo.colocarEnEsquina(esquinaInicial);
		assertEquals(vehiculo.getEsquina(), esquinaInicial);
		vehiculo.mover(new Oeste());
		assertEquals(vehiculo.getEsquina(), esquinaFinal);
		assertEquals(vehiculo.getCantidadDeMovimientos(), 1);
	}
	
	@Test
	public void testUnVehículoMotoCambiaDeEstadoAAuto(){
		Moto moto = new Moto();
		Auto auto = new Auto();
		Vehiculo vehiculo = new Vehiculo(moto);
		assertEquals(vehiculo.getEstado(), moto);
		vehiculo.setEstado(auto);
		assertEquals(vehiculo.getEstado(), auto);
	}
	
	@Test
	public void testUnVehiculoAgararPozos(){
		Moto moto = new Moto();
		Vehiculo vehiculo = new Vehiculo(moto);
		assertEquals(vehiculo.getCantidadDeMovimientos(), 0);
		vehiculo.agarrarPozos();
		assertEquals(vehiculo.getCantidadDeMovimientos(), 3);
	}
	
	@Test
	public void testUnVehiculoAutoAgarraUnaSorpresaFavorable() throws Exception{
		Auto auto = new Auto();
		Vehiculo vehiculo = new Vehiculo(auto);
		vehiculo.setCantidadDeMovimientos(10);
		assertEquals(vehiculo.getCantidadDeMovimientos(), 10);
		Mapa mapa = new Mapa(10,10);
		mapa.setEsquinaLargada(new Esquina(new Posicion(2,1)));
		mapa.agregarVehiculo(vehiculo);
		Cuadra cuadra = new Cuadra(new Esquina(new Posicion(2,2)), new Esquina(new Posicion(2,3)));
		SorpresaFavorable sorpresa = new SorpresaFavorable();
		cuadra.agregarImprevisto(sorpresa);
		mapa.agregarCuadra(cuadra);
		mapa.moverVehiculo(new Este());
		assertEquals(vehiculo.getEsquina(), new Esquina(new Posicion(2,2)));
		mapa.moverVehiculo(new Este());
		assertEquals(vehiculo.getEsquina(), new Esquina(new Posicion(2,3)));
		mapa.moverVehiculo(new Este());
		assertEquals(vehiculo.getEsquina(), new Esquina(new Posicion(2,4)));
	}
	
	@Test
	public void testUnVehiculoCuatroPorCuatroAgarraUnaSorpresaFavorable() throws Exception{
		CuatroPorCuatro cuatroPorCuatro = new CuatroPorCuatro();
		Vehiculo vehiculo = new Vehiculo(cuatroPorCuatro);
		vehiculo.setCantidadDeMovimientos(10);
		assertEquals(vehiculo.getCantidadDeMovimientos(), 10);
		Mapa mapa = new Mapa(10,10);
		mapa.setEsquinaLargada(new Esquina(new Posicion(2,1)));
		mapa.agregarVehiculo(vehiculo);
		Cuadra cuadra = new Cuadra(new Esquina(new Posicion(2,2)), new Esquina(new Posicion(2,3)));
		SorpresaFavorable sorpresa = new SorpresaFavorable();
		cuadra.agregarImprevisto(sorpresa);
		mapa.agregarCuadra(cuadra);
		mapa.moverVehiculo(new Este());
		assertEquals(vehiculo.getEsquina(), new Esquina(new Posicion(2,2)));
		mapa.moverVehiculo(new Este());
		assertEquals(vehiculo.getEsquina(), new Esquina(new Posicion(2,3)));
		mapa.moverVehiculo(new Este());
		assertEquals(vehiculo.getEsquina(), new Esquina(new Posicion(2,4)));
	}
	
	@Test
	public void testUnVehiculoMotoAgarraUnaSorpresaFavorable() throws Exception{
		Moto moto = new Moto();
		Vehiculo vehiculo = new Vehiculo(moto);
		vehiculo.setCantidadDeMovimientos(10);
		assertEquals(vehiculo.getCantidadDeMovimientos(), 10);
		Mapa mapa = new Mapa(10,10);
		mapa.setEsquinaLargada(new Esquina(new Posicion(2,1)));
		mapa.agregarVehiculo(vehiculo);
		Cuadra cuadra = new Cuadra(new Esquina(new Posicion(2,2)), new Esquina(new Posicion(2,3)));
		SorpresaFavorable sorpresa = new SorpresaFavorable();
		cuadra.agregarImprevisto(sorpresa);
		mapa.agregarCuadra(cuadra);
		mapa.moverVehiculo(new Este());
		assertEquals(vehiculo.getEsquina(), new Esquina(new Posicion(2,2)));
		mapa.moverVehiculo(new Este());
		assertEquals(vehiculo.getEsquina(), new Esquina(new Posicion(2,3)));
		mapa.moverVehiculo(new Este());
		assertEquals(vehiculo.getEsquina(), new Esquina(new Posicion(2,4)));
	}
	
	@Test
	public void testUnVehiculoAutoAgarraUnaSorpresaDesFavorable() throws Exception{
		Auto auto = new Auto();
		Vehiculo vehiculo = new Vehiculo(auto);
		vehiculo.setCantidadDeMovimientos(10);
		assertEquals(vehiculo.getCantidadDeMovimientos(), 10);
		Mapa mapa = new Mapa(10,10);
		mapa.setEsquinaLargada(new Esquina(new Posicion(2,1)));
		mapa.agregarVehiculo(vehiculo);
		Cuadra cuadra = new Cuadra(new Esquina(new Posicion(2,2)), new Esquina(new Posicion(2,3)));
		SorpresaDesfavorable sorpresa = new SorpresaDesfavorable();
		cuadra.agregarImprevisto(sorpresa);
		mapa.agregarCuadra(cuadra);
		mapa.moverVehiculo(new Este());
		assertEquals(vehiculo.getEsquina(), new Esquina(new Posicion(2,2)));
		mapa.moverVehiculo(new Este());
		assertEquals(vehiculo.getEsquina(), new Esquina(new Posicion(2,3)));
		mapa.moverVehiculo(new Este());
		assertEquals(vehiculo.getEsquina(), new Esquina(new Posicion(2,4)));
	}
	
	@Test
	public void testUnVehiculoAutoNoPuedePasarUnPiquete() throws Exception{
		Auto auto = new Auto();
		Vehiculo vehiculo = new Vehiculo(auto);
		Mapa mapa = new Mapa(10,10);
		mapa.setEsquinaLargada(new Esquina(new Posicion(2,1)));
		mapa.agregarVehiculo(vehiculo);
		Cuadra cuadra = new Cuadra(new Esquina(new Posicion(2,2)), new Esquina(new Posicion(2,3)));
		ObstaculoPiquete piquete = new ObstaculoPiquete();
		cuadra.agregarImprevisto(piquete);
		mapa.agregarCuadra(cuadra);
		mapa.moverVehiculo(new Este());
		mapa.moverVehiculo(new Este());
		assertEquals(mapa.getVehiculo().getEsquina(), new Esquina(new Posicion(2,2)));
	}
	
	@Test
	public void testUnVehiculoCuatroPorCuatroNoPuedePasarUnPiquete() throws Exception{
		CuatroPorCuatro cuatroPorCuatro = new CuatroPorCuatro();
		Vehiculo vehiculo = new Vehiculo(cuatroPorCuatro);
		Mapa mapa = new Mapa(10,10);
		mapa.setEsquinaLargada(new Esquina(new Posicion(2,1)));
		mapa.agregarVehiculo(vehiculo);
		Cuadra cuadra = new Cuadra(new Esquina(new Posicion(2,2)), new Esquina(new Posicion(2,3)));
		ObstaculoPiquete piquete = new ObstaculoPiquete();
		cuadra.agregarImprevisto(piquete);
		mapa.agregarCuadra(cuadra);
		mapa.moverVehiculo(new Este());
		mapa.moverVehiculo(new Este());
		assertEquals(mapa.getVehiculo().getEsquina(), new Esquina(new Posicion(2,2)));
	}
	
	@Test
	public void testUnVehiculoMotoPuedePasarUnPiquete() throws Exception{
		Moto moto = new Moto();
		Vehiculo vehiculo = new Vehiculo(moto);
		Mapa mapa = new Mapa(10,10);
		mapa.setEsquinaLargada(new Esquina(new Posicion(2,1)));
		mapa.agregarVehiculo(vehiculo);
		Cuadra cuadra = new Cuadra(new Esquina(new Posicion(2,2)), new Esquina(new Posicion(2,3)));
		ObstaculoPiquete piquete = new ObstaculoPiquete();
		cuadra.agregarImprevisto(piquete);
		mapa.agregarCuadra(cuadra);
		mapa.moverVehiculo(new Este());
		mapa.moverVehiculo(new Este());
		assertEquals(mapa.getVehiculo().getEsquina(), new Esquina(new Posicion(2,3)));
	}
	
	@Test
	public void testUnVehiculoAutoPuedePasarUnObstaculoPolicial() throws Exception{
		Auto auto = new Auto();
		Vehiculo vehiculo = new Vehiculo(auto);
		Mapa mapa = new Mapa(10,10);
		mapa.setEsquinaLargada(new Esquina(new Posicion(2,1)));
		mapa.agregarVehiculo(vehiculo);
		Cuadra cuadra = new Cuadra(new Esquina(new Posicion(2,2)), new Esquina(new Posicion(2,3)));
		ObstaculoPolicial policia = new ObstaculoPolicial();
		cuadra.agregarImprevisto(policia);
		mapa.agregarCuadra(cuadra);
		mapa.moverVehiculo(new Este());
		mapa.moverVehiculo(new Este());
		assertEquals(mapa.getVehiculo().getEsquina(), new Esquina(new Posicion(2,3)));
	}
	
	@Test
	public void testUnVehiculoCuatroPorCuatroPuedePasarUnObstaculoPolicial() throws Exception{
		CuatroPorCuatro cuatroPorCuatro = new CuatroPorCuatro();
		Vehiculo vehiculo = new Vehiculo(cuatroPorCuatro);
		Mapa mapa = new Mapa(10,10);
		mapa.setEsquinaLargada(new Esquina(new Posicion(2,1)));
		mapa.agregarVehiculo(vehiculo);
		Cuadra cuadra = new Cuadra(new Esquina(new Posicion(2,2)), new Esquina(new Posicion(2,3)));
		ObstaculoPolicial policia = new ObstaculoPolicial();
		cuadra.agregarImprevisto(policia);
		mapa.agregarCuadra(cuadra);
		mapa.moverVehiculo(new Este());
		mapa.moverVehiculo(new Este());
		assertEquals(mapa.getVehiculo().getEsquina(), new Esquina(new Posicion(2,3)));
	}
	
	@Test
	public void testUnVehiculoMotoPuedePasarUnObstaculoPolicial() throws Exception{
		Moto moto = new Moto();
		Vehiculo vehiculo = new Vehiculo(moto);
		Mapa mapa = new Mapa(10,10);
		mapa.setEsquinaLargada(new Esquina(new Posicion(2,1)));
		mapa.agregarVehiculo(vehiculo);
		Cuadra cuadra = new Cuadra(new Esquina(new Posicion(2,2)), new Esquina(new Posicion(2,3)));
		ObstaculoPolicial policia = new ObstaculoPolicial();
		cuadra.agregarImprevisto(policia);
		mapa.agregarCuadra(cuadra);
		mapa.moverVehiculo(new Este());
		mapa.moverVehiculo(new Este());
		assertEquals(mapa.getVehiculo().getEsquina(), new Esquina(new Posicion(2,3)));
	}
	
	@Test
	public void testUnVehiculoAutoPuedePasarUnObstaculoPozos() throws Exception{
		Auto auto = new Auto();
		Vehiculo vehiculo = new Vehiculo(auto);
		Mapa mapa = new Mapa(10,10);
		mapa.setEsquinaLargada(new Esquina(new Posicion(2,1)));
		mapa.agregarVehiculo(vehiculo);
		Cuadra cuadra = new Cuadra(new Esquina(new Posicion(2,2)), new Esquina(new Posicion(2,3)));
		ObstaculoPozos pozo = new ObstaculoPozos();
		cuadra.agregarImprevisto(pozo);
		mapa.agregarCuadra(cuadra);
		mapa.moverVehiculo(new Este());
		mapa.moverVehiculo(new Este());
		assertEquals(mapa.getVehiculo().getEsquina(), new Esquina(new Posicion(2,3)));
	}
	
	@Test
	public void testUnVehiculoCuatroPorCuatroPuedePasarUnObstaculoPozos() throws Exception{
		CuatroPorCuatro cuatroPorCuatro = new CuatroPorCuatro();
		Vehiculo vehiculo = new Vehiculo(cuatroPorCuatro);
		Mapa mapa = new Mapa(10,10);
		mapa.setEsquinaLargada(new Esquina(new Posicion(2,1)));
		mapa.agregarVehiculo(vehiculo);
		Cuadra cuadra = new Cuadra(new Esquina(new Posicion(2,2)), new Esquina(new Posicion(2,3)));
		ObstaculoPozos pozo = new ObstaculoPozos();
		cuadra.agregarImprevisto(pozo);
		mapa.agregarCuadra(cuadra);
		mapa.moverVehiculo(new Este());
		mapa.moverVehiculo(new Este());
		assertEquals(mapa.getVehiculo().getEsquina(), new Esquina(new Posicion(2,3)));
	}
	
	@Test
	public void testUnVehiculoMotoPuedePasarUnObstaculoPozos() throws Exception{
		Moto moto = new Moto();
		Vehiculo vehiculo = new Vehiculo(moto);
		Mapa mapa = new Mapa(10,10);
		mapa.setEsquinaLargada(new Esquina(new Posicion(2,1)));
		mapa.agregarVehiculo(vehiculo);
		Cuadra cuadra = new Cuadra(new Esquina(new Posicion(2,2)), new Esquina(new Posicion(2,3)));
		ObstaculoPozos pozo = new ObstaculoPozos();
		cuadra.agregarImprevisto(pozo);
		mapa.agregarCuadra(cuadra);
		mapa.moverVehiculo(new Este());
		mapa.moverVehiculo(new Este());
		assertEquals(mapa.getVehiculo().getEsquina(), new Esquina(new Posicion(2,3)));
	}
}


	
