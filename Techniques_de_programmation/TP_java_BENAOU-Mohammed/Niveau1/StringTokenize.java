import java.util.*; 
class Phrase {
public static void main (String arg[]) {
String phrase = "Bonne initiation `a Java.";
StringTokenizer st = new StringTokenizer(phrase);
//String lexeme; // on a plus besoin d'elle
int nbmots=st.countTokens();
int nbcar=0;
while (st.hasMoreTokens()) {
//lexeme=st.nextToken();
nbcar+=phrase.length();// on peut directement mettre phrase.length()
}
System.out.println(nbmots+" mots - "+nbcar+" caracteres");
}
}