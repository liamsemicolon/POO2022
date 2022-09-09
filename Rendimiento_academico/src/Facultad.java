import java.util.ArrayList;
public class Facultad {
	private ArrayList<Estudiante> estudiantes = new ArrayList<>();

	public ArrayList<Estudiante> estudiantesConPuntajeMayorAX(float x){
		ArrayList<Estudiante> ae = new ArrayList<>();
		for(Estudiante e : getEstudiantes()) {
			if(e.puntaje() > x) {
				ae.add(e);
			}
		}
		return ae;
	}
	
	private ArrayList<Estudiante> losQueLlevanMasDe10A�osYTrabajan(){
		ArrayList<Estudiante> ae = new ArrayList<>();
		for(Estudiante e : getEstudiantes()) {
			if(e.llevaMasDe10A�os() && e.getTrabaja()) {
				ae.add(e);
			}
		}
		return ae;
	}
	
	public int cantidadQueLlevaMasDe10A�osYTrabaja() {
		return losQueLlevanMasDe10A�osYTrabajan().size();
	}
	
	public ArrayList<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
}