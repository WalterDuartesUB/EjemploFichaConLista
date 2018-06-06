package ar.edu.ub.p3.controlador;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import ar.edu.ub.p3.modelo.Aerolinea;
import ar.edu.ub.p3.vista.listener.IABMAerolineaListener;
import ar.edu.ub.p3.vista.listener.IListaAerolineaListener;
import ar.edu.ub.p3.vista.modelo.IAerolineaViewModel;

public class ABMAerolineasControlador implements IABMAerolineaListener{

	//TODO El almacenamiento de datos deberia estar en un objeto "Repositorio"
	private List<Aerolinea> aerolineas;
	private Collection<IListaAerolineaListener> listeners;
	
	public ABMAerolineasControlador() {
		this.setListeners( new LinkedList<IListaAerolineaListener>());
		this.setAerolineas( new LinkedList<Aerolinea>());
	}
	
	@Override
	public void add(IAerolineaViewModel aerolineaViewModel) {
		Aerolinea aerolinea = this.crearAerolinea(aerolineaViewModel);
		System.out.println("add: " + aerolinea);
		this.getAerolineas().add( aerolinea );
		
		this.onActionPerformed();
	}

	private void onActionPerformed() {
		for( IListaAerolineaListener listener : this.getListeners() )
			listener.actionPerformed();
	}

	@Override
	public void modify(IAerolineaViewModel aerolineaViewModel) {
		System.out.println("modify: " + this.crearAerolinea(aerolineaViewModel));
		
		this.onActionPerformed();		
	}

	@Override
	public void delete(IAerolineaViewModel aerolineaViewModel) {
		System.out.println("delete: " + this.crearAerolinea(aerolineaViewModel));
		
		this.onActionPerformed();		
	}

	private Aerolinea crearAerolinea( IAerolineaViewModel aerolineaViewModel ) {
		return new Aerolinea( aerolineaViewModel.getIdAerolinea(), aerolineaViewModel.getNombre() );
	}

	public List<Aerolinea> getAerolineas() {
		return this.aerolineas;
	}

	private void setAerolineas(List<Aerolinea> aerolineas) {
		this.aerolineas = aerolineas;
	}

	public void addListener(IListaAerolineaListener listener) {
		this.getListeners().add(listener);		
	}

	private Collection<IListaAerolineaListener> getListeners() {
		return listeners;
	}

	private void setListeners(Collection<IListaAerolineaListener> listeners) {
		this.listeners = listeners;
	}
	
}
