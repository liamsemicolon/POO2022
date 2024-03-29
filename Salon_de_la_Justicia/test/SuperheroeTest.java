import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SuperheroeTest {

	@Test
	void soloTieneAsistentes() {
		Superheroe s = new Superheroe();
		s.contratar(new Asistente(10000));
		s.contratar(new Asistente(35000));
		s.contratar(new Asistente(20000));
		s.contratar(new Asistente(15000));
		assertEquals(80000, s.totalAPagar());
	}
	
	@Test
	void soloTieneAsistentesCH() {
		Superheroe s = new Superheroe();
		s.contratar(new AsistenteCH(10000));
		s.contratar(new AsistenteCH(35000));
		s.contratar(new AsistenteCH(20000));
		s.contratar(new AsistenteCH(15000));
		assertEquals(96000, s.totalAPagar());
	}

	@Test
	void hayAsistentesYAsistentesCH() {
		Superheroe s = new Superheroe();
		s.contratar(new AsistenteCH(10000));
		s.contratar(new Asistente(35000));
		s.contratar(new AsistenteCH(20000));
		s.contratar(new Asistente(15000));
		assertEquals(86000, s.totalAPagar());
	}
}

/* todo: un caso en el que el superheroe solo tenga asistentes, otro en el que solo tenga
 * asistentes c/h, otro en donde tenga ambos
 */