package ar.edu.ub.p3.vista.paneles;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import ar.edu.ub.p3.vista.listener.IABMAerolineaListener;
import ar.edu.ub.p3.vista.modelo.IAerolineaViewModel;

public class ABMAerolineaPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AerolineaPanel panelFichaModelo;
	private ABMBotonesPanel<IABMAerolineaListener, IAerolineaViewModel> panelBotones;
	
	public ABMAerolineaPanel() {
		addComponents();					
		addLayout();			
	}

	private void addComponents() {
		setPanelFichaModelo(new AerolineaPanel());
		setPanelBotones(new ABMBotonesPanel<IABMAerolineaListener, IAerolineaViewModel>( getPanelFichaModelo() ));
	}

	private void addLayout() {
		this.setLayout(new BorderLayout() );
			
		this.add( getPanelFichaModelo(), BorderLayout.NORTH );					
		this.add( getPanelBotones(), BorderLayout.SOUTH );
	}
	
	public void addListener( IABMAerolineaListener listener ) {
		getPanelBotones().addListener( listener );
	}

	private AerolineaPanel getPanelFichaModelo() {
		return panelFichaModelo;
	}

	private void setPanelFichaModelo(AerolineaPanel panelFichaModelo) {
		this.panelFichaModelo = panelFichaModelo;
	}

	private ABMBotonesPanel<IABMAerolineaListener, IAerolineaViewModel> getPanelBotones() {
		return panelBotones;
	}

	private void setPanelBotones(ABMBotonesPanel<IABMAerolineaListener, IAerolineaViewModel> panelBotones) {
		this.panelBotones = panelBotones;
	}

	public IAerolineaViewModel getViewModel() {
		return this.getPanelFichaModelo();
	}
	
}
