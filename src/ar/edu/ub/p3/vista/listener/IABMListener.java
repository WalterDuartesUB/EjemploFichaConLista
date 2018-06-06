package ar.edu.ub.p3.vista.listener;

public interface IABMListener<IVM> {
	public void add( IVM aerolineaViewModel);
	public void modify( IVM aerolineaViewModel);
	public void delete( IVM aerolineaViewModel);
}
