import java.util.ArrayList;

public class Superheroe {
	private String nombre;
	private float presupuestoMensual;
	private ArrayList<Asistente> asistentes = new ArrayList<>();
	
	Superheroe(){};
	
	public void contratar (Asistente a) {
		asistentes.add(a);
	}
	
	public float totalAPagar() {
		float f = 0;
		for(Asistente a : getAsistentes()) {
			f += a.salarioFinal();
		}
		return f;
	}

	public float dineroRestante() {
		return getPresupuestoMensual() - totalAPagar();
	}
	
	public boolean llegaAFinDeMes() {
		return getPresupuestoMensual() >= totalAPagar();
	}
	
	public int cantidadDeAsistentes() {
		return asistentes.size();
	}
	
	private ArrayList<Asistente> asistentesQueGananMasDe60k(){
		ArrayList<Asistente> arrayAsistentes = new ArrayList<>();
		for(Asistente a : getAsistentes()) {
			if (a.ganaMasDe60k()) {
				arrayAsistentes.add(a);
			}
		}
		return arrayAsistentes;
	}
	
	public int cantidadDeAsistentesQueGananMasDe60k () {
		return asistentesQueGananMasDe60k().size();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPresupuestoMensual() {
		return presupuestoMensual;
	}
	public void setPresupuestoMensual(float presupuestoMensual) {
		this.presupuestoMensual = presupuestoMensual;
	}
	public ArrayList<Asistente> getAsistentes() {
		return asistentes;
	}
	
	public void setAsistentes(ArrayList<Asistente> asistentes) {
		this.asistentes = asistentes;
	}
	
}
