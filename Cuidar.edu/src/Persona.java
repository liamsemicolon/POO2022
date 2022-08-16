public class Persona {
	private String nombre;
	private int dni;
	private int cantSalidas;
	private double temperatura;
	
	public Persona() {
	}
	
	public Persona(String nombre, int dni, double temperatura, int cantSalidas) {
		this.nombre = nombre;
		this.dni = dni;
		this.temperatura = temperatura;
		this.cantSalidas = cantSalidas;
	}
	
	public boolean meAislo() {
		return getTemperatura() > 37;
	}
	
	public boolean puedoIrAComprarAUnLocalEnTalDía (int día, Local l) {
		if (!meAislo()) {
			if (l.esEsencial()) {
				return true;
			} else {
				return coincideDNI(día);
			}
		}
		return false;
	}
	
	private boolean coincideDNI(int n) {
		return esImpar(getDni()) == esImpar(n);
	}
	
	private boolean esImpar(int n) {
		return n % 2 == 1;
	}
	
	public boolean DNIImpar() {
		return esImpar(getDni());
	}
	
	public void salir() {
		setCantSalidas(cantSalidas+1);
	}
	
	public boolean estoyBuscandoElVirus() {
		return getCantSalidas() > 10;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDni() {
		return dni;
	}
	
	public void setDni(int dni) {
		this.dni = dni;
	}
	
	public int getCantSalidas() {
		return cantSalidas;
	}
	
	public void setCantSalidas(int cantSalidas) {
		this.cantSalidas = cantSalidas;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}
	
}
