
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// Se crea el banco
		Banco b = new Banco();
		// Se lee la informacion del archivo "banco.txt" si este existe
		if(archivoExiste()) {
			b = leerArchivo();
		}
		// Se actualizan los limites de retiro diario y retiro mensual
		b.actualizarDatos();
		// Se activa el menu
		menuPrincipal(b);
	}
	
	private static Banco menuPrincipal(Banco b) {
		/* Todos los menu multieleccion tienen la misma logica para evitar fallos
		 * relacionados a la entrada de usuario y garantizar que no se escape del
		 * menu accidentalmente, consiste de un booleano para asegurar que el
		 * bucle no se rompa (activado solo cuando se elige salir) y un do-while.
		 * Este menu permite asociar un nuevo cliente o entrar a una cuenta de
		 * cliente ya existente.
		 */
		boolean romperBucle = false;
		
		do {
			String tit1 = "Bienvenido al sistema de Banco Provincia";
			ArrayList<String> as = new ArrayList<>();
			as.add("Asociar cliente");
			as.add("Login");
			// Leer comentarios en el metodo
			imprimirLista(tit1, as);
			int elec = pedirInt("su eleccion");
			/* El switch permite que el bucle se mantenga al actualizar el
			*  valor de romperBucle en negativo al menos que se elija salir.
			*/
			switch(elec) {
			case 1:
				// Va a la interfaz de creacion de cliente
				b = asociacionCliente(b);
				romperBucle = false;
				break;
			case 2:
				// Va al menu de un cliente en especifico
				b = menuCliente(b);
				romperBucle = false;
				break;
			case 3:
				romperBucle = true;
				break;
			default:
				romperBucle = false;
			}
		} while(!romperBucle);
		// Al salir, actualiza el ultimo acceso a la fecha actual y guarda la informacion
		b.actualizarUltimoAcceso();
		guardarAArchivo(b);
		sc.close();
		return b;
	}
	
	private static Banco asociacionCliente(Banco b) {
		// Interfaz de soporte para el metodo Banco.asociarCliente()
		int dni = pedirInt("su DNI");
		String nombre = pedirString("nombre");
		String apellido = pedirString("apellido");
		String telefono = pedirString("n° de telefono");
		boolean exitoso = b.asociarCliente(new Cliente(dni, nombre, apellido, telefono));
		if(exitoso) {
			System.out.println("Cliente asociado con exito");
		} else {
			System.out.println("Ya existe un cliente con ese DNI");;
		}
		return b;
	}
	
	private static Banco menuCliente(Banco b) {
		/* Menu de cliente, permite abrir una cuenta o entrar al menu
		 * en donde se elige extraer o depositar
		 */
		boolean romperBucle = false;
		int dni = pedirInt("su DNI");
		int indice = -1;
		Cliente elegido = null;
		ArrayList<Cliente> ac = b.getClientes();
		for (Cliente c : ac) {
			if(c.getDni() == dni) {
				elegido = c;
				indice++;
			}
			} 
		if(elegido != null) {
			do {
				ArrayList<String> as = new ArrayList<>();
				as.add("Abrir caja de ahorro");
				as.add("Abrir cuenta corriente");
				as.add("Cerrar cuenta bancaria");
				as.add("Ver cuentas");
				imprimirLista(elegido.nombreCompleto(), as);
				int elec = pedirInt("su eleccion");
				switch(elec) {
				case 1:
					// Crea una cuenta de caja de ahorro
					elegido = agregarCuentaACliente(elegido, 0, "caja de ahorro");
					romperBucle = false;
					break;
				case 2:
					// Crea una cuenta corriente
					elegido = agregarCuentaACliente(elegido, 1, "cuenta corriente");
					romperBucle = false;
					break;
				case 3:
					// Cierra una de las cuentas
					elegido = cerrarCuentaDeCliente(elegido);
					romperBucle = false;
					break;
				case 4:
					// Va al menu de cuentas bancarias
					elegido = menuCuentas(elegido);
					romperBucle = false;
					break;
				case 5:
					romperBucle = true;
					break;
				default:
					romperBucle = false;
				}
				/* Actualiza el arreglo de cuentas para tener la informacion de cliente
				 * actualizada, y guarda al archivo
				 */
				ac.set(indice, elegido);
				b.setClientes(ac);
				guardarAArchivo(b);
			} while(!romperBucle);
		}
		return b;
	}

	private static Cliente menuCuentas(Cliente c) {
		// Permite elegir la cuenta que reciibira cambios en su saldo
		boolean romperBucle = false;
		ArrayList<Cuenta> ad = c.getCuentas();
		Cuenta d = null;
		int elec = 0;
		do {
			imprimirCuentas(c.getCuentas());
			elec = pedirInt("su eleccion") - 1;
			if(elec < ad.size()) {
				// Va al menu de la cuenta elegida, y activa la ruptura del bucle
				d = ad.get(elec);
				d = menuCuentaElegida(d);
				ad.set(elec, d);
				romperBucle = true;
			} else if (elec == ad.size()) {
				// Activa la ruptura del bucle si se elige salir
				romperBucle = true;
			}
		} while(!romperBucle);
		// Actualiza al arreglo de cuentas del cliente
		c.setCuentas(ad);
		return c;
	}
	
	private static Cuenta menuCuentaElegida(Cuenta c) {
		/* Menu de la cuenta elegida por el usuario, permite depositar
		 * y extraer dinero.
		 */
		ArrayList<String> as = new ArrayList<>();
		as.add("Deposito");
		as.add("Extraccion");
		boolean romperBucle = false;
		do {
			imprimirInfoDeCuenta(c);
			imprimirLista("Elija la operacion que desea hacer:", as);
			float monto = 0;
			int clave = 0;
			boolean exito = false;
			int elec = pedirInt("su eleccion");
			/* Llena los datos para la operacion, o sale del bucle para
			* ir al menu anterior
			*/
			switch(elec) {
			case 1:
				monto = pedirFloat("el monto a depositar");
				clave = pedirInt("la clave de esta cuenta");
				exito = c.deposito(monto, clave);
				mensajeExito(exito);
				break;
			case 2:
				monto = pedirFloat("el monto a extraer");
				clave = pedirInt("la clave de esta cuenta");
				exito = c.extraccion(monto, clave);
				mensajeExito(exito);
				break;
			case 3:
				romperBucle = true;
			}
		} while(!romperBucle);
		return c;
	}
	
	// Mensaje de exito/error para las operaciones bancarias
	private static void mensajeExito(boolean exito) {
		if(exito) {
			System.out.println("Operacion realizada con exito");
		} else {
			System.out.println("No se pudo realizar la operacion");
		}
	}
	
	// Muestra el n° de cuenta y saldo en pantalla
	private static void imprimirInfoDeCuenta(Cuenta c) {
		String nCuenta = String.format("%.0f", c.getNumCuenta());
		String saldo = String.format("%.2f", c.getSaldo());
		System.out.println("Numero de cuenta: " + nCuenta);
		System.out.println("Saldo : $" + saldo);
	}
	
	// Confirma que el archivo de guardado existe
	private static boolean archivoExiste() {
		File f = new File("banco.txt");
		if(f.isFile()) {
			return true;
		}
		return false;
	}
	
	// Guarda toda la informacion del banco a un archivo
	private static void guardarAArchivo(Banco b) {
		try {
			FileOutputStream fileOut = new FileOutputStream("banco.txt");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(b);
			objectOut.close();
			System.out.println("Datos guardados exitosamente.");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	// Lee el archivo con la informacion del banco
	private static Banco leerArchivo() {
		Banco b = new Banco();
		try {
			FileInputStream fileIn = new FileInputStream("banco.txt");
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			b = (Banco) objectIn.readObject();
			objectIn.close();
			System.out.println("Datos cargados exitosamente.");
		} catch(Exception e) {
			System.out.println("Los datos no pudieron ser cargados.");
		}
		return b;
	}
	
	// Pide la informacion relevante para agregar una cuenta, y la registra
	private static Cliente agregarCuentaACliente(Cliente c, int tipoCuenta, String nomTipo) {
		int indice = c.getCuentas().size();
		int clave = pedirInt("la clave numerica para esta " + nomTipo);
		c.abrirCuenta(0, clave);
		String numCuenta = String.format("%.0f", c.getCuentas().get(indice).getNumCuenta());
		System.out.println("N° de cuenta: " + numCuenta);
		return c;
	}
	
	// Muestra las cuentas disponibles, y permite elegir una para eliminar
	private static Cliente cerrarCuentaDeCliente(Cliente c) {
		imprimirCuentas(c.getCuentas());
		int elec = pedirInt("el indice de cuenta a eliminar") - 1;
		int cantCuentas = c.getCuentas().size();
		if(elec < cantCuentas) {
			int clave = pedirInt("la clave de esta cuenta");
			c.cerrarCuenta(elec, clave);
		}
		return c;
	}
	
	// Muestra en pantalla una lista de acciones a tomar, la ultima siempre es "salir"
	private static void imprimirLista(String titulo, ArrayList<String> as) {
		System.out.println(titulo);
		int i = 1;
		for(String s : as) {
			System.out.println(i + ".\t " + s);
			i++;
		}
		System.out.println(i + ".\t Salir");
	}
	
	// Muestra en pantalla los numeros de cada cuenta
	private static void imprimirCuentas(ArrayList<Cuenta> ac) {
		System.out.println("Elija la cuenta:");
		int i = 1;
		for(Cuenta c : ac) {
			String nCuenta = String.format("%.0f", c.getNumCuenta());
			System.out.println(i + ".\t " + nCuenta);
			i++;
		}
		System.out.println(i + ".\t Salir");
	}
	
	// Toma un string de la entrada del usuario
	private static String pedirString(String elemento) {
		System.out.println("Ingrese su " + elemento + ":");
		System.out.print("> ");
		String s = System.console().readLine();
		return s;
	}
	
	// Toma la entrada del usuario hasta recibir un int valido
	private static int pedirInt(String s) {
		boolean romperBucle = false;
		int i = 0;
		do {
			try {
				System.out.println("Ingrese " + s + ":");
				System.out.print("> ");
				i = Math.abs(Integer.parseInt(System.console().readLine()));
				romperBucle = true;
			} catch (NumberFormatException e) {
				romperBucle = false;
			}
		} while(!romperBucle);
		return i;
	}
	
	// Toma la entrada del usuario hasta recibir un float valido
	private static float pedirFloat(String s) {
		boolean romperBucle = false;
		float f = 0;
		do {
			try {
				System.out.println("Ingrese " + s + ":");
				System.out.print("> ");
				f = Math.abs(Float.parseFloat(System.console().readLine()));
				romperBucle = true;
			} catch (NumberFormatException e) {
				romperBucle = false;
			}
		} while(!romperBucle);
		return f;
	}
}
