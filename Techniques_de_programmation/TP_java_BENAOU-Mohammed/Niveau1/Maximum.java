class Maximum{
	public static void  main (String arg[]){
		int max=0;		
			int a = Integer.parseInt(arg[0]);
			int b = Integer.parseInt(arg[1]);
			if(a>b){
				max=a;
			}else 
			max=b;		
		System.out.println("Le nombre maximal est : "+max);
	}
}