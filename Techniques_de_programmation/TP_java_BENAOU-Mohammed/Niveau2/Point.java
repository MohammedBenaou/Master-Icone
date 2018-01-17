class Point {
	private String couleur;
	private int x;
	private int y;

	//constructeur 
	public Point(String couleur, int x, int y){
		this.couleur=couleur;
		this.x=x;
		this.y=y;
	}
    // geters
	public int getX(){
		return x;
	}
	 public int getY(){
	 	return y;
	}
	
	public  String toString(){
		return "("+x+", "+y+", "+couleur+")";
	}
	// focntion variation 
	public  int variation(Point p){
		return Math.abs(this.y+p.y);

	}
}