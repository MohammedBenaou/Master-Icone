class suite{
	public static void main (String arg[]){
     	int [] res;
     	res = new int[11];
     	for (int i=1;i<res.length;i++){
            res[0] =15;
            res[i] =res[i-1]*3+2; 
            System.out.println(res[i]);
     	}	
     	
	}
}