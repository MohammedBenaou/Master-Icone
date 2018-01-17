class Matrice {
	public static void main(String arg[]){
		// le nombre de lignes et de colonnes passer en paramètre
		int n = Integer.parseInt(arg[0]);
		int [][] matrice ;
		matrice = new int [n][n];
		for (int i=0;i<matrice.length;i++){
			for (int j=0;j<matrice.length;j++){
				matrice[i][j]=n;
				System.out.print(matrice[i][j]);
			}
			System.out.print("\n");
		}
	}
}