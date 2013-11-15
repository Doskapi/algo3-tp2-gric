package ar.fi.uba.GPSChallenge.Modelo;

public interface Estado {

	public abstract String getEstado();
	
	public abstract Estado nuevoEstado();

	public abstract int agarrarPozos();

	public abstract double getProbabilidadDePenalizacion();
}
