public class hw {
	
	public static void main(String[] args) {
		Entero e = new Entero(), e2 = new Entero();
		e.n = 89;
		e2.n = -188;
		if (e.esPar()) {
			System.out.println("El n�mero ingresado es par.");
		}
		if (e.esImpar()) {
			System.out.println("El n�mero ingresado es impar.");
		}
		if (e.esPositivo()) {
			System.out.println("El n�mero ingresado es positivo.");
		}
		if (e2.esPar()) {
			System.out.println("El segundo n�mero ingresado es par.");
		}
		if (e2.esImpar()) {
			System.out.println("El segundo n�mero ingresado es impar.");
		}
		if (e2.esPositivo()) {
			System.out.println("El segundo n�mero ingresado es positivo.");
		}
	}	
}	