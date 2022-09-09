public class CanastaSofisticada extends Canasta {
	public float jamon;
	
	public float nivelDeCache() {
		return 100 - (getAgua() * getJamon());
	}
	
	public float getJamon() {
		return jamon;
	}

	public void setJamon(float jamon) {
		this.jamon = jamon;
	}
}
