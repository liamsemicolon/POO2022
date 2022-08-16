public class Local {
	private String rubro;
	private String nombre;
	
	public Local() {	
	}
	
	public Local(String rubro, String nombre) {
		this.rubro = rubro;
		this.nombre = nombre;
	}
	
	public String getRubro() {
		return rubro;
	}
	
	public void setRubro(String rubro) {
		this.rubro = rubro;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean esEsencial() {
		return "farmacia".equalsIgnoreCase(rubro) || "alimentación".equalsIgnoreCase(rubro);
	}
}
