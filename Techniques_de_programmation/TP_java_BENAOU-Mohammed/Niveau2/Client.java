class Client {
private String nom;
private String adresse;
private String tel;
private String compte;

// constructeur de la classe Client 
public Client(String nom,String adresse, String tel,String compte){
	this.nom =nom;
	this.adresse=adresse;
	this.tel=tel;
	this.compte=compte;
}
public String toString(){
   return "les coordonées du Client :\nLe nom : "+nom+"\nL'adresse : "+adresse+"\nLe N°-telephone : "+tel+"\nLe compte(s) : "+compte;
}
}
