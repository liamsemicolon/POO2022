
public class RecFacil extends Recorrido {

	public float tiempoEstimado() {
		return getDistancia() / 30;
	}

	public float puntaje() {
		return 1;
	}

}
