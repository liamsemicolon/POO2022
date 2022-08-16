public class Luchador {
	private static final int constVanDamme = 53;
	private String nombre;
	private int fuerza;
	private int energ�a;
	private boolean practicaJiuJitsu;
	
	public Luchador() {
	}
	
	public Luchador(String nombre, int fuerza, int energ�a, boolean practicaJiuJitsu) {
		this.nombre = nombre;
		this.fuerza = fuerza;
		this.energ�a = energ�a;
		this.practicaJiuJitsu = practicaJiuJitsu;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getFuerza() {
		return fuerza;
	}
	
	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}
	
	public int getEnerg�a() {
		return energ�a;
	}
	
	public void setEnerg�a(int energ�a) {
		this.energ�a = energ�a;
	}
	
	public boolean getPracticaJiuJitsu() {
		return practicaJiuJitsu;
	}

	public void setPracticaJiuJitsu(boolean practicaJiuJitsu) {
		this.practicaJiuJitsu = practicaJiuJitsu;
	}
	
	boolean esChuckNorris (int x) {
		return fuerza * constVanDamme > x && energ�a > 15;
	}
	
	boolean esInsecto() {
		return fuerza < 500;
	}
	
	void entrenar(int x) {
		fuerza += 0.5 * x;
	}
	
	void dormir() {
		energ�a += 20;
	}
}