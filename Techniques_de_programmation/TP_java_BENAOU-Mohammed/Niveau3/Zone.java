class Zone {

	public Point a = new Point("noir",2,2);
	public Point b = new Point("noir",4,5);
 	 // fonction contient sert a tracer un rectangle 
 	 //est permet par la suite de tester si le point 
 	 //passer en parametre appartient ou non  
	public boolean contient(Point p){
		if (p.getX()>=a.getX() && p.getX()<=b.getX())
			if(p.getY()>=a.getY() && p.getY()<=b.getY())
				return true;
				return false;
	}
} 