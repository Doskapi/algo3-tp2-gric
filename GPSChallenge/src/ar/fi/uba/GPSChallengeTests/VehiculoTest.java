package ar.fi.uba.GPSChallengeTests;

import org.junit.Test;
import junit.framework.TestCase;
import ar.fi.uba.GPSChallenge.Modelo.*;

public class VehiculoTest extends TestCase {

	@Test
		public void testCrearVehiculo(){
		Vehiculo vehiculo = new Vehiculo();
		assertNotNull(vehiculo);
	}
	
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
		Vehiculo vehiculo = new Vehiculo();
		assertEquals(vehiculo.getCantidadDeMovimientos(),0);
	}
	
	@Test
	public void testSetCantidadDeMovimientos(){
		Vehiculo vehiculo = new Vehiculo();
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
		assertEquals(vehiculo.devolverEsquina(), esquina);
	}
	
	@Test
	public void testCrearAutoEnUnaEsquinaYSeMueveAlNorte(){
		Auto auto = new Auto();
		Vehiculo vehiculo = new Vehiculo(auto);
		assertEquals(vehiculo.getEstado(),auto);
		Esquina esquinaInicial = new Esquina(new Posicion(2,2));
		Esquina esquinaFinal = new Esquina(new Posicion(1,2));
		vehiculo.colocarEnEsquina(esquinaInicial);
		assertEquals(vehiculo.devolverEsquina(), esquinaInicial);
		vehiculo.mover(new Norte());
		assertEquals(vehiculo.devolverEsquina(), esquinaFinal);
	}
	
	@Test
	public void testCrearAutoEnUnaEsquinaYSeMueveAlSur(){
		Auto auto = new Auto();
		Vehiculo vehiculo = new Vehiculo(auto);
		assertEquals(vehiculo.getEstado(),auto);
		Esquina esquinaInicial = new Esquina(new Posicion(2,2));
		Esquina esquinaFinal = new Esquina(new Posicion(3,2));
		vehiculo.colocarEnEsquina(esquinaInicial);
		assertEquals(vehiculo.devolverEsquina(), esquinaInicial);
		vehiculo.mover(new Sur());
		assertEquals(vehiculo.devolverEsquina(), esquinaFinal);
	}
	
	@Test
	public void testCrearAutoEnUnaEsquinaYSeMueveAlEste(){
		Auto auto = new Auto();
		Vehiculo vehiculo = new Vehiculo(auto);
		assertEquals(vehiculo.getEstado(),auto);
		Esquina esquinaInicial = new Esquina(new Posicion(2,2));
		Esquina esquinaFinal = new Esquina(new Posicion(2,3));
		vehiculo.colocarEnEsquina(esquinaInicial);
		assertEquals(vehiculo.devolverEsquina(), esquinaInicial);
		vehiculo.mover(new Este());
		assertEquals(vehiculo.devolverEsquina(), esquinaFinal);
	}
	
	@Test
	public void testCrearAutoEnUnaEsquinaYSeMueveAlOeste(){
		Auto auto = new Auto();
		Vehiculo vehiculo = new Vehiculo(auto);
		assertEquals(vehiculo.getEstado(),auto);
		Esquina esquinaInicial = new Esquina(new Posicion(2,2));
		Esquina esquinaFinal = new Esquina(new Posicion(2,1));
		vehiculo.colocarEnEsquina(esquinaInicial);
		assertEquals(vehiculo.devolverEsquina(), esquinaInicial);
		vehiculo.mover(new Oeste());
		assertEquals(vehiculo.devolverEsquina(), esquinaFinal);
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
		assertEquals(vehiculo.devolverEsquina(), esquinaInicial);
		vehiculo.mover(new Oeste());
		assertEquals(vehiculo.devolverEsquina(), esquinaFinal);
		assertEquals(vehiculo.getCantidadDeMovimientos(), 1);
	}
}

	
