import java.util.ArrayList;

public class Mundo {
	
	private ArrayList<Personaje> personajes;
	
	public Mundo() {
		this.personajes = new ArrayList<>();
	}
	
	public void agregar(Personaje p){
		this.personajes.add(p);
	}
	
	public boolean hayNormal() {
		for(Personaje p : getPersonajes()){
			if(p.esNormal()) {
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Personaje> encontrarLindos() {
		ArrayList<Personaje> ap = new ArrayList<>();
		for(Personaje p : getPersonajes()) {
			if(p.esLindo()) {
				ap.add(p);
			}
		}
		return ap;
	}
	
	public int cuantosEnMaravilla() {
		int personajesEnMaravilla = 0;
		for(Personaje p : getPersonajes()){
			if(p.estaEnMaravilla()) {
				personajesEnMaravilla++;
			}
		}
		return personajesEnMaravilla;
	}
	
	public Personaje mayorLocura() {
		Personaje pMayor = this.personajes.get(0);		
		for(Personaje p : getPersonajes()){
			if(p.getLocura() > pMayor.getLocura()) {
				pMayor = p;
			}
		}
		return pMayor;
	}
	
	public boolean masLindosQueNormales() {
		int personajesNormales = 0;
		for(Personaje p : getPersonajes()){
			if(p.esNormal()) {
				personajesNormales++;
			}
		}
		return cantidadDeLindos() > personajesNormales;
	}

	private int cantidadDeLindos() {
		return encontrarLindos().size();
	}
	
	public ArrayList<Personaje> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(ArrayList<Personaje> personajes) {
		this.personajes = personajes;
	}

}