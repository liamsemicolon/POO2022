public class Prueba {

	public static void main(String[] args) {
		Mate p = new Mate("Pablo", 250, 350);
		Mate l = new Mate("Liam", 0, 300);
		
		System.out.println((p.lavado()));
		l.cebar(270);
		System.out.println(l.lavado());
		l.tomar();
		System.out.println(l.lavado());
	}

}
