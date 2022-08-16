package modelo;

import java.util.ArrayList;

public class Maraton {
	
	private String nombre;
	private int km;
	private ArrayList<Maratonista> inscriptes = new ArrayList<>();
	
	public void inscribir(Maratonista m) {
		this.inscriptes.add(m);
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Maratonista> lesQueQuedaranEnElCamino() {
		ArrayList<Maratonista> filtrado = new ArrayList<Maratonista>();
		for (Maratonista maratonista : inscriptes) {
			if (maratonista.quedaraEnElCamino()) {
				filtrado.add(maratonista);
			}
		}
		return filtrado;
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Maratonista> lesQueCorrenConVentaja() {
		ArrayList<Maratonista> filtrado = new ArrayList<Maratonista>();
		for (Maratonista maratonista : inscriptes) {
			if (maratonista.correConVentaja()) {
				filtrado.add(maratonista);
			}
		}
		return filtrado;
	}

	public ArrayList<Maratonista> getInscriptes() {
		return inscriptes;
	}

	public void setInscriptes(ArrayList<Maratonista> inscriptes) {
		this.inscriptes = inscriptes;
	}

}
