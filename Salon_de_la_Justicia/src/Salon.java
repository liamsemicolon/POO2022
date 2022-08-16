import java.util.ArrayList;

public class Salon {
	private ArrayList<Superheroe> superheroes = new ArrayList<>();
	
	private int totalAsistentes() {
		int total = 0;
		for(Superheroe s : getSuperheroes()) {
			total += s.cantidadDeAsistentes();
		}
		return total;
	}
	
	private float promedioAsistentes() {
		return totalAsistentes() / getSuperheroes().size();
	}
	
	public ArrayList<Superheroe> losQueTienenMasAsistentes() {
		ArrayList<Superheroe> arrayS = new ArrayList<>();
		for(Superheroe s : getSuperheroes()) {
			if (s.cantidadDeAsistentes() > promedioAsistentes()) {
				arrayS.add(s);
			}
		}
		return arrayS;
	}
	
	public ArrayList<Superheroe> losQueNoLleganAFinDeMes() {
		ArrayList<Superheroe> arrayS = new ArrayList<>();
		for(Superheroe s : getSuperheroes()) {
			if (!s.llegaAFinDeMes()) {
				arrayS.add(s);
			}
		}
		return arrayS;
	}
	
	public float presupuestoTotal() {
		float f = 0;
		for(Superheroe s : getSuperheroes()) {
			if(s.llegaAFinDeMes()) {
				f += s.dineroRestante();
			}
		}
		return f;
	}
	
	public int totalDeAsistentesQueGananMasDe60k() {
		int i = 0;
		for(Superheroe s : getSuperheroes()) {
			i += s.cantidadDeAsistentesQueGananMasDe60k();
		}
		return i;
	}
	
	public float sumaTotalSalario() {
		float f = 0;
		for(Superheroe s : getSuperheroes()) {
			f += s.totalAPagar();
		}
		return f;
	}
	
	public ArrayList<Superheroe> getSuperheroes() {
		return superheroes;
	}

	public void setSuperheroes(ArrayList<Superheroe> superheroes) {
		this.superheroes = superheroes;
	}
}
