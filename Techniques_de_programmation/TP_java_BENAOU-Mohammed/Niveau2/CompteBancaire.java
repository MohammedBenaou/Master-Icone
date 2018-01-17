class CompteBancaire{
	private double solde;
// chaque compte crée le sole sera passer directement à 0
public CompteBancaire (){
	solde = 0;
}
public CompteBancaire(double s){
	this.solde=s;
}
// geters 
public double getsolde(){
 return solde;
}
/*public String getnom(){ // aprés la création de la class client on a plus besoin 
	return nom;
}
public void setnom(String no){
	this.nom=no;
}*/
public void setsonde(int so){
	this.solde=so;
}
public String toString(){
	return "le solde est "+solde+" €";
}

}