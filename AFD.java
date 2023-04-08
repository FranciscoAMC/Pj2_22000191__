import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;
/*
	Utilice esta clase para guardar la informacion de su
	AFD. NO DEBE CAMBIAR LOS NOMBRES DE LA CLASE NI DE LOS 
	METODOS que ya existen, sin embargo, usted es libre de 
	agregar los campos y metodos que desee.
*/
public class AFD{
	
	/*
		Implemente el constructor de la clase AFD
		que recibe como argumento un string que 
		representa el path del archivo que contiene
		la informacion del afd (i.e. "Documentos/archivo.afd").
		Puede utilizar la estructura de datos que desee
	*/
	public AFD(String path){
		File file = new File(path);
		try {
			Scanner scanner = new Scanner(file);
			String estados = scanner.nextLine();
			String finales = scanner.nextLine();
			String lenguaje = scanner.nextLine();
			String[] trans1 = scanner.nextLine().split(",");
			System.out.println("Lenguaje: " + lenguaje);
			System.out.println("Transiciones primer caracter: " + trans1);
			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
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
		return 0;
		//Si llega a un estado final, la cuerda es acceptada y devuelve true, si no llega es false
	}

	/*
		Implemente el metodo evaluate, que recibe como argumento
		un String que representa la cuerda a evaluar, y devuelve
		un boolean dependiendo de si la cuerda es aceptada o no 
		por el afd
	*/
	public boolean evaluate(String string){
		return false;
	}

	/*
		Implemente el metodo evaluate_many, que recibe como argumento
		un arreglo de Strings que representa las cuerda a evaluar, y devuelve
		un arreglo booleans dependiendo de si cada cuerda es aceptada o no 
		por el afd
	*/
	public boolean[] evaluateMany(String[] strings){
		/*for (int i = 0; i < strings.length; i ++) {
			System.out.println(strings[i]);
		}*/
		return new boolean[0];
	}

	/*
		Implemente el metodo isFinal, que devuelve true si el estado enviado
		es un estado final, y false si no lo es
	*/
	public boolean isFinal(int currentState){
		return true;
	}
}