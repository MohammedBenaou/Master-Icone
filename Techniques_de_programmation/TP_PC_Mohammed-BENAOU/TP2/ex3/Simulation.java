import java.util.ArrayList;
import java.util.List;

public class Simulation{
    public static void main(String[] args){
        VoieUnique voie = new VoieUnique();
        List<Thread> vehicules = new ArrayList<Thread>();
        Thread unVehicule = null;

        try{
            for(int i = 0; i < 100; i++){
                if(Math.random() < 0.5){
                    unVehicule = new VehiculeSud(i, voie);
                }
                else{
                	unVehicule = new VehiculeNord(i, voie);
                }
                vehicules.add(unVehicule);
                unVehicule.start();
                Thread.sleep((int) (Math.random() * 1500));
            }
            for(int i = 0; i < 100; i++){
                vehicules.get(i).join();
            }
        }
        catch(InterruptedException e){
        	System.out.println(e.getMessage());
        }
    }
}