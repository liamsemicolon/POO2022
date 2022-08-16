import java.util.ArrayList;

public class Torneo {
	private ArrayList<Luchador> contrincantes = new ArrayList<>();
	
	public Torneo() {
	}
	
	public ArrayList<Luchador> insectos(){
		ArrayList<Luchador> al = new ArrayList<>();
		
		for(Luchador l : getContrincantes()) {
			if (l.esInsecto()) {
				al.add(l);
			}
		}
		return al;
	}
	
	public void agregar(Luchador l){
		this.contrincantes.add(l);
	}
	
	public ArrayList<Luchador> losChuckNorris(int x){
		ArrayList<Luchador> al = new ArrayList<>();
		
		for(Luchador l : getContrincantes()) {
			if (l.esChuckNorris(x)) {
				al.add(l);
			}
		}
		return al;
	}
	
	public boolean hayUnJiuJitsu() {
		for(Luchador l : getContrincantes()) {
			if (l.getPracticaJiuJitsu()) {
				return true;
			}
		}
		return false;
	}
	
	public int laCantidadDeJiuJitsus() {
		int a = 0;
		for (Luchador l : getContrincantes()) {
			if(l.getPracticaJiuJitsu()) {
				a++;
			}
		}
		return a;
	}
	
	public Torneo(ArrayList<Luchador> contrincantes) {
		this.contrincantes = contrincantes;
	}
	
	public ArrayList<Luchador> getContrincantes() {
		return contrincantes;
	}

	public void setContrincantes(ArrayList<Luchador> contrincantes) {
		this.contrincantes = contrincantes;
	}
	
	

}
