public class Bicicleta extends Vehiculo{
	private int rodado;

	public float consumo() {
		return 1f;
	}
	
	public float velocidadMaxima() {
		return getRodado() * 1.2f;
	}
	
	public int cantidadPasajeros() {
		return 1;
	}
	
	public int getRodado() {
		return rodado;
	}

	public void setRodado(int rodado) {
		this.rodado = rodado;
	}

}
