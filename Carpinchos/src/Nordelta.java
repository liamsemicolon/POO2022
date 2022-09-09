import java.util.ArrayList;

public class Nordelta {
	private ArrayList<Carpincho> carpinchos = new ArrayList<>();
	
	public float numeroTotalDeCache () {
		float cacheT = 0f;
		
		for (Carpincho c : getCarpinchos()) {
			cacheT += c.cacheDeCanasta();
		}
		
		return cacheT;
	}
	
	private int cantidadDeCarpinchos() {
		return getCarpinchos().size();
	}
	
	private float promedioCache() {
		return numeroTotalDeCache() / cantidadDeCarpinchos();
	}
	
	public boolean estamosEnLaBristol() {
		if (promedioCache() > 80) {
			return true;
		}
		return false;
	}
	
	public ArrayList<Carpincho> getCarpinchos() {
		return carpinchos;
	}

	public void setCarpinchos(ArrayList<Carpincho> carpinchos) {
		this.carpinchos = carpinchos;
	}
}
