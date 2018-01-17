class TestFonctions {
public static void main (String arg[]) {
int entier1=Integer.parseInt(arg[0]);
int entier2=Integer.parseInt(arg[1]);
int m=max(entier1,entier2);
System.out.println("le maximum de "+entier1+" et "+entier2+" est "+m);
}
public static int max (int a, int b) {
int res;
	if (a<b)
		res=b;
	else
		res=a;
	return res;
		
	}	
}