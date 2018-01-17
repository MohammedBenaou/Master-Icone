class ArbreBinaire implements IArbreBinaire {

public ArbreBinaire(){}
public IArbreBinaire donneFg(){
	return new ArbreBinaire();
}
public IArbreBinaire donneFd(){
	return new ArbreBinaire();
}
public void fixeFg(IArbreBinaire fg){

}
public void fixeFd(IArbreBinaire fd){

}
public boolean feuille(){
	return true;
}
public boolean existeFg(){
	return true;
}
public boolean existeFd(){
		return true;
}
public int hauteur(){
	return 0;
}
public int taille(){
	return 0;
}
}