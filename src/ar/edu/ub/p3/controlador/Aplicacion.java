package ar.edu.ub.p3.controlador;
import ar.edu.ub.p3.vista.ABMAerolineasView;

public class Aplicacion {

	public static void main(String[] args) {
		
		//TODO encapsular en un "accion" para invocarlo luego desde la ejecucion de la app
		ABMAerolineasView abmAerolineas = new ABMAerolineasView();
		ABMAerolineasControlador controlador = new ABMAerolineasControlador();
		
		abmAerolineas.setInput( controlador.getAerolineas() );
		abmAerolineas.addListener( controlador );
		
		//TODO ver donde queda mejor esto
		controlador.addListener( abmAerolineas.getListaAerolineaListener() );
	}

}
