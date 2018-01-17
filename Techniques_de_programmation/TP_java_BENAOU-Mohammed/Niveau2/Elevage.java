import java.util.*;
class Elevage {
public static void main (String [] arg) {
/*List <Lapin> lap = new ArrayList<>();
for(int i=1;i<101;i++){
lap.add(new Lapin());
}

for(Lapin l : lap)
	l.regarder();*/
	// int [] rand = new int [100]; 


	// ajouter les objets crée à un tableau d'objets 
	Lapin [] tab = new Lapin[100];
	for (int i=0;i<50;i++){
		Lapin p = new Lapin();
		tab[i]=p;
		int r =p.random(0,1); // random de 0 et 1 
		  if(r==1)
			p.regarder(); // si le rand egal à 0 alors c'est l'affichage
		else
			p.passeALaCasserole();	// si non passer à la casserole
	       }
		
		}
	}
