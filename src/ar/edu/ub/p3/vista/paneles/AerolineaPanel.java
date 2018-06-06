package ar.edu.ub.p3.vista.paneles;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ar.edu.ub.p3.vista.modelo.IAerolineaViewModel;

public class AerolineaPanel extends JPanel implements IAerolineaViewModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField idAeropuertoField;
	private JTextField nombreAeropuertoField;

	public AerolineaPanel() {
		addComponents();
		addLayout();
		
	}

	private void addComponents() {
		this.setIdAeropuertoField( new JTextField() );
		this.setNombreAeropuertoField( new JTextField() );
		
	}

	private void addLayout() {
		this.setLayout( new GridLayout(2,2));
		this.add( new JLabel("idAeropuerto"));
		this.add( this.getIdAeropuertoField() );
		this.add( new JLabel("Nombre"));
		this.add( this.getNombreAeropuertoField() );
	}

	@Override
	public String getIdAerolinea() {
		return this.getIdAeropuertoField().getText();
	}

	@Override
	public String getNombre() {
		return this.getNombreAeropuertoField().getText();
	}

	@Override
	public void setIdAerolinea(String idAerolinea) {
		this.getIdAeropuertoField().setText(idAerolinea);		
	}

	@Override
	public void setNombre(String nombre) {
		this.getNombreAeropuertoField().setText(nombre);		
	}

	public JTextField getIdAeropuertoField() {
		return idAeropuertoField;
	}

	public void setIdAeropuertoField(JTextField idAeropuertoField) {
		this.idAeropuertoField = idAeropuertoField;
	}

	public JTextField getNombreAeropuertoField() {
		return nombreAeropuertoField;
	}

	public void setNombreAeropuertoField(JTextField nombreAeropuertoField) {
		this.nombreAeropuertoField = nombreAeropuertoField;
	}
}
