import java.util.*;
import java.util.Random;
class Courbe{
	boolean courbeOk;
	//List <Point> listP ;   // je vois pas vraiment un changement dans l'affichage 
	
	LinkedList<Point> listP ;
	/// constructeur de la classe courbe
	public Courbe (){
		this.listP= new LinkedList<>(); ;
		this.courbeOk=false;
	}
	public int equation(int x){
		// choix de fonction 
		int f;
		f=2*x+1; 
		return f;
	}
	// la fonction random 
	public void remplir (int xdebut , int xfin){
		Random rand = new Random(); // création de l'objet Random
		int randnum=rand.nextInt((xfin-xdebut)+1)+xdebut;	
		for(int i=1;i<5;i++){
			int y = equation(randnum);
			if(randnum%2!=0) // j'ai ajoutée ce test juste pour moi 
			listP.add(new Point("noir",randnum,y));
			listP.add(new Point("red",randnum,y));
			for(Point  p : listP){ // parcourir la liste 
			System.out.println(p);
			}
			this.courbeOk = true ;
		}
	}
}