package ar.fi.uba.GPSChallengeTests.Imprevistos;

import junit.framework.TestCase;
import org.junit.Test;

import ar.fi.uba.GPSChallenge.Modelo.Imprevistos.SorpresaCambioDeVehiculo;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Auto;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.CuatroPorCuatro;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Moto;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Vehiculo;

public class SorpresaCambioDeVehiculoTests extends TestCase{
	
	@Test
	public void testCreoUnaSorpresaCambioDeVehiculo(){
		SorpresaCambioDeVehiculo sorpresaCambioDeVehiculo = new SorpresaCambioDeVehiculo();
		assertNotNull(sorpresaCambioDeVehiculo);
	}

	@Test
	public void testCambioUnaMotoAAuto(){
		SorpresaCambioDeVehiculo sorpresaCambioDeVehiculo = new SorpresaCambioDeVehiculo();
		Moto moto = new Moto();
		Vehiculo vehiculo = new Vehiculo(moto);
		sorpresaCambioDeVehiculo.aplicarImprevisto(vehiculo);
		assertEquals(vehiculo.getNombreEstado(),"Auto");
	}

	@Test
	public void testCambioUnAutoACuatroPorCuatro(){
		SorpresaCambioDeVehiculo sorpresaCambioDeVehiculo = new SorpresaCambioDeVehiculo();
		Auto auto = new Auto();
		Vehiculo vehiculo = new Vehiculo(auto);
		sorpresaCambioDeVehiculo.aplicarImprevisto(vehiculo);
		assertEquals(vehiculo.getNombreEstado(),"CuatroPorCuatro");	
	}

	@Test
	public void testCambioUnaCuatroPorCuatroAMoto(){
		SorpresaCambioDeVehiculo sorpresaCambioDeVehiculo = new SorpresaCambioDeVehiculo();
		CuatroPorCuatro cuatroPorCuatro = new CuatroPorCuatro();
		Vehiculo vehiculo = new Vehiculo(cuatroPorCuatro);
		
		sorpresaCambioDeVehiculo.aplicarImprevisto(vehiculo);	
		assertEquals(vehiculo.getNombreEstado(),"Moto");
	}	

	@Test
	public void testUnaMotoSeCambiaAAutoYUnAutoACuatroPorCuatro(){
		SorpresaCambioDeVehiculo unaSorpresaCambioDeVehiculo = new SorpresaCambioDeVehiculo();
		SorpresaCambioDeVehiculo otraSorpresaCambioDeVehiculo = new SorpresaCambioDeVehiculo();
		Moto moto = new Moto();
		Vehiculo vehiculo = new Vehiculo(moto);
		
		unaSorpresaCambioDeVehiculo.aplicarImprevisto(vehiculo);
		assertEquals(vehiculo.getNombreEstado(),"Auto");
		otraSorpresaCambioDeVehiculo.aplicarImprevisto(vehiculo);
		assertEquals(vehiculo.getNombreEstado(),"CuatroPorCuatro");
		
	}
	
	@Test
	public void testUnaMotoSeCambiaAAutoYUnAutoACuatroPorCuatroYDespuesAMoto(){
		SorpresaCambioDeVehiculo unaSorpresaCambioDeVehiculo = new SorpresaCambioDeVehiculo();
		SorpresaCambioDeVehiculo otraSorpresaCambioDeVehiculo = new SorpresaCambioDeVehiculo();
		SorpresaCambioDeVehiculo sorpresaCambioDeVehiculo = new SorpresaCambioDeVehiculo();
		Moto moto = new Moto();
		Vehiculo vehiculo = new Vehiculo(moto);
		
		unaSorpresaCambioDeVehiculo.aplicarImprevisto(vehiculo);
		assertEquals(vehiculo.getNombreEstado(),"Auto");
		otraSorpresaCambioDeVehiculo.aplicarImprevisto(vehiculo);
		assertEquals(vehiculo.getNombreEstado(),"CuatroPorCuatro");
		sorpresaCambioDeVehiculo.aplicarImprevisto(vehiculo);
		assertEquals(vehiculo.getNombreEstado(),"Moto");
	}
	
	@Test
	public void testNoSeVuelveAUsarLaMismaSorpresa(){
		SorpresaCambioDeVehiculo sorpresaCambioDeVehiculo = new SorpresaCambioDeVehiculo();
		Moto moto = new Moto();
		Vehiculo vehiculo = new Vehiculo(moto);
		sorpresaCambioDeVehiculo.aplicarImprevisto(vehiculo);
		assertEquals(vehiculo.getNombreEstado(),"Auto");
		sorpresaCambioDeVehiculo.aplicarImprevisto(vehiculo);
		assertEquals(vehiculo.getNombreEstado(),"Auto");
	}
}