import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class AFD{
	private String estados;
	private String[] finales;
	private String[] lenguaje;
	private ArrayList<String> caracteres;
	private ArrayList<String> transiciones;
	private ArrayList<ArrayList> listado;
	static int estadoIni = 1;

	public AFD(String path){
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

	public int getTransition(int currentState, char symbol) {
		int c = 0;
		int posicion = 0;
		for(String caracter : caracteres){
			if (String.valueOf(symbol).equals(caracter)) {
				posicion = c;
			}
			c = c + 1;
		}
		String state = listado.get(posicion).get(currentState).toString();
		int newTran = Integer.parseInt(state);
		return newTran;
	}

	public boolean evaluate(String string){
		String cuerda = string;
		boolean aceptada = false;
		if (cuerda.length() != 0) {
			char elemento = cuerda.charAt(0);
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

	public boolean[] evaluateMany(String[] strings){
		boolean result;
		boolean[] resultado = new boolean[strings.length];
		for (int i = 0; i < strings.length; i ++) {
			estadoIni = 1;
			result = evaluate(strings[i]);
			resultado[i] = result;
		}
		return resultado;
	}

	public boolean isFinal(int currentState){
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