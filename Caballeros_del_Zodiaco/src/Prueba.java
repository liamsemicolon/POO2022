import java.util.ArrayList;

public class Prueba {

	public static void main(String[] args) {
		Santuario s = new Santuario();
		
		s.agregar(new Caballero("Seiya", 11, 42, new Constelacion("Pegaso", 1042, false)));
		s.agregar(new Caballero("Aiolos", 14, 32, new Constelacion("Sagitario", 820, true)));
		s.agregar(new Caballero("Orphee", 13, 40, new Constelacion("Lyra", 950, false)));
		s.agregar(new Caballero("Shun", 9, 25, new Constelacion("Andrómeda", 1658, false)));
		s.agregar(new Caballero("Aiolia", 10, 55, new Constelacion("Leo", 958, true)));
		
		System.out.println("Estimada próxima reencarnación de Hades: " + s.posibleHades().titulo());
		ArrayList<Constelacion> masCercanas = s.constelacionesCercanas();
		System.out.println("Constelaciones más cercanas al Sol:");
		for(Constelacion c : masCercanas) {
			System.out.println(c.getNombre());
		}
		System.out.println("Porcentaje de caballeros precoces: " + s.porcentajePrecoces() + "%");
		ArrayList<Caballero> masPoderosos = s.caballerosMasPoderosos();
		System.out.println("Caballeros más poderosos:");
		for(Caballero d : masPoderosos) {
			System.out.println(d.titulo());
		}
	}

}
