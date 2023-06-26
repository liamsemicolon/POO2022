
public class RecIntermedio extends Recorrido {
	
	private boolean pendAscendente;
	
	private float indice() {
		if(getPendAscendente()){
			return (float) 1.5;
		} else {
			return (float) .5;
		}
	}
	
	public float tiempoEstimado() {
		return getDistancia() / 25 * indice();
	}

	public float puntaje() {
		return 1 + indice();
	}

	public boolean getPendAscendente() {
		return pendAscendente;
	}

	public void setPendAscendente(boolean pendAscendente) {
		this.pendAscendente = pendAscendente;
	}
}
