import java.time.LocalDate;
import java.util.ArrayList;

public class Estudiante {
	private String nombre;
	private boolean regularidad;
	private boolean trabaja;
	private int a�oIngreso;
	private ArrayList<Materia> materias = new ArrayList<>();
	
	public void asignarMateria(Materia m) {
		if(getRegularidad()) {
			this.materias.add(m);
		}
	}
	
	public float puntaje() {
		float f = 0;
		for(Materia m : materias) {
			f += m.puntajeFinal();
		}
		return f;
	}
	
	private int a�osEnLaMateria() {
		return LocalDate.now().getYear() - getA�oIngreso();
	}
	
	public boolean llevaMasDe10A�os() {
		return a�osEnLaMateria() > 10;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean getRegularidad() {
		return regularidad;
	}
	public void setRegularidad(boolean regularidad) {
		this.regularidad = regularidad;
	}
	public boolean getTrabaja() {
		return trabaja;
	}
	public void setTrabaja(boolean trabaja) {
		this.trabaja = trabaja;
	}
	public int getA�oIngreso() {
		return a�oIngreso;
	}
	public void setA�oIngreso(int a�oIngreso) {
		this.a�oIngreso = a�oIngreso;
	}
	public ArrayList<Materia> getMaterias() {
		return materias;
	}
	public void setMaterias(ArrayList<Materia> materias) {
		this.materias = materias;
	}
	
}
