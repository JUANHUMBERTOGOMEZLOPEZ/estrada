import java.util.Scanner;
import java.util.Stack;
import java.util.*;

public class posfijo
{
	String [] array;
	Stack<String> pila = new Stack<> ();
	StringBuilder var = new StringBuilder();
	public void automata (String a) {
		array = a.split(" ");
		
		for (int i = 0;i<array.length;i++){
			char aux = array[i].charAt(0);


			if (Character.isLetterOrDigit(aux)) {
				var.append(array[i]);
			}
			else {
				while (!pila.isEmpty() && 
					jerarquia (pila.lastElement()) <=
					jerarquia (array[i])){ var.append(pila.pop());
					}
					pila.push(array[i]);

				

			}
		}

		while (!pila.isEmpty()){
			var.append(pila.pop());

		}
		System.out.println(var.toString());
		
	}

	public int jerarquia (String j){
		int orden = 0; 
		if (j.equals("*")||j.equals("/")){
			orden = 1; 
			}
		else if (j.equals("+")||j.equals("-")){
			orden = 2; 
			}

		else if (j.equals("=")){
			orden = 3; 
			}
		return orden;
	}

public static void main(String[] args) {

 System.out.println("inserte la operacion a convertir a posfijo");
 Scanner s = new Scanner(System.in);
 String e = s.nextLine();
 System.out.println(e);

posfijo p = new posfijo ();
p.automata(e);
}
}