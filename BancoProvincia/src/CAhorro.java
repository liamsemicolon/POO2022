

public class CAhorro extends Cuenta{
	private int cantExtracciones;
	
	CAhorro(double numCuenta, int clave){
		super(numCuenta, clave);
	}
	
	public boolean extraccion(float monto, int clave) {
		monto = Math.abs(monto);
		boolean exito = false;
		float saldoActual = getSaldo();
		float resto = saldoActual - monto;
		if(condicionesDeExtraccion(monto, saldoActual, resto, clave)) { 
			setSaldo(resto);
			actualizarRetiroDiario(monto);
			exito = true;
			}
		return exito;
	}

	private boolean debajoDelLimiteDiario(float monto) {
		return super.debajoDelLimiteDiario(monto, 15000); 
	}
	
	// Reinicia el conteo de extracciones mensuales a 0
	@Override
	public void reiniciarCantExtracciones() {
		setCantExtracciones(0);
	}

	private boolean condicionesDeExtraccion(float monto, float saldoActual, float resto, int clave) {
		/* Se establecen varias condiciones:
		 * 1. Que la clave sea correcta
		 * 2. Que no se haya sobrepasado el limite diario de retiro
		 * 3. Que no se haya sobrepasado el limite mensual de extracciones
		 * 4. Que el saldo actual sea mayor a 0
		 * 5. Que el saldo no quede en numeros negativos
		 */
		return getClave() == clave &&  debajoDelLimiteDiario(monto) && getCantExtracciones() < 10 && saldoActual > 0 && resto >= 0;
	}
	
	public int getCantExtracciones() {
		return cantExtracciones;
	}

	public void setCantExtracciones(int cantExtracciones) {
		this.cantExtracciones = cantExtracciones;
	}
	
}
