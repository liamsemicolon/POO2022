public class RecAvanzado extends Recorrido{
	private int obstaculos;
	
	public float tiempoEstimado() {
		return getDistancia() / 20 * getObstaculos();
	}

	public float puntaje() {
		return (float) (getDistancia() * .5);
	}

	public int getObstaculos() {
		return obstaculos;
	}

	public void setObstaculos(int obstaculos) {
		this.obstaculos = obstaculos;
	}
}
