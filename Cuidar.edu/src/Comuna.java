import java.util.ArrayList;

public class Comuna {
	private ArrayList<Persona> habitantes = new ArrayList<>();
	
	public Comuna() {
	}
	
	public Comuna(ArrayList<Persona> habitantes) {
		this.habitantes = habitantes;
	}
	
	public void agregar(Persona p){
		this.habitantes.add(p);
	}
	
	public ArrayList<Persona> losQueBuscanElVirus(){
		ArrayList<Persona> ap = new ArrayList<>();
		for(Persona p : getHabitantes()) {
			if(p.estoyBuscandoElVirus()) {
				ap.add(p);
			}
		}
		return ap;
	}
	
	public ArrayList<Persona> losQueDebenAislarse(){
		ArrayList<Persona> ap = new ArrayList<>();
		for(Persona p : getHabitantes()) {
			if(p.meAislo()) {
				ap.add(p);
			}
		}
		return ap;
	}
	
	public Persona personaQueMasSalio() {
		Persona salioMas = new Persona();
		for(Persona p : getHabitantes()) {
			if(p.getCantSalidas() > salioMas.getCantSalidas()) {
				salioMas = p;
			}
		}
		return salioMas;
	}
	
	public int porcentajeDNIImpar() {
		int cantDNIImpar = 0;
		for(Persona p : getHabitantes()) {
			if(p.DNIImpar()) {
				cantDNIImpar++;
			}
		}
		return (100 * cantDNIImpar) / cantHabitantes();
	}
	
	private int cantHabitantes() {
		return getHabitantes().size();
	}

	public ArrayList<Persona> getHabitantes() {
		return habitantes;
	}

	public void setHabitantes(ArrayList<Persona> habitantes) {
		this.habitantes = habitantes;
	}
	
}
