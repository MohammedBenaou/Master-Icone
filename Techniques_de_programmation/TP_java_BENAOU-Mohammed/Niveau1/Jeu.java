import java.util.Scanner;
import java.util.Random;
class Jeu {
 public static void main (String arg[]){
 	int  a = Integer.parseInt(arg[0]);
    int min = 0;	
    	random(min,a);

 }
 // fonction random
 public static void random(int min , int max){
 	Random rand= new Random(); // création de l'objet random 
 	int randomNum = rand.nextInt((max - min) + 1) + min; 
 	boolean res ;
 	while(res=true)
 		Scanner sc = new Scanner(System.in); // lecture du clavier 
        int n = sc.nextInt();
        System.out.println(randomNum);
 		if(randomNum==n){ // test si le nombre entrée égal à random
 			System.out.println("Bingo !");
 		    break;}
 		else 
 		randomNum=rand.nextInt((max - min) + 1) + min;
 	}
 
 }

}