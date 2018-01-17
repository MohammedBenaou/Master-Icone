import java.util.logging.Level;
import java.util.logging.Logger;


public class VehiculeSud extends Thread{
    private int id;
    private VoieUnique voie;
    public int direction;

    public VehiculeSud(int id,VoieUnique voie){
        this.id = id;
        this.voie = voie;
        this.direction = 1;
    }
    
    public void run(){
        try{
            voie.demandePass(this.direction);
        }
        catch(InterruptedException ex){
            Logger.getLogger(VehiculeSud.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            VehiculeSud.sleep(1000);
        }
        catch(InterruptedException ex){
            Logger.getLogger(VehiculeSud.class.getName()).log(Level.SEVERE, null, ex);
        }
        voie.sort();
    }
}
