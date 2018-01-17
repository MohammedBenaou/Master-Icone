// voir le compte rendu //
// TP2_Programation_concurente_Mohammed_BENAOU
import java.sql.Time;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Scheduler {

         public static void main (String args[]) {
             TestThread t1, t2, t3;

             t1 = new TestThread ("Thread 1");
             t2 = new TestThread ("Thread 2");
             t3 = new TestThread ("Thread 3");
                t1.start ();
                t2.start ();
                t3.start ();
            }
    }

class TestThread extends Thread {
   String id;
     int count = 1;

     public TestThread (String s) {
           id = s;
     }

     public void run() {
        do {
            System.out.println(id);
            count = count + 1;
            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TestThread.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            Thread.yield();
        }  while (count < 10);

     }
}
