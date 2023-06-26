import java.util.ArrayList;

public class Carrera {
	ArrayList<Ciclista> ciclistas;
	
	public ArrayList<Ciclista> losQueTienenUnPuntajeMayorA30(){
		ArrayList<Ciclista> ac = new ArrayList<>();
		for (Ciclista c : getCiclistas()){
			if(c.puntajeSuperaLos30()){
				ac.add(c);
			}
		}
		return ac;
	}
	
	public Ciclista elQueTieneElMayorTiempoEstimado(){
		Ciclista c = getCiclistas().get(0);
		for (Ciclista d : getCiclistas()){
			if(c.tiempoEstimado() < d.tiempoEstimado()){
				c = d;
			}
		}
		return c;
	}
	
	public boolean algunCiclistaTerminaSuRecorridoEnMenosDe2Horas(){
		for (Ciclista c : getCiclistas()){
			if(c.tiempoTotalMenorA2Horas()){
				return true;
			}
		}
		return false;
	}

	public ArrayList<Ciclista> getCiclistas() {
		return ciclistas;
	}

	public void setCiclistas(ArrayList<Ciclista> ciclistas) {
		this.ciclistas = ciclistas;
	}
}
