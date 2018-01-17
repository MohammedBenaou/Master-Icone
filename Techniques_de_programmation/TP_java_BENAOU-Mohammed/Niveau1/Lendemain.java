class Lendemain {
	public static void main (String arg[]){
		int jour = Integer.parseInt(arg[0]);
		int mois = Integer.parseInt(arg[1]);
		int annee = Integer.parseInt(arg[2]);
		if (jour>31 || mois>12 || annee>2017 )	
			System.out.println("la date n'est pas valide ");
		else if (mois%2!=0 && jour ==30) 
			System.out.print("la date du lendemain est :1/"+(mois+1)+"/"+annee);
		 else if (mois%2!=0 && jour ==31)
			System.out.print("la date du lendemain est :2/"+(mois+1)+"/"+annee);
		 else if (jour<29 && mois!=2)
			 System.out.print("la date du lendemain est :"+(jour+1)+"/"+mois+"/"+annee);
		 else if (jour==30 && mois==12)	
		 	System.out.print("la date du lendemain est :1/1/"+(annee+1));
		 else if (jour==31 && mois==12)	
		 	System.out.print("la date du lendemain est :2/1/"+(annee+1));




         /*else if (mois%2=0 && jour=30 && mois<12)
   		System.out.print("la date du lendemain est :1/"+mois+1+"/"+annee);	
   		else if (mois%2=0 && jour=31 && mois<12)
   		System.out.print("la date du lendemain est :2/"+mois+1+"/"+annee);
		else if (mois%2=0 && jour=30 && mois=12)
   		System.out.print("la date du lendemain est :1/1/"+annee+1);	
   		else if (mois%2=0 && jour=31 && mois=12)
   		System.out.print("la date du lendemain est :2/1/"+annee+1);
		else (jour>31 || mois>12 || annee>2017 )
		System.out.println("la date n'est pas valide "); */

	}
}