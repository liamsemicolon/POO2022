import java.util.ArrayList;

public class Ciclista {
	private float velPromedio;
	private ArrayList<Recorrido> recorridos;
	
	private float puntaje(){
		float f = 0;
		for (Recorrido r : getRecorridos()){
			f += r.puntaje();
		}
		return f;
	}
	
	public boolean puntajeSuperaLos30(){
		return puntaje() > 30;
	}
	
	public float tiempoEstimado(){
		float f = 0;
		for (Recorrido r : getRecorridos()){
			f += r.tiempoEstimado();
		}
		return f;
	}
	
	private float distanciaTotal(){
		float f = 0;
		for (Recorrido r : getRecorridos()){
			f += r.getDistancia();
		}
		return f;
	}
	
	private float tiempoTotal(){
		return distanciaTotal() / getVelPromedio();
	}
	
	public boolean tiempoTotalMenorA2Horas() {
		return tiempoTotal() < 2;
	}
	
	public float getVelPromedio() {
		return velPromedio;
	}
	public void setVelPromedio(float velPromedio) {
		this.velPromedio = velPromedio;
	}
	public ArrayList<Recorrido> getRecorridos() {
		return recorridos;
	}
	public void setRecorridos(ArrayList<Recorrido> recorridos) {
		this.recorridos = recorridos;
	}
}
