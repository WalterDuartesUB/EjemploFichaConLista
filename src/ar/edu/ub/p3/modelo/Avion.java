package ar.edu.ub.p3.modelo;

public class Avion {
	private String idAvion;
	private String nombre;
	
	public Avion(String idAvion, String nombre) {
		this.setIdAvion(idAvion);
		this.setNombre(nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdAvion() {
		return idAvion;
	}

	public void setIdAvion(String idAvion) {
		this.idAvion = idAvion;
	}
	
	@Override
	public String toString() {
		return "Avion [idAvion=" + this.getIdAvion() + ", nombre=" + this.getNombre() + "]";
	}	
}
