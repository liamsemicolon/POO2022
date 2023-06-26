package vista;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import dao.MaterialDAO;
import dao.PropuestaDAO;
import modelo.Material;
import modelo.Propuesta;

public class MatePaneles extends JPanel {
	protected DefaultListModel<String> refrescarLista(MaterialDAO mDAO) {
		DefaultListModel<String> dLM = new DefaultListModel<String>();	
		ArrayList<Material> am = mDAO.pedirMateriales();
		for(Material m : am) {
			dLM.addElement(m.getTitulo());
		}
		return dLM;
	}
	
	protected DefaultListModel<String> refrescarListaMateriales(PropuestaDAO pDAO, String titABuscar) {
		DefaultListModel<String> dLM = new DefaultListModel<String>();	
		ArrayList<Propuesta> ap = pDAO.pedirPropuestasDeMaterial(titABuscar);
		for(Propuesta p : ap) {
			dLM.addElement(p.getTitulo());
		}
		return dLM;
	}
	
	protected DefaultTableModel refrescarTabla(MaterialDAO mDAO) {
		DefaultTableModel dTM = new DefaultTableModel();
		dTM.addColumn("Titulo");
		dTM.addColumn("Categoria");
		dTM.addColumn("Descripcion");
		dTM.addColumn("Fuente");
		dTM.addColumn("E.d.D");
		dTM.addColumn("Tipo");
		dTM.addColumn("Proritario");
		dTM.addColumn("Jornada");
		ArrayList<Material> am = mDAO.pedirMateriales();
		for(Material m : am) {
			String tipo = mDAO.pedirTipo(m.getTitulo());
			dTM.insertRow(0, new Object[] {m.getTitulo(), m.getCategoria(), m.getDescripcion(), m.getFuente(), m.getEnlaceDoc(), tipo, m.esPrioritario(), m.getJornada()});
		}
		return dTM;
	}
}