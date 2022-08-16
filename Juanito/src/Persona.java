public class Persona {
	private float capacidadEstómago;
	private float nivelAlimento;
	
	public Persona() {
	
	}
	
	public Persona(float capacidadEstómago, float nivelAlimento) {
		this.capacidadEstómago = capacidadEstómago;
		setNivelAlimento(nivelAlimento);
	}
	
	public float getCapacidadEstómago() {
		return capacidadEstómago;
	}
	
	public void setCapacidadEstómago(float capacidadEstómago) {
		this.capacidadEstómago = capacidadEstómago;
	}
	
	public float getNivelAlimento() {
		return nivelAlimento;
	}
	
	public void setNivelAlimento(float nivelAlimento) {
		if(nivelAlimento > getCapacidadEstómago()) {
			this.nivelAlimento = getCapacidadEstómago();
		} else {
			this.nivelAlimento = nivelAlimento;
		}
	}
	
	public boolean panzaLlena() {
		return getNivelAlimento() >= getCapacidadEstómago() * .9;
	}
	
	public void crecer(float capacidadAAñadir) {
		setNivelAlimento(getNivelAlimento() + capacidadAAñadir);
	}
	
	public void digerir() {
		setNivelAlimento(0);
	}
	
	public boolean aprender() {
		return panzaLlena();
	}
}
