
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
/* Clase para los intereses, permite hacer todos los calculos relacionados al
 * posible interes que tenga una cuenta corriente
 */
public class Interes implements Serializable{
	// La cantidad exacta de sobregiro, expresada en numeros de punto flotante positivos
	private float sobregiro = 0;
	// La fecha del comienzo del sobregiro, el punto de partida del calculo de interes
	private LocalDate fecha;
	// Sirve para mostrar que hay un interes por cobrar en la cuenta
	private boolean vigente = false;
	
	public Interes() {
	}
	
	public void finalizarInteres() {
		// Se inicializan todos los valores de nuevo, hasta que haya otro sobregiro
		setSobregiro(0);
		setVigente(false);
		setFecha(null);
	}
	
	public void nuevoInteres(float deuda) {
		// Para registrar intereses de manera rapida
		// El sobregiro es el monto negativo
		setSobregiro(deuda);
		setVigente(true);
		setFecha(LocalDate.now());
	}
	
	public float calcularInteres() {
		// Calculo de los dias entre el comienzo del sobregiro y la fecha actual
		long difDias = ChronoUnit.DAYS.between(getFecha(), LocalDate.now());
		// Se divide la tasa anual de 1% por 360
		float tasa = (float) (0.01 / 360);
		// Capital final = Capital inicial * (1 + Tasa de interes) ^ Cantidad de períodos
		return (float) (getSobregiro() * Math.pow(1 + tasa, difDias));
	}

	public float getSobregiro() {
		return sobregiro;
	}

	public void setSobregiro(float sobregiro) {
		this.sobregiro = sobregiro;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public boolean getVigente() {
		return vigente;
	}

	public void setVigente(boolean vigente) {
		this.vigente = vigente;
	}
}
