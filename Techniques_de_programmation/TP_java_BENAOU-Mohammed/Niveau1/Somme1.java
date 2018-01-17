class Somme1{
	public static void  main (String arg[]){
		int b=0;
		for(int i=0;i<arg.length;i++){
			int a = Integer.parseInt(arg[i]);
			b +=a;
		}
		System.out.println("la somme de la suite est "+b);
		int moy=b/arg.length;
		System.out.println("la moyenne est "+moy);
	}
}