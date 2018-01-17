class TestPaire {
/* champs ou variables d’instance */
public static void main (String arg[]){
	Paire X = new Paire(3,5);
	//Paire Y = new Paire(2,6);
	Paire Y = new Paire(); // instancier l'objet Y au constructeur SP
	X.afficher();
	Y.afficher();
	System.out.println(X.toString());
	X.max(3,5);
	X.exp(4,2);
}
}