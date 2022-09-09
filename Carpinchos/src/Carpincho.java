public class Carpincho {
	
	private String nombre;
	private float agradoPorElMate;
	private Canasta canasta;
	
	public float cacheDeCanasta() {
		return getCanasta().nivelDeCache();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getAgradoPorElMate() {
		return agradoPorElMate;
	}
	public void setAgradoPorElMate(float agradoPorElMate) {
		this.agradoPorElMate = agradoPorElMate;
	}
	public Canasta getCanasta() {
		return canasta;
	}
	public void setCanasta(Canasta canasta) {
		this.canasta = canasta;
	}
}
