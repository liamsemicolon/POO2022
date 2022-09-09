
public class Optativa extends Materia{
	private int indice;
	private float duracionHoras;
	
	public float puntajeFinal() {
		return getIndice() * getDuracionHoras();
	}
	
	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public float getDuracionHoras() {
		return duracionHoras;
	}

	public void setDuracionHoras(float duracionHoras) {
		this.duracionHoras = duracionHoras;
	}
}
