import java.util.LinkedList;
import java.util.Random;
class TestIntegerList {
public static void main (String arg[]) {
// variable x de type int
int x = 5;
int min =0;
int max =50;
System.out.println("un entier x:" + x);
// instance (ou objet) y de la classe Integer
Integer y = new Integer (5);
System.out.println("un autre entier y:" + y.intValue());
// instance (ou objet) L de la classe LinkedList
//LinkedList L = new LinkedList();
//System.out.println("une liste L:" + L);
//L.add(y);
//System.out.println("la meme liste L:" + L);
LinkedList L = new LinkedList(); // on a créer une lise 
Random rand= new Random(); 
int randomNum = rand.nextInt((max - min) + 1) + min;
int ybis = new Integer(randomNum); // passer le random en paramétre 
L.add(ybis);
System.out.println("la meme liste L:" + L);
}
}