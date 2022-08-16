import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LocalTest {

	@Test
	void noEsEsencial() {
		Local l = new Local();
		l.setRubro("Jugueter�a");
		assertFalse(l.esEsencial());
	}
	
	@Test
	void esEsencialPorqueEsDeAlimentacion() {
		Local l = new Local();
		l.setRubro("Alimentaci�n");
		assertFalse(l.esEsencial());
	}

}
