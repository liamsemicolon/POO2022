package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MaratonistaTest {
	/*	Prueba de maximoTiempoParaEntrenar(), que devuelve true si:
	 *	- El maratonista cuenta con una cantidad de horas diarias
	 *	  para entrenar que es igual al máximo establecido
	 */
	
	@Test
	void noTieneElTiempoMaximoParaEntrenar() {
		Maratonista m = new Maratonista("No cuenta con tanto tiempo");
		m.setHorasDiariasDisponibleParaEntrenar(8);
		assertFalse(m.maximoTiempoParaEntrenar());
	}
	
	@Test
	void siTieneElTiempoMaximoParaEntrenar() {
		Maratonista m = new Maratonista("Cuenta con 10 horas de tiempo libre");
		m.setHorasDiariasDisponibleParaEntrenar(10);
		assertTrue(m.maximoTiempoParaEntrenar());
	}
	
	/*	Prueba de correConVentaja(), que devuelve true si:
	 * 	- El maratonista devuelve true en maximoTiempoParaEntrenar()
	 * 	- El maratonista cuenta con contactos (devuelve true)
	 */
	
	@Test
	void noCorreConVentajaPorqueNoCumpleConNingunaCondicion() {
		Maratonista m = new Maratonista("Ni tiempo ni contactos");
		m.setHorasDiariasDisponibleParaEntrenar(8);
		m.setContactos(false);
		assertFalse(m.correConVentaja());
	}
	
	@Test
	void noCorreConVentajaPorqueNoTieneContactos() {
		Maratonista m = new Maratonista("Con tiempo, sin contactos");
		m.setHorasDiariasDisponibleParaEntrenar(10);
		m.setContactos(false);
		assertFalse(m.correConVentaja());
	}
	
	@Test
	void noCorreConVentajaPorqueNoTieneElTiempoMaximo() {
		Maratonista m = new Maratonista("Sin tiempo, con contactos");
		m.setHorasDiariasDisponibleParaEntrenar(8);
		m.setContactos(true);
		assertFalse(m.correConVentaja());
	}
	
	@Test
	void correConVentajaAlCumplirAmbasCondiciones() {
		Maratonista m = new Maratonista("Con tiempo y contactos");
		m.setHorasDiariasDisponibleParaEntrenar(10);
		m.setContactos(true);
		assertTrue(m.correConVentaja());
	}
}
