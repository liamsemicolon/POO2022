public class Persona {
	private float capacidadEst�mago;
	private float nivelAlimento;
	
	public Persona() {
	
	}
	
	public Persona(float capacidadEst�mago, float nivelAlimento) {
		this.capacidadEst�mago = capacidadEst�mago;
		setNivelAlimento(nivelAlimento);
	}
	
	public float getCapacidadEst�mago() {
		return capacidadEst�mago;
	}
	
	public void setCapacidadEst�mago(float capacidadEst�mago) {
		this.capacidadEst�mago = capacidadEst�mago;
	}
	
	public float getNivelAlimento() {
		return nivelAlimento;
	}
	
	public void setNivelAlimento(float nivelAlimento) {
		if(nivelAlimento > getCapacidadEst�mago()) {
			this.nivelAlimento = getCapacidadEst�mago();
		} else {
			this.nivelAlimento = nivelAlimento;
		}
	}
	
	public boolean panzaLlena() {
		return getNivelAlimento() >= getCapacidadEst�mago() * .9;
	}
	
	public void crecer(float capacidadAA�adir) {
		setNivelAlimento(getNivelAlimento() + capacidadAA�adir);
	}
	
	public void digerir() {
		setNivelAlimento(0);
	}
	
	public boolean aprender() {
		return panzaLlena();
	}
}
