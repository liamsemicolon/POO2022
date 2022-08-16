
public class checkeo {
	
	int numAEvaluar;
	
	boolean esPar () {
		return numAEvaluar % 2 == 0;
	}
	
	boolean esImpar () {
		return !esPar();
	}
	
	boolean esPositivo () {
		return numAEvaluar > 0;
	}
}
