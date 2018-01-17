import java.util.logging.Level;
import java.util.logging.Logger;


public class VehiculeNord extends Thread{
    private int num;
    private VoieUnique voie;
    public int direction;
    
    public VehiculeNord(int num,VoieUnique voie){
        this.num = num;
        this.voie = voie;
        this.direction = 0;
    }
    public void run(){
        try{
            voie.demandePass(this.direction);
        }
        catch(InterruptedException ex){
            Logger.getLogger(VehiculeNord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            VehiculeNord.sleep(1000); //le véhicule devra en ressortir après 1 seconde
        } 
        catch(InterruptedException ex){
            Logger.getLogger(VehiculeNord.class.getName()).log(Level.SEVERE, null, ex);
        }
        voie.sort();
    }
}

