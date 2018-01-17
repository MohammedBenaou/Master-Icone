class Calculatrice{
	public static void main (String arg[]){
		int a = Integer.parseInt(arg[0]);
		int b = Integer.parseInt(arg[1]);
		char op = arg[2].charAt(0);

		//if (op.comperTo((character)'+') == 0 ){
			switch (op){
				case '+':
			int add=a+b;
			System.out.println(a+"+"+b+"="+add);
			break;
			
				case '-': 
				int sous=a-b;
				System.out.println(a+"-"+b+"="+sous);
				break;
			
				case '*':
				int mult=a*b;
				System.out.println(a+"*"+b+"="+mult);
				break;

				case '/': 
				int div=a/b;
				System.out.println(a+"/"+b+"="+div);
				break;
		}
	}
}