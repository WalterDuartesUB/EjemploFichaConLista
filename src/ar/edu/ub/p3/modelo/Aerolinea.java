package ar.edu.ub.p3.modelo;

public class Aerolinea {
	private String idAerolinea;
	private String nombre;
	public Aerolinea(String idAerolinea, String nombre) {
		this.setIdAerolinea(idAerolinea);
		this.setNombre(nombre);
	}
	
	public String getIdAerolinea() {
		return idAerolinea;
	}
	private void setIdAerolinea(String idAerolinea) {
		this.idAerolinea = idAerolinea;
	}
	public String getNombre() {
		return nombre;
	}
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Aerolinea [idAerolinea=" + this.getIdAerolinea() + ", nombre=" + this.getNombre()+ "]";
	}
}
