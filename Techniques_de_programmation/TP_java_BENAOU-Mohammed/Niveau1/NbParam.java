class NbParam{
public static void main (String arg[]) {
	int a = arg.length;
	if (a==0)
		System.out.println(" pas de parametres");
	else{ 
		if (a==1)
		System.out.println(" un seul parametre");

	else { if (a>1)
		System.out.println(" plusieurs parametres");
       }
   }
}
}