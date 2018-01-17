class TestPoint{
	public static void main (String arg[]){
		Point p = new Point("rouge",12,134);
		System.out.println(p.toString());
		Point p2 = new Point("rouge",5,14);
		System.out.println(p.variation(p2));
	}
}