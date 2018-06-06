package ar.edu.ub.p3.vista;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JFrame;

import ar.edu.ub.p3.modelo.Aerolinea;
import ar.edu.ub.p3.vista.listener.IABMAerolineaListener;
import ar.edu.ub.p3.vista.listener.IListaAerolineaListener;
import ar.edu.ub.p3.vista.paneles.ABMAerolineaPanel;
import ar.edu.ub.p3.vista.paneles.ListaAerolineasPanel;

public class ABMAerolineasView extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ListaAerolineasPanel 	 panelLista;			
	private ABMAerolineaPanel        panelFicha;	
	
	public ABMAerolineasView( ) {
	
		this.addComponent();		
		this.addLayout();
	}

	private void addComponent() {
		this.setPanelFicha( new ABMAerolineaPanel() );
		this.setPanelLista( new ListaAerolineasPanel() );	
	}

	private void addLayout() {
		this.setLayout( new GridLayout(1,2) );		
		this.add( this.getPanelLista() );
		this.add( this.getPanelFicha() );
				
		this.setSize(700, 600);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private ABMAerolineaPanel getPanelFicha() {
		return panelFicha;
	}

	private void setPanelFicha(ABMAerolineaPanel panelFicha) {
		this.panelFicha = panelFicha;
	}

	private ListaAerolineasPanel getPanelLista() {
		return panelLista;
	}

	public IListaAerolineaListener getListaAerolineaListener() {
		return this.getPanelLista();
	}
	
	private void setPanelLista(ListaAerolineasPanel panelLista) {
		this.panelLista = panelLista;
	}
	
	public void addListener( IABMAerolineaListener controlador) {
		this.getPanelFicha().addListener( controlador );
	}

	public void setInput(List<Aerolinea> aerolineas) {
		this.getPanelLista().setInput( aerolineas );		
	}
}
