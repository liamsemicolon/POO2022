import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class MundoTest {
	
	/* Prueba de hayNormal(), que devuelve true si uno de los personajes en
	 * la lista devuelven true al ejecutar esNormal()
	 */
	
	@Test
	void hayUnNormal() {
		Mundo m = new Mundo();
		Personaje p1 = new Personaje("Normal");
		p1.setLocura(8);
		p1.setSecretos(520);
		p1.setUbicación(52);
		Personaje p2 = new Personaje("No normal");
		p2.setLocura(20);
		p2.setSecretos(23);
		p2.setUbicación(-50);
		m.agregar(p1);
		m.agregar(p2);
		assertTrue(m.hayNormal());
	}
	
	@Test
	void noHayUnNormal() {
		Mundo m = new Mundo();
		Personaje p1 = new Personaje("No normal");
		p1.setLocura(8);
		p1.setSecretos(480);
		p1.setUbicación(52);
		Personaje p2 = new Personaje("Otro no normal", 20, 23, -50);
		p2.setLocura(20);
		p2.setSecretos(23);
		p2.setUbicación(-50);
		m.agregar(p1);
		m.agregar(p2);
		assertFalse(m.hayNormal());
	}
	
	/* Prueba de encontrarLindos(), que devuelve una lista de los personajes
	 * que devuelven true al ejecutar esLindo()
	 */
	
	@Test
	void devuelveLosLindos() {
		Mundo m = new Mundo();
		Personaje p1 = new Personaje("No lindo");
		p1.setLocura(8);
		p1.setSecretos(15);
		p1.setUbicación(0);
		Personaje p2 = new Personaje("Lindo");
		p2.setLocura(80);
		p2.setSecretos(23);
		p2.setUbicación(-50);
		ArrayList<Personaje> resultadoEsperado = new ArrayList<>();
		resultadoEsperado.add(p2);
		m.agregar(p1);
		m.agregar(p2);
		assertEquals(resultadoEsperado, m.encontrarLindos());
	}
	
	@Test
	void noHayNingunLindo() {
		Mundo m = new Mundo();
		Personaje p1 = new Personaje("No lindo");
		p1.setLocura(8);
		p1.setSecretos(15);
		p1.setUbicación(0);
		Personaje p2 = new Personaje("Otro no lindo");
		p2.setLocura(20);
		p2.setSecretos(23);
		p2.setUbicación(50);
		ArrayList<Personaje> resultadoEsperado = new ArrayList<>();
		m.agregar(p1);
		m.agregar(p2);
		assertEquals(resultadoEsperado, m.encontrarLindos());
	}
	
	/* Prueba de cuantosEnMaravilla(), que devuelve una la cantidad de perosnajes
	 * que devuelven true al ejecutar estaEnMaravilla()
	 */
	
	@Test
	void devuelveCantEnMaravilla() {
		Mundo m = new Mundo();
		Personaje p1 = new Personaje("No está en maravilla");
		p1.setLocura(8);
		p1.setSecretos(15);
		p1.setUbicación(54);
		Personaje p2 = new Personaje("Tampoco está en maravilla");
		p2.setLocura(65);
		p2.setSecretos(23);
		p2.setUbicación(52);
		Personaje p3 = new Personaje("Está en maravilla");
		p3.setLocura(85);
		p3.setSecretos(300);
		p3.setUbicación(-62);
		Personaje p4 = new Personaje("También está en maravilla");
		p4.setLocura(70);
		p4.setSecretos(23);
		p4.setUbicación(-150);
		m.agregar(p1);
		m.agregar(p2);
		m.agregar(p3);
		m.agregar(p4);
		assertEquals(2, m.cuantosEnMaravilla());
	}
	
	@Test
	void noHayNadieEnMaravilla() {
		Mundo m = new Mundo();
		Personaje p1 = new Personaje("No está en maravilla");
		p1.setLocura(8);
		p1.setSecretos(15);
		p1.setUbicación(54);
		Personaje p2 = new Personaje("Tampoco está en maravilla");
		p2.setLocura(65);
		p2.setSecretos(23);
		p2.setUbicación(52);
		Personaje p3 = new Personaje("Ni cerca de estar en maravilla");
		p3.setLocura(85);
		p3.setSecretos(300);
		p3.setUbicación(62);
		Personaje p4 = new Personaje("El más alejado de la maravilla");
		p4.setLocura(70);
		p4.setSecretos(23);
		p4.setUbicación(150);
		m.agregar(p1);
		m.agregar(p2);
		m.agregar(p3);
		m.agregar(p4);
		assertEquals(0, m.cuantosEnMaravilla());
	}
	
	/* Prueba de mayorLocura(), que devuelve al primer personaje con mayor
	 * nivel de locura que encuentre
	 */
	
	@Test
	void devuelveAlDeMayorLocura() {
		Mundo m = new Mundo();
		Personaje p1 = new Personaje("Menor locura");
		p1.setLocura(8);
		Personaje p2 = new Personaje("Segunda menor locura");
		p2.setLocura(65);
		Personaje p3 = new Personaje("Mayor locura");
		p3.setLocura(85);
		Personaje p4 = new Personaje("Segunda mayor locura");
		p4.setLocura(70);
		m.agregar(p1);
		m.agregar(p2);
		m.agregar(p3);
		m.agregar(p4);
		assertEquals(p3, m.mayorLocura());
	}
	
	@Test
	void devuelveSoloALaPrimeraMayorLocura() {
		Mundo m = new Mundo();
		Personaje p1 = new Personaje("Menor locura");
		p1.setLocura(8);
		Personaje p2 = new Personaje("Mayor locura");
		p2.setLocura(85);
		Personaje p3 = new Personaje("Otra mayor locura");
		p3.setLocura(85);
		Personaje p4 = new Personaje("Segunda menor locura");
		p4.setLocura(70);
		m.agregar(p1);
		m.agregar(p2);
		m.agregar(p3);
		m.agregar(p4);
		assertEquals(p2, m.mayorLocura());
	}
	
	@Test
	void devuelveAlPrimerPersonajeSiNoHayMayorLocura() {
		Mundo m = new Mundo();
		Personaje p1 = new Personaje("Sin locura");
		p1.setLocura(0);
		Personaje p2 = new Personaje("Sin locura II");
		p2.setLocura(0);
		Personaje p3 = new Personaje("Sin locura III");
		p3.setLocura(0);
		Personaje p4 = new Personaje("Sin locura IV");
		p4.setLocura(0);
		m.agregar(p1);
		m.agregar(p2);
		m.agregar(p3);
		m.agregar(p4);
		assertEquals(p1, m.mayorLocura());
	}
	
	/* Prueba de masLindosQueNormales(), que devuelve true si hay más
	 * personajes lindos que personajes normales
	 */
	
	@Test
	void hayMasLindosQueNormales() {
		Mundo m = new Mundo();
		Personaje p1 = new Personaje("Normal");
		p1.setLocura(0);
		p1.setSecretos(510);
		p1.setUbicación(54);
		Personaje p2 = new Personaje("No normal");
		p2.setLocura(26);
		p2.setSecretos(23);
		p2.setUbicación(52);
		Personaje p3 = new Personaje("Lindo");
		p3.setLocura(85);
		p3.setSecretos(300);
		p3.setUbicación(-62);
		Personaje p4 = new Personaje("Otro lindo");
		p4.setLocura(77);
		p4.setSecretos(23);
		p4.setUbicación(-150);
		m.agregar(p1);
		m.agregar(p2);
		m.agregar(p3);
		m.agregar(p4);
		assertTrue(m.masLindosQueNormales());
	}
	
	@Test
	void hayTantosLindosComoNormales() {
		Mundo m = new Mundo();
		Personaje p1 = new Personaje("Normal");
		p1.setLocura(0);
		p1.setSecretos(510);
		p1.setUbicación(54);
		Personaje p2 = new Personaje("Otro normal");
		p2.setLocura(5);
		p2.setSecretos(520);
		p2.setUbicación(52);
		Personaje p3 = new Personaje("Lindo");
		p3.setLocura(85);
		p3.setSecretos(300);
		p3.setUbicación(-62);
		Personaje p4 = new Personaje("Otro lindo");
		p4.setLocura(77);
		p4.setSecretos(23);
		p4.setUbicación(-150);
		m.agregar(p1);
		m.agregar(p2);
		m.agregar(p3);
		m.agregar(p4);
		assertFalse(m.masLindosQueNormales());
	}
	
	@Test
	void hayMasNormalesQueLindos() {
		Mundo m = new Mundo();
		Personaje p1 = new Personaje("Normal");
		p1.setLocura(0);
		p1.setSecretos(510);
		p1.setUbicación(54);
		Personaje p2 = new Personaje("Otro normal");
		p2.setLocura(5);
		p2.setSecretos(520);
		p2.setUbicación(52);
		Personaje p3 = new Personaje("Lindo");
		p3.setLocura(85);
		p3.setSecretos(300);
		p3.setUbicación(-62);
		Personaje p4 = new Personaje("Tercer normal");
		p4.setLocura(9);
		p4.setSecretos(623);
		p4.setUbicación(150);
		m.agregar(p1);
		m.agregar(p2);
		m.agregar(p3);
		m.agregar(p4);
		assertFalse(m.masLindosQueNormales());
	}
}
