package ar.edu.ub.p3.controlador;
import ar.edu.ub.p3.vista.ABMAerolineasView;

public class Aplicacion {

	public static void main(String[] args) {
		new ABMAerolineasView( new ABMAerolineasControlador() );	
	}

}
