
public abstract class Recorrido {
	private float distancia;

	public abstract float tiempoEstimado();
	
	public abstract float puntaje();
	
	public float getDistancia() {
		return distancia;
	}

	public void setDistancia(float distancia) {
		this.distancia = distancia;
	}
	
}
