public abstract class Materia {
	private String carrera;
	private int a�o;
	
	public abstract float puntajeFinal();
	
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public int getA�o() {
		return a�o;
	}
	public void setA�o(int a�o) {
		this.a�o = a�o;
	}
}
