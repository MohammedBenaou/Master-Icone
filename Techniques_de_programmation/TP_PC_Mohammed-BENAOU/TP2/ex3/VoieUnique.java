public class VoieUnique{

    private int cotePassant;
    private int passant,attent;
    private long time;

    public VoieUnique(){
        cotePassant = 0;
        passant = 0;   // compteur passant
        attent = 0;   // compteur attente
        time = System.currentTimeMillis();
    }

    synchronized public void demandePass(int direction) throws InterruptedException{
        // meme direction que la voiture precedente
        if(direction == cotePassant){
            // Peut passer
            passant++;
            time = System.currentTimeMillis();
            System.out.println("Le nombre de véhicules en cours d’utilisation de la voie : " + passant);

        } 
        // la voiture va dans la direction opposée à la derniere voiture passée mais plus de voiture sur la route
        else if(direction != cotePassant && System.currentTimeMillis() - time > 1000){
            // Peut passer
            passant++;
            cotePassant = direction;
            this.notifyAll();
            passant += attent;
            attent = 0;
            if(cotePassant == 0){
                System.out.println("Le sens: Nord");
            }
            else{
                System.out.println("Le sens : Sud");
            }
            time = System.currentTimeMillis();
            System.out.println("Le nombre de véhicules en cours d’utilisation de la voie : " + passant);
        }
        // la voiture va dans la direction opposée à la derniere voiture mais encore au moins 1 voiture sur la route
        else if(direction != cotePassant && System.currentTimeMillis() - time < 1000){
            // Interdit de passer
            attent++;
            this.wait();
        }
        System.out.println("Le nombre de véhicules en attente : " + attent);
    }

    synchronized public void sort(){
        passant--;
        System.out.println("Le nombre de véhicules en cours d’utilisation de la voie : " + passant);
    }
}
