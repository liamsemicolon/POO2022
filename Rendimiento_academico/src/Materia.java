public abstract class Materia {
	private String carrera;
	private int año;
	
	public abstract float puntajeFinal();
	
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
}
