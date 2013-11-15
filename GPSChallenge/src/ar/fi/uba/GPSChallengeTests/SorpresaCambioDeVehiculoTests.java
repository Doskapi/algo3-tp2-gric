package ar.fi.uba.GPSChallengeTests;

import junit.framework.TestCase;
import org.junit.Test;

import ar.fi.uba.GPSChallenge.Modelo.Moto;
import ar.fi.uba.GPSChallenge.Modelo.Auto;
import ar.fi.uba.GPSChallenge.Modelo.CuatroPorCuatro;
import ar.fi.uba.GPSChallenge.Modelo.SorpresaCambioDeVehiculo;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo;

public class SorpresaCambioDeVehiculoTests extends TestCase{
	
	@Test
	public void testCreoUnaSorpresaCambioDeVehiculo(){
		SorpresaCambioDeVehiculo sorpresaCambioDeVehiculo = new SorpresaCambioDeVehiculo();
		assertNotNull(sorpresaCambioDeVehiculo);
	}

	public void testCambioUnaMotoAAuto(){
		SorpresaCambioDeVehiculo sorpresaCambioDeVehiculo = new SorpresaCambioDeVehiculo();
		Moto moto = new Moto();
		Vehiculo vehiculo = new Vehiculo(moto);
		sorpresaCambioDeVehiculo.aplicarImprevisto(vehiculo);
		assertEquals(vehiculo.getNombreEstado(),"Auto");
	}
	
	public void testCambioUnAutoACuatroPorCuatro(){
		SorpresaCambioDeVehiculo sorpresaCambioDeVehiculo = new SorpresaCambioDeVehiculo();
		Auto auto = new Auto();
		Vehiculo vehiculo = new Vehiculo(auto);
		sorpresaCambioDeVehiculo.aplicarImprevisto(vehiculo);
		assertEquals(vehiculo.getNombreEstado(),"CuatroPorCuatro");	
	}
	
	public void testCambioUnaCuatroPorCuatroAMoto(){
		SorpresaCambioDeVehiculo sorpresaCambioDeVehiculo = new SorpresaCambioDeVehiculo();
		CuatroPorCuatro cuatroPorCuatro = new CuatroPorCuatro();
		Vehiculo vehiculo = new Vehiculo(cuatroPorCuatro);
		sorpresaCambioDeVehiculo.aplicarImprevisto(vehiculo);		
		assertEquals(vehiculo.getNombreEstado(),"Moto");
	}	

	public void testCambioUnaMotoAAutoYDespuesACuatroPorCuatro(){
		SorpresaCambioDeVehiculo sorpresaCambioDeVehiculo = new SorpresaCambioDeVehiculo();
		Moto moto = new Moto();
		Vehiculo vehiculo = new Vehiculo(moto);
		sorpresaCambioDeVehiculo.aplicarImprevisto(vehiculo);
		assertEquals(vehiculo.getNombreEstado(),"Auto");
		sorpresaCambioDeVehiculo.aplicarImprevisto(vehiculo);
		assertEquals(vehiculo.getNombreEstado(),"CuatroPorCuatro");
	}
	
	public void testCambioUnaMotoAAutoYDespuesACuatroPorCuatroYDespuesAMoto(){
		SorpresaCambioDeVehiculo sorpresaCambioDeVehiculo = new SorpresaCambioDeVehiculo();
		Moto moto = new Moto();
		Vehiculo vehiculo = new Vehiculo(moto);
		sorpresaCambioDeVehiculo.aplicarImprevisto(vehiculo);
		assertEquals(vehiculo.getNombreEstado(),"Auto");
		sorpresaCambioDeVehiculo.aplicarImprevisto(vehiculo);
		assertEquals(vehiculo.getNombreEstado(),"CuatroPorCuatro");
		sorpresaCambioDeVehiculo.aplicarImprevisto(vehiculo);
		assertEquals(vehiculo.getNombreEstado(),"Moto");
	}

}