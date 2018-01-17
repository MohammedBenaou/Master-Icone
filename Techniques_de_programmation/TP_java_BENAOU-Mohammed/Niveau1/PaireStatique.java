//import java.util.Scanner;
class PaireStatique {
	public static void main (String arg[]){
    /*System.out.println("entrer le premier nombre");
    Scanner sc = new Scanner (System.in);
	int a = sc.nextInt();
	System.out.println("entrer le deuxième nombre");
	int b =sc.nextInt();
	System.out.println("le max de deux nombre est : "+max(a,b));
	}*/
	String  choix = arg[0].toString();
	char [] opr=choix.toCharArray();
	double a = Integer.parseInt(arg[1]);
	double b = Integer.parseInt(arg[2]);
    // test si l'ytilisateur comment par - t
	if(opr[0] =='-'){
		for (char c : opr){
			if(c !='-')
                choix_operation(c,a,b);		
		}
	}
}
// fonction qui permet au utilisateur de choisir l'operation qui veux
	public static void choix_operation(char c ,double  a,  double b){
		if (c =='m')
			System.out.println("le max de deux nombre est : "+max(a,b));
		else{
			 if(c =='e')
			System.out.println(a+" à la puissance de "+b+" = "+exp(a,b));
		else {
			if(c =='d')
			System.out.println("the division is : " +divise(a,b));	
		}
	  }  
	}
	public static double max(double a, double b){		
		if (a<b)
			return b;
			return a;
	}
	public static double exp(double a,double b){
		double exp = Math.pow(a,b);
		return exp;
	}
	public static boolean divise (double a , double b){
		if (a%b!=0)
			return false;
			return true;
	} 
}