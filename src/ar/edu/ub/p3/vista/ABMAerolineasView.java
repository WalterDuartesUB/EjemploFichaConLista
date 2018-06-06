package ar.edu.ub.p3.vista;

import java.awt.GridLayout;

import javax.swing.JFrame;

import ar.edu.ub.p3.controlador.ABMAerolineasControlador;
import ar.edu.ub.p3.vista.paneles.ABMAerolineaPanel;
import ar.edu.ub.p3.vista.paneles.ListaAerolineasPanel;

public class ABMAerolineasView extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ListaAerolineasPanel 	 panelLista;			
	private ABMAerolineaPanel        panelFicha;
	private ABMAerolineasControlador controladorFicha;
	
	public ABMAerolineasView( ABMAerolineasControlador controladorFicha ) {
		this.setControladorFicha(controladorFicha);
		this.addComponent();		
		this.addLayout();
	}

	private void addComponent() {
		this.setPanelFicha( new ABMAerolineaPanel() );
		this.setPanelLista( new ListaAerolineasPanel() );	
		
		this.getPanelLista().setInput( this.getControladorFicha().getAerolineas() );
		
		this.getPanelFicha().addListener( this.getControladorFicha() );
		this.getControladorFicha().addListener( this.getPanelLista() );		
	}

	private void addLayout() {
		this.setLayout( new GridLayout(1,2) );		
		this.add( this.getPanelLista() );
		this.add( this.getPanelFicha() );
				
		this.setSize(700, 600);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public ABMAerolineaPanel getPanelFicha() {
		return panelFicha;
	}

	public void setPanelFicha(ABMAerolineaPanel panelFicha) {
		this.panelFicha = panelFicha;
	}

	public ListaAerolineasPanel getPanelLista() {
		return panelLista;
	}

	public void setPanelLista(ListaAerolineasPanel panelLista) {
		this.panelLista = panelLista;
	}

	public ABMAerolineasControlador getControladorFicha() {
		return controladorFicha;
	}

	public void setControladorFicha(ABMAerolineasControlador controladorFicha) {
		this.controladorFicha = controladorFicha;
	}
}
