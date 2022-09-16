import java.util.ArrayList;

public abstract class Vehiculo {
	private String marca;
	private int patente;
	private int añoFabricacion;
	private int kilometraje;
	private Conductor conductor;
	private ArrayList<Accidente> accidentes = new ArrayList<>();
	public abstract float consumo();
	
	public abstract float velocidadMaxima();
	
	public abstract int cantidadPasajeros();
	
	public int cantidadAccidentes() {
		return getAccidentes().size();
	}
	
	public boolean consumeMenosQueX(float x) {
		return consumo() < x;
	}
	
	public float coeficienteDeEficiencia() {
		return (cantidadPasajeros() * velocidadMaxima()) / consumo();
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getPatente() {
		return patente;
	}
	public void setPatente(int patente) {
		this.patente = patente;
	}
	public int getAñoFabricacion() {
		return añoFabricacion;
	}
	public void setAñoFabricacion(int añoFabricacion) {
		this.añoFabricacion = añoFabricacion;
	}
	public int getKilometraje() {
		return kilometraje;
	}
	public void setKilometraje(int kilometraje) {
		this.kilometraje = kilometraje;
	}
	
	public Conductor getConductor() {
		return conductor;
	}
	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}
	public ArrayList<Accidente> getAccidentes() {
		return accidentes;
	}
	
	public void setAccidentes(ArrayList<Accidente> accidentes) {
		this.accidentes = accidentes;
	}
}
