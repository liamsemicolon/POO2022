public class Asistente {
	private String nombre;
	private float sueldoBase;
	
	Asistente(){};
	
	Asistente(float sueldo){
		setSueldoBase(sueldo);
	}
	
	public float salarioFinal() {
		return getSueldoBase();
	}
	
	public boolean ganaMasDe60k() {
		return salarioFinal() > 60000;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getSueldoBase() {
		return sueldoBase;
	}
	public void setSueldoBase(float sueldoBase) {
		this.sueldoBase = sueldoBase;
	}
	
	
}
