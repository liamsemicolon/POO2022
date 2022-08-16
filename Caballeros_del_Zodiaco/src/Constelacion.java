public class Constelacion {
	private String nombre;
	private int distanciaAlSol;
	private boolean zodiacal;
	
	public Constelacion() {
	}
	
	public Constelacion(String nombre, int distanciaAlSol, boolean zodiacal) {
		this.nombre = nombre;
		this.distanciaAlSol = distanciaAlSol;
		this.zodiacal = zodiacal;
	}
	
	public boolean esCercanaAlSol() {
		return getDistanciaAlSol() < 1000;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDistanciaAlSol() {
		return distanciaAlSol;
	}
	public void setDistanciaAlSol(int distanciaAlSol) {
		this.distanciaAlSol = distanciaAlSol;
	}
	public boolean getZodiacal() {
		return zodiacal;
	}
	public void setZodiacal(boolean zodiacal) {
		this.zodiacal = zodiacal;
	}
	
}
