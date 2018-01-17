class TestZone{
	public static void main (String arg[]){
		Zone z = new Zone();
		Point p=new Point("noir",1,1);
		if (z.contient(p))
			System.out.println("appartient à la zone");
		else
			System.out.println("n'appartient pas à la zone");
	}
}