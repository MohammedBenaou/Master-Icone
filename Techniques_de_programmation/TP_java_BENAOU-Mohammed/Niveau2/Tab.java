import java.util.Scanner;
import java.io.*;
class Tab {
public static void main(String arg[]) throws Exception {
int n = Integer.parseInt(arg[0]);
/* appel de la fonction init qui renvoit le tableau cr´e´e */
int T[] = Tab.init(n);
boolean encore = true;
while (encore) {
/* menu */
System.out.println("");
System.out.println("0- Affichage du tableau");
System.out.println("1- Somme des entiers");
System.out.println("2- Maximum des entiers");
System.out.println("3- Minimum des entiers");
System.out.println("4- Nombre des entiers pairs");
System.out.println("5- Nombre des entiers impairs");
System.out.println("6- Sortir");
System.out.println("");
System.out.print("Entrez votre choix: ");
/* lecture du choix */
Scanner sc = new Scanner(System.in);
int rep = sc.nextInt();
/* traitement du choix */
switch (rep) {
case 0: Tab.afficher(T);
break;
case 1: int s = Tab.somme(T);
System.out.println("La somme est "+s);
break;
case 2: int max = Tab.maximum(T);
System.out.println("Le max est "+max);
break;
case 3: int min = Tab.minimum(T);
System.out.println("Le min est "+min);
break;
case 4: int p = Tab.pair(T);
System.out.println(p+" entiers pairs");
break;
case 5: int i = T.length - Tab.pair(T);
System.out.println(i+" entiers impairs");
break;
case 6: encore = false;
break;
default: System.out.println("Choix non valide");
}
}
}
/* allocation et initialisation d’un tableau */
public static int [] init (int taille) { return null; /* a completer */ }
/* affichage d’un tableau */
public static void afficher (int[] T) { return; /* a completer */ }
/* calcul de la somme des entiers d’un tableau */
public static int somme (int[] T) { return 0; /* a completer */ }
/* calcul du maximum des entiers d’un tableau */
public static int maximum (int[] T) { return 0; /* a completer */ }
/* calcul du minimum des entiers d’un tableau */
public static int minimum (int[] T) { return 0; /* a completer */ }
/* calcul du nombre d’entiers pairs d’un tableau */
public static int pair (int[] T) { return 0; /* a completer */ }
}