public class Auto extends Vehiculo{
	private int cantPasajeros;
	private float velMaxima;
	
	public float consumo() {
		return 20 + (getCantPasajeros() * 10);
	}
	
	public float velocidadMaxima() {
		return getVelMaxima();
	}
	
	public int cantidadPasajeros() {
		return getCantPasajeros();
	}

	public int getCantPasajeros() {
		return cantPasajeros;
	}

	public void setCantPasajeros(int cantPasajeros) {
		this.cantPasajeros = cantPasajeros;
	}

	public float getVelMaxima() {
		return velMaxima;
	}

	public void setVelMaxima(float velMaxima) {
		this.velMaxima = velMaxima;
	}
}
