import java.util.ArrayList;
public class Empresa {
	private ArrayList<Vehiculo> vehiculos = new ArrayList<>();

	private int totalAccidentes() {
		int i = 0;
		for (Vehiculo v : vehiculos) {
			i += v.cantidadAccidentes();
		}
		return i;
	}
	
	private int totalVehiculos() {
		return getVehiculos().size();
	}
	
	private float promedioAccidentes() {
		return totalAccidentes() / totalVehiculos();
	}
	
	public ArrayList<Vehiculo> losMasAccidentados(){
		ArrayList<Vehiculo> av = new ArrayList<>();
		for (Vehiculo v : getVehiculos()) {
			if(v.cantidadAccidentes() > promedioAccidentes()) {
				av.add(v);
			}
		}
		return av;
	}
	
	private int totalKilometraje() {
		int i = 0;
		for (Vehiculo v : vehiculos) {
			i += v.getKilometraje();
		}
		return i;
	}
	
	private float promedioKilometraje() {
		return totalKilometraje() / totalVehiculos();
	}
	
	public ArrayList<Vehiculo> losDeMasKilometraje(){
		ArrayList<Vehiculo> av = new ArrayList<>();
		for (Vehiculo v : getVehiculos()) {
			if(v.getKilometraje() > promedioKilometraje()) {
				av.add(v);
			}
		}
		return av;
	}
	
	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
}
