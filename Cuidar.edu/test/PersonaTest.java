import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonaTest {
	/* Prueba de DNIImpar(), que devuelve true si el número de DNI
	 * de la persona es impar.
	 */
	
	@Test
	void laPersonaTieneUnDNIImpar() {
		Persona p = new Persona();
		p.setDni(45152353);
		assertTrue(p.DNIImpar());
	}
	
	@Test
	void laPersonaTieneUnDNIPar() {
		Persona p = new Persona();
		p.setDni(45152352);
		assertFalse(p.DNIImpar());
	}
	
	/* Prueba de estoyBuscandoElVirus(); que devuelve true si la
	 * cantidad de salidas de la persona es mayor a 10.
	 */
	
	@Test
	void laPersonaNoBuscaElVirus() {
		Persona p = new Persona();
		p.setCantSalidas(5);
		assertFalse(p.estoyBuscandoElVirus());
	}
	
	@Test
	void laPersonaEstaAlLimiteDeBuscarElVirus() {
		Persona p = new Persona();
		p.setCantSalidas(10);
		assertFalse(p.estoyBuscandoElVirus());
	}
	
	@Test
	void laPersonaBuscaElVirus() {
		Persona p = new Persona();
		p.setCantSalidas(15);
		assertTrue(p.estoyBuscandoElVirus());
	}
	
	/* Prueba de meAislo(), que devuelve true si la persona
	 * tiene una temperatura mayor a 37.
	 */
	
	@Test
	void laPersonaNoDebeAislarse() {
		Persona p = new Persona();
		p.setTemperatura(35);
		assertFalse(p.meAislo());
	}
	
	@Test
	void laPersonaEstaAlBordeDeAislarse() {
		Persona p = new Persona();
		p.setTemperatura(37);
		assertFalse(p.meAislo());
	}
	
	@Test
	void laPersonaDebeAislarse() {
		Persona p = new Persona();
		p.setTemperatura(38);
		assertTrue(p.meAislo());
	}
	
	/* Prueba de puedoIrAComprarAUnLocalEnTalDía, que devuelve
	 * true si:
	 * 	1) La persona no debe aislarse
	 * 	y
	 * 	2a) El local al que concurre es esencial
	 * 	o
	 * 	2b) El DNI de la persona y el dia evaluado coinciden en ser
	 *  	pares o impares
	 */
	
	@Test
	void noPuedeIrAlLocalPorqueDebeAislarse() {
		int dia = 21;
		Local l = new Local();
		l.setRubro("Alimentación");
		Persona p = new Persona();
		p.setTemperatura(38);
		p.setDni(45106545);
		assertFalse(p.puedoIrAComprarAUnLocalEnTalDía(dia, l));
	}
	
	@Test
	void noPuedeIrAlLocalPorqueElLocalNoEsEsencialYNoCoincidenElDNIYElDia() {
		int dia = 21;
		Local l = new Local();
		l.setRubro("Ferretería");
		Persona p = new Persona();
		p.setTemperatura(35);
		p.setDni(45106546);
		assertFalse(p.puedoIrAComprarAUnLocalEnTalDía(dia, l));
	}
	
	@Test
	void PuedeIrAlLocalPorqueElLocalEsEsencialInclusoSiNoCoincideElDNI() {
		int dia = 21;
		Local l = new Local();
		l.setRubro("Alimentación");
		Persona p = new Persona();
		p.setTemperatura(35);
		p.setDni(45106546);
		assertTrue(p.puedoIrAComprarAUnLocalEnTalDía(dia, l));
	}
	
	@Test
	void PuedeIrAlLocalPorqueElLocalEsEsencialYCoincideElDNI() {
		int dia = 21;
		Local l = new Local();
		l.setRubro("Alimentación");
		Persona p = new Persona();
		p.setTemperatura(35);
		p.setDni(45106545);
		assertTrue(p.puedoIrAComprarAUnLocalEnTalDía(dia, l));
	}
	
	@Test
	void PuedeIrAlLocalPorqueCoincideElDNIInclusoSiElLocalNoEsEsencial() {
		int dia = 21;
		Local l = new Local();
		l.setRubro("Maderera");
		Persona p = new Persona();
		p.setTemperatura(35);
		p.setDni(45106545);
		assertTrue(p.puedoIrAComprarAUnLocalEnTalDía(dia, l));
	}
	
	/* Prueba de salir(), que aumenta la cantidad de salidas por una unidad.
	 */
	
	@Test
	void laCantidadDeSalidasAumentaPor1() {
		Persona p = new Persona();
		p.setCantSalidas(5);
		int resultadoEsperado = 6;
		p.salir();
		assertEquals(resultadoEsperado, p.getCantSalidas());
	}
}
