package modelo;

public class Maratonista {

	private String nombre;
	private int kmPreparacion;
	private int horasDiariasDisponibleParaEntrenar;
	private boolean indumentariaMalaCalidad;
	private boolean contactos;
	private static final int MAXIMO_TIEMPO = 10;

	public Maratonista(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @param km
	 */
	public void entrenar(int km) {
		kmPreparacion += km;
	}

	/**
	 * 
	 * @return
	 */
	public boolean malaPreparacion() {
		return horasDiariasDisponibleParaEntrenar < 2 && kmPreparacion < 100;
	}

	/**
	 * 
	 * @return
	 */
	public boolean quedaraEnElCamino() {
		return malaPreparacion() && indumentariaMalaCalidad;
	}

	/**
	 * 
	 * @return
	 */
	public boolean correConVentaja() {
		return maximoTiempoParaEntrenar() && contactos;
	}

	/**
	 * 
	 * @return
	 */
	public boolean maximoTiempoParaEntrenar() {
		return horasDiariasDisponibleParaEntrenar == MAXIMO_TIEMPO;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getKmPreparacion() {
		return kmPreparacion;
	}

	public void setKmPreparacion(int kmPreparacion) {
		this.kmPreparacion = kmPreparacion;
	}

	public int getHorasDiariasDisponibleParaEntrenar() {
		return horasDiariasDisponibleParaEntrenar;
	}

	public void setHorasDiariasDisponibleParaEntrenar(int horasDiariasDisponibleParaEntrenar) {
		if (horasDiariasDisponibleParaEntrenar > MAXIMO_TIEMPO) {
			this.horasDiariasDisponibleParaEntrenar = MAXIMO_TIEMPO;
		} else {
			this.horasDiariasDisponibleParaEntrenar = horasDiariasDisponibleParaEntrenar;
		}
	}

	public boolean isIndumentariaMalaCalidad() {
		return indumentariaMalaCalidad;
	}

	public void setIndumentariaMalaCalidad(boolean indumentariaMalaCalidad) {
		this.indumentariaMalaCalidad = indumentariaMalaCalidad;
	}

	public boolean isContactos() {
		return contactos;
	}

	public void setContactos(boolean contactos) {
		this.contactos = contactos;
	}

}
