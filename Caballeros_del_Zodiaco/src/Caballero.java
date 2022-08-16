public class Caballero {
	private String nombre;
	private int edadNombramiento;
	private int nivelMaldad;
	private Constelacion constAsociada;
	
	public Caballero() {
	}
	
	public Caballero(String nombre, int edadNombramiento, int nivelMaldad, Constelacion constAsociada) {
		this.nombre = nombre;
		this.edadNombramiento = edadNombramiento;
		this.nivelMaldad = nivelMaldad;
		this.constAsociada = constAsociada;
	}
	
	public boolean esPrecoz() {
		return getEdadNombramiento() < 12;
	}
	
	public boolean esDorado() {
		return getConstAsociada().getZodiacal();
	}
	
	public String titulo() {
		return getNombre() + " de " + getConstAsociada().getNombre();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdadNombramiento() {
		return edadNombramiento;
	}
	public void setEdadNombramiento(int edadNombramiento) {
		this.edadNombramiento = edadNombramiento;
	}
	public int getNivelMaldad() {
		return nivelMaldad;
	}
	public void setNivelMaldad(int nivelMaldad) {
		this.nivelMaldad = nivelMaldad;
	}
	public Constelacion getConstAsociada() {
		return constAsociada;
	}
	public void setConstAsociada(Constelacion constAsociada) {
		this.constAsociada = constAsociada;
	}

	public boolean esPoderoso() {
		return esPrecoz() && esDorado();
	}

	public boolean ConstelacionCercanaAlSol() {
		return getConstAsociada().esCercanaAlSol();
	}
	
}
