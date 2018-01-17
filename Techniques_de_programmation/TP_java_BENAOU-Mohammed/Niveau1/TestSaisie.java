//import java.io.*;
import java.util.Scanner;
class TestSaisie {
public static void main (String arg[]) throws Exception {
	try{
	System.out.println("enter un nombre :");
	Scanner sc = new Scanner (System.in);
	int nombre = sc.nextInt();
	int res = nombre * nombre;
	System.out.println("Le carré de "+nombre+" est : "+res);

}catch(Exception e){
	System.out.println("Error de saisine (entrer un nombre entier)");
}
	
}
}