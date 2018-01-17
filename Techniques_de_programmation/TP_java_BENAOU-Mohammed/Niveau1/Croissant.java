class Croissant{
	public static void main (String arg[]){
           int a = Integer.parseInt(arg[0]);
           int b = Integer.parseInt(arg[1]);
           int c = Integer.parseInt(arg[2]);
           
           if (a<b && a<c && b<c)
           System.out.println(a+"<"+b+"<"+c);
           else if(b<a && b<c && a<c)        
           System.out.println(b+"<"+a+"<"+c);
           else if(c<b && c<a && b<a)
            System.out.println(c+"<"+b+"<"+a);
           else if(c<b && c<a && b<a)
            System.out.println(c+"<"+b+"<"+a);
          else if (a<b && a<c && c<b)
           System.out.println(a+"<"+c+"<"+b);
           else if(b<a && b<c && c<a)        
           System.out.println(b+"<"+c+"<"+a);
           else if(c<b && c<a && b<a)
            System.out.println(c+"<"+a+"<"+b);
           else if(c<b && c<a && a<b)
            System.out.println(c+"<"+a+"<"+b);
           else
            System.out.println("false");
       
    }
}	
     	
