public class hw {
	
	public static void main(String[] args) {
		Entero e = new Entero(), e2 = new Entero();
		e.n = 89;
		e2.n = -188;
		if (e.esPar()) {
			System.out.println("El número ingresado es par.");
		}
		if (e.esImpar()) {
			System.out.println("El número ingresado es impar.");
		}
		if (e.esPositivo()) {
			System.out.println("El número ingresado es positivo.");
		}
		if (e2.esPar()) {
			System.out.println("El segundo número ingresado es par.");
		}
		if (e2.esImpar()) {
			System.out.println("El segundo número ingresado es impar.");
		}
		if (e2.esPositivo()) {
			System.out.println("El segundo número ingresado es positivo.");
		}
	}	
}	