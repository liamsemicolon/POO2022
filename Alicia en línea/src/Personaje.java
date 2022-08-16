public class Personaje {
	private static final float maxLocura = 100;
	private String nombre;
	private float locura;
	private int secretos;
	private int ubicación;
	
	public Personaje() {
		
	}
	
	public Personaje(String nombre) {
		this.nombre = nombre;
	}
	
	public Personaje(String nombre, float locura, int secretos, int ubicación) {
		this.nombre = nombre;
		setLocura(locura);
		this.secretos = secretos;
		this.ubicación = ubicación;
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
	
	public int getUbicación() {
		return ubicación;
	}
	
	public void setUbicación(int ubicación) {
		this.ubicación = ubicación;
	}
	
	public void embellecer(int locuraAAñadir) {
		setLocura(locura + locuraAAñadir);
		setSecretos(getSecretos() - 10);
	}
	
	public boolean estaEnMaravilla() {
		return getUbicación() < 0;
	}
	
	public boolean esLindo() {
		return getLocura() > maxLocura * .75 && estaEnMaravilla();
	}
	
	public boolean esNormal() {
		return getLocura() < 10 && getSecretos() >= 500;
	}
}
