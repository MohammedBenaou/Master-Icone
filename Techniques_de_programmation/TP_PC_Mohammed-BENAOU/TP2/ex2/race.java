// voir le compte rendu //
// TP2_Programation_concurente_Mohammed_BENAOU
import concurrent.*;
class race {
    public static int amount = 100 ;
    public static void main (String[] args) {

        Thread p1 = new Thread(new P1 ()) ;
        Thread p2 = new Thread(new P2 ()) ;
        Thread display = new Thread (new Display());

        p1.start () ;
        p2.start () ;
        display.start();
    }
} 

class P1 implements Runnable {
    public void run ()  {
    synchronized (race.class){ // verouiller l'objet
    Time.delay(RandomGenerator.integer(0,20));
    int temp = race.amount;
    System.out.println ("P1: Load");
    Time.delay(RandomGenerator.integer(0,10));
    temp = temp + 100;
    System.out.println ("P1: Increment");
    Time.delay(RandomGenerator.integer(0,10));
    race.amount = temp;
    System.out.println ("P1: Store");
    }
}
}

class P2 implements Runnable {
    public void run ()  {
    synchronized (race.class){ // verouiller l'objet
    Time.delay(RandomGenerator.integer(0,10));
    int temp = race.amount;
    System.out.println ("P2: Load");
    Time.delay(RandomGenerator.integer(0,10));
    temp = temp +200;
    System.out.println ("P2: Increment");
    Time.delay(RandomGenerator.integer(0,10));
    race.amount = temp;
    System.out.println ("P2: Store");
    }
}
}


class Display implements Runnable {
 public void run () {
   Time.delay (150);
   System.out.println ("amount = " + race.amount);
    }
}


