package modelo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class MaratonTest {
	/*	Prueba de lesQueCorrenConVentaja(), que añade a una lista
	 *	a aquellos que devuelven true en correConVentaja()
	 */
	
	@Test
	void nadieCorreConVentaja() {
		Maraton n = new Maraton();
		ArrayList<Maratonista> resultadoEsperado = new ArrayList<>();
		Maratonista m1 = new Maratonista("Ni tiempo ni contactos");
		m1.setHorasDiariasDisponibleParaEntrenar(8);
		m1.setContactos(false);
		Maratonista m2 = new Maratonista("Con tiempo, sin contactos");
		m2.setHorasDiariasDisponibleParaEntrenar(10);
		m2.setContactos(false);
		Maratonista m3 = new Maratonista("Sin tiempo, con contactos");
		m3.setHorasDiariasDisponibleParaEntrenar(8);
		m3.setContactos(true);
		n.inscribir(m1);
		n.inscribir(m2);
		n.inscribir(m3);
		assertEquals(resultadoEsperado, n.lesQueCorrenConVentaja());
	}
	
	@Test
	void unoCorreConVentaja() {
		Maraton n = new Maraton();
		ArrayList<Maratonista> resultadoEsperado = new ArrayList<>();
		Maratonista m1 = new Maratonista("Ni tiempo ni contactos");
		m1.setHorasDiariasDisponibleParaEntrenar(8);
		m1.setContactos(false);
		Maratonista m2 = new Maratonista("Con tiempo, sin contactos");
		m2.setHorasDiariasDisponibleParaEntrenar(10);
		m2.setContactos(false);
		Maratonista m3 = new Maratonista("Sin tiempo, con contactos");
		m3.setHorasDiariasDisponibleParaEntrenar(8);
		m3.setContactos(true);
		Maratonista m4 = new Maratonista("Con tiempo y contactos");
		m4.setHorasDiariasDisponibleParaEntrenar(10);
		m4.setContactos(true);
		n.inscribir(m1);
		n.inscribir(m2);
		n.inscribir(m3);
		n.inscribir(m4);
		resultadoEsperado.add(m4);
		assertEquals(resultadoEsperado, n.lesQueCorrenConVentaja());
	}
	
	@Test
	void todosCorrenConVentaja() {
		Maraton n = new Maraton();
		ArrayList<Maratonista> resultadoEsperado = new ArrayList<>();
		Maratonista m1 = new Maratonista("Corre con ventaja");
		m1.setHorasDiariasDisponibleParaEntrenar(10);
		m1.setContactos(true);
		Maratonista m2 = new Maratonista("También corre con ventaja");
		m2.setHorasDiariasDisponibleParaEntrenar(10);
		m2.setContactos(true);
		Maratonista m3 = new Maratonista("Otre con ventaja");
		m3.setHorasDiariasDisponibleParaEntrenar(10);
		m3.setContactos(true);
		Maratonista m4 = new Maratonista("Aún otre con ventaja");
		m4.setHorasDiariasDisponibleParaEntrenar(10);
		m4.setContactos(true);
		n.inscribir(m1);
		n.inscribir(m2);
		n.inscribir(m3);
		n.inscribir(m4);
		resultadoEsperado.add(m1);
		resultadoEsperado.add(m2);
		resultadoEsperado.add(m3);
		resultadoEsperado.add(m4);
		assertEquals(resultadoEsperado, n.lesQueCorrenConVentaja());
	}
}
