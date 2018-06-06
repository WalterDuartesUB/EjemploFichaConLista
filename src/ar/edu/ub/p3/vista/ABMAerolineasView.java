package ar.edu.ub.p3.vista;

import java.awt.GridLayout;

import javax.swing.JFrame;

import ar.edu.ub.p3.controlador.ABMAerolineasControlador;
import ar.edu.ub.p3.vista.paneles.ABMAerolineaPanel;
import ar.edu.ub.p3.vista.paneles.ListaAerolineasPanel;

public class ABMAerolineasView {
	public ABMAerolineasView() {
		JFrame frame = new JFrame();
		
		frame.setLayout( new GridLayout(1,2) );		

		ABMAerolineasControlador controladorFicha = new ABMAerolineasControlador();		
		ListaAerolineasPanel 	 panelLista = new ListaAerolineasPanel();			
		ABMAerolineaPanel        panelFicha = new ABMAerolineaPanel();
						
		panelLista.setInput( controladorFicha.getAerolineas() );
		
		panelFicha.addListener( controladorFicha );
		controladorFicha.addListener( panelLista );
		
		this.addLayout(frame, panelLista, panelFicha);
		
		//Fuerzo unos datos iniciales para la ficha
		panelFicha.getViewModel().setIdAerolinea("AAAA");
		panelFicha.getViewModel().setNombre("Aeropuertos 2018");
	}

	private void addLayout(JFrame frame, ListaAerolineasPanel panelLista, ABMAerolineaPanel panelFicha) {
		frame.add( panelLista );
		frame.add( panelFicha );
				
		frame.setSize(700, 600);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
