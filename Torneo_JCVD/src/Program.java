import java.util.ArrayList;

public class Program {

	public static void main(String[] args) {
		Torneo t = new Torneo();
		t.agregar(new Luchador ("Jet Li", 916, 100, true));
		t.agregar(new Luchador ("Chuck Norris", 930, 110, true));
		t.agregar(new Luchador ("Bruce Lee", 900, 70, false));
		t.agregar(new Luchador ("Liam", 450, 80, false));
		
		ArrayList<Luchador> insectos = t.insectos();
		System.out.println("Lista de insectos:");
		for(Luchador l : insectos) {
			System.out.println(l.getNombre());
		}
		
		ArrayList<Luchador> chuckNorris = t.losChuckNorris(49000);
		System.out.println("Los Chuck Norris:");
		for(Luchador l : chuckNorris) {
			System.out.println(l.getNombre());
		}
		
		System.out.println("Cantidad de JiuJitsus:");
		if(t.hayUnJiuJitsu()) {
			System.out.println(t.laCantidadDeJiuJitsus());
		}
	}
}
