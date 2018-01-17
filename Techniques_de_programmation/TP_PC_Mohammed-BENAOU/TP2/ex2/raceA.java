// voir le compte rendu //
// TP2_Programation_concurente_Mohammed_BENAOU
import concurrent.*;
class raceA {
    public static void main (String[] args) {
        bankAccount ba = new bankAccount();
        Thread atm = new Thread(new ATM (ba)) ;
        Thread auditor = new Thread(new Auditor (ba)) ;

        atm.start () ;
        auditor.start () ;
    }
}

class ATM implements Runnable {
    private bankAccount ba;

    public ATM(bankAccount ba) {
       this.ba = ba;
    }

    public void run ()  {
       while(true)
       { int account1 = RandomGenerator.integer(0,ba.numberOfAccounts()-1);
         int account2 = RandomGenerator.integer(0,ba.numberOfAccounts()-1);
         ba.withdraw(account1,500);
         ba.deposit(account2,500);
       }
    }
}

class Auditor implements Runnable {
    private bankAccount ba;

    public Auditor(bankAccount ba) {
       this.ba = ba;
    }

    public void run ()  {
       while(true)
       { Time.delay(100);
         ba.totalAssets();
       }
    }
}

class bankAccount {
    private int numberOfAccounts = 10000;
    private int [] savingsAccounts = new int[numberOfAccounts];

    public bankAccount() {
       for (int i=0; i<savingsAccounts.length; i++)
          savingsAccounts[i]=1000;
    }

    public void withdraw(int account, int wd ){
       savingsAccounts[account] = savingsAccounts[account]-wd;
    }

    public void deposit(int account, int d){
       savingsAccounts[account] = savingsAccounts[account]+d;

    }

    public int numberOfAccounts() {
       return savingsAccounts.length;
    }

    public void totalAssets() {
      int total=0;
      for (int i=0; i<savingsAccounts.length; i++)
          total = total +savingsAccounts[i];
       System.out.println("total is " + total);
    }
}
