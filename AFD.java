import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
/*
Utilice esta clase para guardar la informacion de su
AFD. NO DEBE CAMBIAR LOS NOMBRES DE LA CLASE NI DE LOS 
METODOS que ya existen, sin embargo, usted es libre de 
agregar los campos y metodos que desee.
*/

public class AFD{
	private String estados;
	private String[] finales;
	private String[] lenguaje;
	private ArrayList<String> caracteres;
	private ArrayList<String> transiciones;
	private ArrayList<ArrayList> listado;
	static int estadoIni = 1;
	/*
		Implemente el constructor de la clase AFD
		que recibe como argumento un string que 
		representa el path del archivo que contiene
		la informacion del afd (i.e. "Documentos/archivo.afd").
		Puede utilizar la estructura de datos que desee
	*/
	public AFD(String path){
		//System.out.println("Aqui empieza");
		File file = new File(path);
		try {
			Scanner scanner = new Scanner(file);
			estados = scanner.nextLine();
			finales = scanner.nextLine().split(",");
			lenguaje = scanner.nextLine().split(",");
			caracteres = new ArrayList<String>();
			for (int j = 0; j < lenguaje.length; j++) {
				caracteres.add(lenguaje[j]);
			}
			listado = new ArrayList<ArrayList>();
			while (scanner.hasNextLine()) {
				transiciones = new ArrayList<String>();
				String[] trans1 = scanner.nextLine().split(",");
				for (int k = 0; k < trans1.length; k++) {
					transiciones.add(trans1[k]);
				}
				listado.add(transiciones);
			}
			scanner.close();
			
		} catch (FileNotFoundException s) {
			s.printStackTrace();
		}
		
	}

	/*
		Implemente el metodo transition, que recibe de argumento
		un entero que representa el estado actual del AFD y un
		caracter que representa el simbolo a consumir, y devuelve 
		un entero que representa el siguiente estado
	*/
	public int getTransition(int currentState, char symbol){
		//Apartir de aqui comienza un ciclo para encontrar la posicion del caracter	 
		int c = 0;
		int posicion = 0;
		for(String caracter : caracteres){
			if (String.valueOf(symbol).equals(caracter)) {
				posicion = c;
			}
			c = c + 1;
		}
		// Con esto podemos hacer el getTransition()
		String state = listado.get(posicion).get(currentState).toString();
		int newTran = Integer.parseInt(state);
		return newTran;
	}


	/*
		Implemente el metodo evaluate, que recibe como argumento
		un String que representa la cuerda a evaluar, y devuelve
		un boolean dependiendo de si la cuerda es aceptada o no 
		por el afd
	*/
	public boolean evaluate(String string){
		String cuerda = string;
		boolean aceptada = false;
		if (cuerda.length() != 0) {
			char elemento = cuerda.charAt(0);
			System.out.println("Evaluate estado inicial: " + estadoIni);
			estadoIni = getTransition(estadoIni, elemento);
			String siguiente = cuerda.substring(1);
			evaluate(siguiente);
		}
		
		if (isFinal(estadoIni)) {
			aceptada = true;
		} else {
			aceptada = false;
		}
		return aceptada;
	}

	/*
		Implemente el metodo evaluate_many, que recibe como argumento
		un arreglo de Strings que representa las cuerda a evaluar, y devuelve
		un arreglo booleans dependiendo de si cada cuerda es aceptada o no 
		por el afd
	*/
	public boolean[] evaluateMany(String[] strings){
		boolean result;
		boolean[] resultado = new boolean[strings.length];
		for (int i = 0; i < strings.length; i ++) {
			estadoIni = 1;
			System.out.println("Evaluando cuerda: " + i);
			result = evaluate(strings[i]);
			resultado[i] = result;
		}
		return resultado;
	}

	/*
		Implemente el metodo isFinal, que devuelve true si el estado enviado
		es un estado final, y false si no lo es
	*/
	public boolean isFinal(int currentState){
		//return false;
		boolean salida = false; 
		ArrayList<Integer> fin = new ArrayList<Integer>();
		for (int k = 0; k < finales.length; k++) {
			fin.add(Integer.parseInt(finales[k]));
		}
		if (fin.contains(currentState)) {
			salida = true;
		}
		return salida;
	}
}