package ar.fi.uba.GPSChallengeTests;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.fi.uba.GPSChallenge.Modelo.*;



public class VehiculoTest {

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
}
	
	
