class TestCourbe{
	public static void main (String arg[]){
		Courbe c = new Courbe(); 
		// affichage de la fonction equation 
		System.out.println("L'image est "+c.equation(2));
		c.remplir(1,10);
	}
}