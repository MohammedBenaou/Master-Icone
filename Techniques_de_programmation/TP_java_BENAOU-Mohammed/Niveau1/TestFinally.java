class Ex extends Exception {}
public class TestFinally {
public static void main(String args[]) {
System.out.println("Entre dans le premier bloc try");
try {
System.out.println("Entre dans le second bloc try");
try {
throw new Ex();
}
finally {
System.out.println("finally dans le second bloc try");
}
}
catch(Ex e) {
System.out.println("Capture d’une exception Ex dans le premier bloc try");
}
finally {
System.out.println("finally dans le premier bloc try");
}
}
}