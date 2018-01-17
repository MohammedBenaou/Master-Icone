interface IArbreBinaire 
{
	public IArbreBinaire donneFg();
	public IArbreBinaire donneFd();
	public void fixeFg(IArbreBinaire fg);
	public void fixeFd(IArbreBinaire fd);
	public boolean feuille();
	public boolean existeFg();
	public boolean existeFd();
	public int hauteur();
	public int taille();
}