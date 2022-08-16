
public class Entero {
	int n;
	
	boolean esPar () {
		return n % 2 == 0;
	}
	
	boolean esImpar () {
		return !esPar();
	}
	
	boolean esPositivo () {
		return n > 0;
	}
}
