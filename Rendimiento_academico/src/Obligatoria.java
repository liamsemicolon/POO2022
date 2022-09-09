public class Obligatoria extends Materia {
	
	private int puntajeBase;
	private boolean recursa;
	
	public float puntajeFinal() {
		if(!getRecursa()) {
			return getPuntajeBase() * getAño();
		} else {
			return getPuntajeBase();
		}
	}

	public int getPuntajeBase() {
		return puntajeBase;
	}

	public void setPuntajeBase(int puntajeBase) {
		this.puntajeBase = puntajeBase;
	}
	
	public boolean getRecursa() {
		return recursa;
	}

	public void setRecursa(boolean recursa) {
		this.recursa = recursa;
	}
}
