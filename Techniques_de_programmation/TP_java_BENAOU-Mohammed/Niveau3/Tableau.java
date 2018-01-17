import java.util.*;
class Tableau {
	CompteBancaire [] tab;
	public static int  max=200;
	public int nb=0;

	public Tableau (){
		this.tab = new CompteBancaire[11]; // test avec 10 cases
		this.nb=0;
	}
	// infecter au tableau les comptes bancaires créés
	public void add(){
		for(int i=1;i<tab.length;i++){
			int solde =100;
			tab[i]=(new CompteBancaire(solde));
			nb++;
			System.out.println("La case N°:"+i+"->"+tab[i]);
		}
		System.out.println("le nombre de case :" +nb);
	}
// fonction delete qui prit en parametre un numero de case à supprimer
	public void delete (int c){
		for (int i=1 ;i<tab.length;i++){
			if(c == i ){
				nb=nb-1;
				for(int j=i+1;j<tab.length;j++){
					tab[j-1]=tab[j];
				}
						for(int k=1;k<tab.length-1;k++){
							System.out.println("La case N°:"+k+"->"+tab[k]);
						}
				System.out.println("La case supprimée est :"+c);
				System.out.println("Le nombre de case :"+nb);
			}
		}
	}
}