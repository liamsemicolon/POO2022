package modelo;

public class Pizza {
	private String id;
	private String nombre;
	private int calidadPizza;
	
	public Pizza(){}
	
	public Pizza(String nombre, int calidadPizza){
		setNombre(nombre);
		setCalidadPizza(calidadPizza);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCalidadPizza() {
		return calidadPizza;
	}
	public void setCalidadPizza(int calidadPizza) {
		this.calidadPizza = calidadPizza;
	}
}
