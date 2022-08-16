public class Personaje {
	private static final float maxLocura = 100;
	private String nombre;
	private float locura;
	private int secretos;
	private int ubicaci�n;
	
	public Personaje() {
		
	}
	
	public Personaje(String nombre) {
		this.nombre = nombre;
	}
	
	public Personaje(String nombre, float locura, int secretos, int ubicaci�n) {
		this.nombre = nombre;
		setLocura(locura);
		this.secretos = secretos;
		this.ubicaci�n = ubicaci�n;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public float getLocura() {
		return locura;
	}
	
	public void setLocura(float locura) {
		if (getLocura() > maxLocura) {
			this.locura = maxLocura;
		} else {
			this.locura = locura;
		}
	}
	
	public int getSecretos() {
		return secretos;
	}
	
	public void setSecretos(int secretos) {
		this.secretos = secretos;
	}
	
	public int getUbicaci�n() {
		return ubicaci�n;
	}
	
	public void setUbicaci�n(int ubicaci�n) {
		this.ubicaci�n = ubicaci�n;
	}
	
	public void embellecer(int locuraAA�adir) {
		setLocura(locura + locuraAA�adir);
		setSecretos(getSecretos() - 10);
	}
	
	public boolean estaEnMaravilla() {
		return getUbicaci�n() < 0;
	}
	
	public boolean esLindo() {
		return getLocura() > maxLocura * .75 && estaEnMaravilla();
	}
	
	public boolean esNormal() {
		return getLocura() < 10 && getSecretos() >= 500;
	}
}
