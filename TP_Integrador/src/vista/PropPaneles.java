package vista;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import dao.PropuestaDAO;
import modelo.Propuesta;

public class PropPaneles extends JPanel {
	protected DefaultListModel<String> refrescarLista(PropuestaDAO pDAO) {
		DefaultListModel<String> dLM = new DefaultListModel<String>();	
		ArrayList<Propuesta> ap = pDAO.pedirPropuestas();
		for(Propuesta p : ap) {
			dLM.addElement(p.getTitulo());
		}
		return dLM;
	}
	
	protected DefaultTableModel refrescarTabla(PropuestaDAO pDAO) {
		DefaultTableModel dTM = new DefaultTableModel();
		dTM.addColumn("Titulo");
		dTM.addColumn("Origen");
		dTM.addColumn("Categoria");
		dTM.addColumn("Autor");
		dTM.addColumn("Fecha");
		dTM.addColumn("Descripcion");
		dTM.addColumn("Motivacion");
		dTM.addColumn("Estado");
		dTM.addColumn("M.d.R.");		
		ArrayList<Propuesta> ap = pDAO.pedirPropuestas();
		for(Propuesta p : ap) {
			dTM.insertRow(0, new Object[] {p.getTitulo(), p.getOrigen(), p.getCategoria(), p.getAutor(), p.getFecha().toString(), p.getDescripcion(), p.getMotivacion(), p.getEstado(),p.getMotivoRechazo()});
		}
		return dTM;
	}
}
