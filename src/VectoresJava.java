/* Rodrigo Valladares Santana L1 
 * Programación de Aplicaciones Interactivas Práctica 3
 * 
 * Clase que devuelve el rango (diferencia entre el valor máximo y el mínimo) de los elementos de un array de núumeros reales. 
 * El array se lee de un fichero cuyo nombre se pasa por línea de comandos al ejecutar el programa.
 * 
 * */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class VectoresJava {
	
	ArrayList<Integer> array = new ArrayList<Integer>();
	
	VectoresJava(String nombreFichero) {
		try {
			Scanner scanner = new Scanner(new File(nombreFichero));
			while(scanner.hasNextInt())
				array.add(scanner.nextInt());
			scanner.close();
		}
		catch(FileNotFoundException fnfe) {
			System.out.println("Fichero no encontrado");
	    }

	}
	
	public int rango() {
		int min = 94500, max = 0;
		for(int i = 0; i < array.size(); i++) {
			if(array.get(i) > max)
				max = array.get(i);
			if(array.get(i) < min)
				min = array.get(i);
		}
		return max - min;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		try {
			VectoresJava objeto = new VectoresJava(args[0]);
			System.out.println(objeto.rango());
		}
		catch(ArrayIndexOutOfBoundsException aioobe) {
			System.out.println("No se ha dado un nombre de fichero.");
		}

	}

}
