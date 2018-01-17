import java.util.Random;
class Lapin {
	boolean vivant;
	private static int max = 50;
	private static int nombre = 0; // variavle statice
public Lapin() {
    System.out.println("Un lapin vient de naitre");
    vivant = true ;
   	nombre++; // incrementation de nombre de lapin crée
    System.out.println("le nombre de lapin vivant est : "+nombre);
}
public void regarder() {
System.out.println("Un lapin court");
}
public void passeALaCasserole() {
this.vivant = false ;
 nombre=nombre-1; // décrementation du nombre de vivant
System.out.println("Un lapin vient de passer a la casserole");
System.out.println("il y a "+nombre+" vivants maintenant" );
}
// la fonction random 
 public int random(int min , int max){
 	Random rand = new Random();
 	int r = rand.nextInt((max - min) + 1) + min;
 	return r;
 }

}