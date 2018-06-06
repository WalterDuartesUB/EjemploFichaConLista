package ar.edu.ub.p3.vista.paneles;

import java.awt.event.ActionEvent;
import java.util.Collection;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JPanel;

import ar.edu.ub.p3.vista.listener.IABMListener;

public class ABMBotonesPanel<L extends IABMListener<IVM>, IVM> extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton botonNuevo;
	private JButton botonGrabar;
	private JButton botonBorrar;	
	private Collection<L> listeners;
	private IVM viewModel;
	
	public ABMBotonesPanel( IVM viewModel ){
		this.setListeners(new LinkedList<L>());
		this.setViewModel(viewModel);
		addComponents();				
		addLayout();	
	}

	private void addComponents() {
		this.setBotonNuevo(  new JButton("Nuevo")  );
		this.setBotonBorrar(  new JButton("Borrar")  );
		this.setBotonGrabar(  new JButton("Grabar")  );
		
		
		this.getBotonNuevo().addActionListener( this::onClickBotonNuevo);
		this.getBotonBorrar().addActionListener( this::onClickBotonBorrar);
		this.getBotonGrabar().addActionListener( this::onClickBotonGrabar);
		
	}

	public void onClickBotonNuevo(ActionEvent e) {
		for( L listener : this.getListeners() )
			listener.add( this.getViewModel() );
	}
	public void onClickBotonGrabar(ActionEvent e) {
		for( L listener : this.getListeners() )
			listener.modify( this.getViewModel() );
	}
	public void onClickBotonBorrar(ActionEvent e) {
		for( L listener : this.getListeners() )
			listener.delete( this.getViewModel() );		
	}
	
	private void addLayout() {
		this.add( this.getBotonNuevo() );
		this.add( this.getBotonBorrar() );
		this.add( this.getBotonGrabar() );
		this.add( new JButton("Salir"));
	}

	public void addListener(L listener) {
		this.getListeners().add(listener);		
	}

	private JButton getBotonBorrar() {
		return botonBorrar;
	}

	private void setBotonBorrar(JButton botonBorrar) {
		this.botonBorrar = botonBorrar;
	}

	private JButton getBotonGrabar() {
		return botonGrabar;
	}

	private void setBotonGrabar(JButton botonGrabar) {
		this.botonGrabar = botonGrabar;
	}

	private JButton getBotonNuevo() {
		return botonNuevo;
	}

	private void setBotonNuevo(JButton botonNuevo) {
		this.botonNuevo = botonNuevo;
	}

	public Collection<L> getListeners() {
		return listeners;
	}

	private void setListeners(Collection<L> listeners) {
		this.listeners = listeners;
	}

	public IVM getViewModel() {
		return viewModel;
	}

	private void setViewModel(IVM viewModel) {
		this.viewModel = viewModel;
	}
}
