import java.nio.file.Path;
import java.util.List;
/*
	Utilice esta clase para guardar la informacion de su
	AFD. NO DEBE CAMBIAR LOS NOMBRES DE LA CLASE NI DE LOS 
	METODOS que ya existen, sin embargo, usted es libre de 
	agregar los campos y metodos que desee.
*/
public class AFD{
	int estado;
	String instrucciones;

	
	/*
		Implemente el constructor de la clase AFD
		que recibe como argumento un string que 
		representa el path del archivo que contiene
		la informacion del afd (i.e. "Documentos/archivo.afd").
		Puede utilizar la estructura de datos que desee
	*/
	public AFD(String path){
		instrucciones = path;
		System.out.println(instrucciones);
	}

	/*
		Implemente el metodo transition, que recibe de argumento
		un entero que representa el estado actual del AFD y un
		caracter que representa el simbolo a consumir, y devuelve 
		un entero que representa el siguiente estado
	*/
	public int getTransition(int currentState, char symbol){
		return 0;
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