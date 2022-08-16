import java.util.ArrayList;

public class Santuario {
	private ArrayList<Caballero> caballeros = new ArrayList<>();
	
	public Santuario() {
	}
	
	public Santuario(ArrayList<Caballero> caballeros) {
		this.caballeros = caballeros;
	}
	
	public void agregar(Caballero c) {
		caballeros.add(c);
	}

	public Caballero posibleHades() {
		Caballero hades = getCaballeros().get(0);
		for(Caballero c : getCaballeros()) {
			if(c.getNivelMaldad() < hades.getNivelMaldad()) {
				hades = c;
			}
		}
		return hades;
	}
	
	public ArrayList<Constelacion> constelacionesCercanas(){
		ArrayList<Constelacion> ac = new ArrayList<>();
		for(Caballero c : getCaballeros()) {
			if (c.ConstelacionCercanaAlSol()) {
				ac.add(c.getConstAsociada());
			}
		}
		return ac;
	}
	
	private ArrayList<Caballero> precoces(){
		ArrayList<Caballero> ac = new ArrayList<>();
		for(Caballero c : getCaballeros()) {
			if(c.esPrecoz()) {
				ac.add(c);
			}
		}
		return ac;
	}
	
	public int porcentajePrecoces() {
		return precoces().size() * 100 / getCaballeros().size();
	}
	
	public ArrayList<Caballero> caballerosMasPoderosos() {
		ArrayList<Caballero> ac = new ArrayList<>();
		for(Caballero c : getCaballeros()) {
			if(c.esPoderoso()) {
				ac.add(c);
			}
		}
		return ac;
	}
	
	public ArrayList<Caballero> getCaballeros() {
		return caballeros;
	}

	public void setCaballeros(ArrayList<Caballero> caballeros) {
		this.caballeros = caballeros;
	}
	
}
