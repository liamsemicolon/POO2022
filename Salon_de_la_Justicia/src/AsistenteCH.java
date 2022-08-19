public class AsistenteCH extends Asistente{
	
	AsistenteCH(){};
	
	AsistenteCH(float sueldo){
		super(sueldo); 
	}
	
	public float salarioFinal() {
		return getSueldoBase() * 1.2f;
	}

}
