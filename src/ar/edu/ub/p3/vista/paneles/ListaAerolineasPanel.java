package ar.edu.ub.p3.vista.paneles;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ar.edu.ub.p3.modelo.Aerolinea;
import ar.edu.ub.p3.vista.listener.IListaAerolineaListener;

public class ListaAerolineasPanel extends JPanel implements IListaAerolineaListener {

	//TODO Esto deberia estar en otro paquete
	private final class DefaultTableModelExtension extends DefaultTableModel {
		private abstract class ModelColumnTable<T>{
			private String nombre;
			public ModelColumnTable(String nombre) {
				this.setNombre(nombre);
			}
			public String getNombre() {
				return nombre;
			}
			public void setNombre(String nombre) {
				this.nombre = nombre;
			}
			
			public abstract Object getValue(T data);
		}
		
		//TODO Esto deberia estar en otro paquete 
		private class ModelColumnTableIdAerolinea extends ModelColumnTable<Aerolinea>{

			public ModelColumnTableIdAerolinea(String nombre) {
				super(nombre);
			}

			@Override
			public Object getValue(Aerolinea data) {
				return data.getIdAerolinea();
			}
			
		}

		//TODO Esto deberia estar en otro paquete
		private class ModelColumnTableNombreAerolinea extends ModelColumnTable<Aerolinea>{
			
			public ModelColumnTableNombreAerolinea(String nombre) {
				super(nombre);
			}
			
			@Override
			public Object getValue(Aerolinea data) {
				return data.getNombre();
			}
			
		}
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private List<Aerolinea> aerolineas;
		private Map<Integer, ModelColumnTable<Aerolinea>> columnas;
		
		public DefaultTableModelExtension( List<Aerolinea> aerolineas ) {
			this.setAerolineas(aerolineas);
			this.setColumnas( new HashMap<Integer, ModelColumnTable<Aerolinea>>());
			this.getColumnas().put(0, new ModelColumnTableIdAerolinea( "idAerolinea") );
			this.getColumnas().put(1, new ModelColumnTableNombreAerolinea("Nombre") );
		}
		
		public List<Aerolinea> getAerolineas() {
			return aerolineas;
		}
		public void setAerolineas(List<Aerolinea> aerolineas) {
			this.aerolineas = aerolineas;
		}
		
		@Override
		public String getColumnName(int column) {
			return getColumnas().get( column ).getNombre();
		}
		
		@Override
		public int getColumnCount() {
			return this.getColumnas().size();
		}

		public Map<Integer, ModelColumnTable<Aerolinea>> getColumnas() {
			return columnas;
		}

		public void setColumnas(Map<Integer, ModelColumnTable<Aerolinea>> columnas) {
			this.columnas = columnas;
		}
		
		@Override
		public int getRowCount() {			
			return this.getAerolineas() == null ? 0 : this.getAerolineas().size();
		}
		
		@Override
		public Object getValueAt(int row, int column) {	
			return this.getColumnas().get( column ).getValue( this.getAerolineas().get(row) );
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private List<Aerolinea> aerolineas;
	private JTable aerolineasTable;
	
	public ListaAerolineasPanel() {
		addComponents();
		addLayout();
	}
	
	private void addLayout() {
		this.setLayout( new BorderLayout() );
		
		this.add( this.getAerolineasTable().getTableHeader(), BorderLayout.PAGE_START );
		this.add( this.getAerolineasTable(), BorderLayout.CENTER);
		
	}

	private void addComponents() {
		this.setAerolineasTable( new JTable() );
	}

	public void setInput(List<Aerolinea> aerolineas) {
		this.setAerolineas(aerolineas);

		this.getAerolineasTable().setModel( new DefaultTableModelExtension( this.getAerolineas() ) );
	}

	public List<Aerolinea> getAerolineas() {
		return aerolineas;
	}

	private void setAerolineas(List<Aerolinea> aerolineas) {
		this.aerolineas = aerolineas;
	}

	public JTable getAerolineasTable() {
		return aerolineasTable;
	}

	public void setAerolineasTable(JTable aerolineasTable) {
		this.aerolineasTable = aerolineasTable;
	}

	@Override
	public void actionPerformed() {
		this.revalidate();
		this.repaint();		
	}

}
