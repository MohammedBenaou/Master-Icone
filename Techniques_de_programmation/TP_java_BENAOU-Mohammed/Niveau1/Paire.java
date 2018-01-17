class Paire {
/* champs ou variables d’instance */
private int a;
private int b;
/* constructeur */
Paire(int x, int y) {
this.a = x;
this.b = y;
} 
// constructeur sans paramètre
Paire (){
	// initialisation des variables avec zéro
	a=0;
	b=0;
}
/* methode d’affichage */
public void afficher() {
System.out.println("champs a: "+this.a+" -champs b: "+this.b);
}
public String toString(){
	return "champs a: "+this.a+" -champs b: "+this.b;
}
// la methode max qui retourn le max de deux entiers  
public void max (int a, int b){
if (a>b)
 System.out.println("la valuer maximale est : "+a);
 	else
 System.out.println("la valuer maximale est : "+a);
}
// la methode exp a à la puissance de b  
public void exp(int a, int b){
int val=1;
for (int i=1;i<=b;i++){
	val*=a;
		}
		System.out.println(a+" à la puissance de "+b+" est "+val);
}
// fonction de division 
public void div(int a , int b ){
	if (a%b!=0){ // test si le reste de division est null
		System.out.println("division imposible ");
	 }else 
		System.out.println("le resultat de la division est "+(a/b));
}
}