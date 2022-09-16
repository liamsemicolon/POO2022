public class Moto extends Vehiculo {
	private boolean habilitadaRuta;
	private int cilindrada;
	
	public float consumo() {
		return 50 + (getCilindrada() / 10);
	}
	
	public float velocidadMaxima() {
		return getCilindrada() / 2;
	}
	
	public int cantidadPasajeros() {
		if(getCilindrada() > 75) {
			return 1;
		} else {
			return 2;
		}
	}
	
	public boolean isHabilitadaRuta() {
		return habilitadaRuta;
	}
	public void setHabilitadaRuta(boolean habilitadaRuta) {
		this.habilitadaRuta = habilitadaRuta;
	}
	public int getCilindrada() {
		return cilindrada;
	}
	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}
}
