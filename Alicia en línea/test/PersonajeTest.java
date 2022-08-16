import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonajeTest {

	/* Prueba de embellecer(), que hace dos cosas al personaje:
	 *	1) A�adirle al nivel de locura una cantidad especificada por el usuario
	 *	2) Reduce la cantidad de secretos en 10 unidades
	 */
	
	@Test
	void elNiveldeLocuraAlEmbellecerEsCorrecto() {
		Personaje p = new Personaje("Locura en 0, ser� 10 al terminar");
		p.embellecer(10);
		assertEquals(10, p.getLocura());
	}
	
	@Test
	void LosSecretosAlEmbellecerSonCorrectos() {
		Personaje p = new Personaje("45 secretos, ser�n 35 al terminar");
		p.setSecretos(45);
		p.embellecer(10);
		assertEquals(35, p.getSecretos());
	}
	
	/* Prueba de EstaEnMaravilla(), en donde las condiciones son:
	 *	1) La ubicaci�n del personaje debe ser menor a 0.
	 */
	
	@Test
	void noEstaEnMaravilla() {
		Personaje p = new Personaje("Ubicaci�n mayor a 0");
		p.setUbicaci�n(100);
		assertFalse( p.estaEnMaravilla());
	}
	
	@Test
	void noEstaEnMaravillaPorqueLaUbicacionEs0() {
		Personaje p = new Personaje("Su ubicaci�n es 0");
		p.setUbicaci�n(0);
		assertFalse(p.estaEnMaravilla());
	}
	
	@Test
	void estaEnMaravilla() {
		Personaje p = new Personaje("En maravilla");
		p.setUbicaci�n(-100);
		assertTrue(p.estaEnMaravilla());
	}
	
	/* Prueba de EsLindo(), en donde las condiciones son:
	 *	1) La locura del personaje debe ser mayor al 75% de maximoLocura
	 *	2) El personaje debe estar en Maravilla.
	 */
	
	@Test
	void noEsLindoPorqueNoTieneSuficienteLocura() {
		Personaje p = new Personaje("Est� en maravilla, le falta locura");
		p.setLocura(50);
		p.setUbicaci�n(-1);
		assertFalse(p.esLindo());
	}
	
	@Test
	void noEsLindoPorqueNoEstaEnMaravilla() {
		Personaje p = new Personaje("Suficiente locura, no est� en maravilla");
		p.setLocura(80);
		p.setUbicaci�n(1);
		assertFalse(p.esLindo());
	}
	
	@Test
	void noEsLindoPorqueNoCumpleNingunaCondicion() {
		Personaje p = new Personaje("Ni suficientemente loco ni en maravilla");
		p.setLocura(50);
		p.setUbicaci�n(10);
		assertFalse(p.esLindo());
	}
	
	@Test
	void noEsLindoPorqueEstaAlBorde() {
		Personaje p = new Personaje("75 de locura y ubicaci�n en 0");
		p.setLocura(75);
		p.setUbicaci�n(0);
		assertFalse(p.esLindo());
	}
	
	@Test
	void esLindoPorqueCumpleConAmbasCondiciones() {
		Personaje p = new Personaje("Lindo");
		p.setLocura(95);
		p.setUbicaci�n(-50);
		assertTrue(p.esLindo());
	}
	
	/* Prueba de EsNormal(), en donde las condiciones son:
	*	1) La locura del personaje debe ser menor al 10% de maximoLocura
	*	2) La cantidad de secretos que guarda el personaje debe ser mayor o igual a 500
	*/
	
	@Test
	void noEsNormalPorqueSusSecretosSonMenoresA500() {
		Personaje p = new Personaje("Le faltan secretos");
		p.setLocura(5);
		p.setSecretos(480);
		assertFalse(p.esNormal());
	}
	
	@Test
	void noEsNormalPorqueNoCumpleNingunaCondicion() {
		Personaje p = new Personaje("Mucha locura y pocos secretos");
		p.setLocura(12);
		p.setSecretos(480);
		assertFalse(p.esNormal());
	}
	
	@Test
	void noEsNormalPorqueSuLocuraEsMayorAl10PorCiento() {
		Personaje p = new Personaje("Mucha locura");
		p.setLocura(12);
		p.setSecretos(510);
		assertFalse(p.esNormal());
	}
	
	@Test
	void noEsNormalPorqueSuLocuraEsIgualAl10PorCiento() {
		Personaje p = new Personaje("Locura exactamente en 10");
		p.setLocura(10);
		p.setSecretos(500);
		assertFalse(p.esNormal());
	}
	
	@Test
	void esNormalPorqueCumpleConAmbasCondiciones() {
		Personaje p = new Personaje("Normal");
		p.setLocura(8);
		p.setSecretos(520);
		assertTrue(p.esNormal());
	}

}
