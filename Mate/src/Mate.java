public class Mate {
	private String deQuien;
	private int agua;
	private int yerba;
	
	public Mate() {
	}
	
	public Mate(String deQuien, int agua, int yerba) {
		this.deQuien = deQuien;
		setAgua(agua);
		setYerba(yerba);
	}

	public void cebar(int aguaAAñadir) {
		setAgua(getAgua() + aguaAAñadir);
	}
	
	public void tomar() {
		setAgua(0);
	}
	
	public boolean lavado() {
		return getAgua() == (getYerba() * 0.9);
	}
	
	public String getDeQuien() {
		return deQuien;
	}
	
	public void setDeQuien(String deQuien) {
		this.deQuien = deQuien;
	}
	
	public int getAgua() {
		return agua;
	}
	
	public void setAgua(int agua) {
		if(agua >= 0) {
			this.agua = agua;
		} else {
			this.agua = 0;
		}
	}
	
	public int getYerba() {
		return yerba;
	}
	
	public void setYerba(int yerba) {
		if(agua >= 0) {
			this.yerba = yerba;
		} else {
			this.yerba = 0;
		}
	}
	
}
