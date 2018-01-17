import java.util.Random;
class TestTab {
public static void main (String arg[]) throws Exception {
int a = Integer.parseInt(arg[0]);
int [] tab; 
String [] tab2;
tab2= new String[a];/* d´eclaration d’un tableau d’entiers */
tab=new int[a]; /* allocation m´emoire d’un tableau de 12 cases */
int b=0;
for (int i=0; i<tab.length; i++)
tab[i] = random(b,a); /* initialisation de chaque case `a 0 */
for (int i=0; i<tab.length; i++) // tab.lenght contient toujours la valeur 12
 System.out.print(tab[i]+"-");/* affichage du tableau */
for(int i=0;i<tab2.length;i++){
	tab2[i]="toto";
	System.out.println(tab2[i]+"-");
}
}
public static int random(int min , int max){
	Random rand= new Random();
 	int randomNum = rand.nextInt((max - min) + 1) + min;
 	return randomNum;
}
}