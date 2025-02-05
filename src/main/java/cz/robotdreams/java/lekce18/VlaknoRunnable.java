package cz.robotdreams.java.lekce18;

public class VlaknoRunnable  {

    public static void main(String[] args) throws InterruptedException {
        Runnable blokKoduProVlakno = new Runnable() {
            @Override
            public void run() {
                Util.cekej(5000);
                System.out.println("Tento text byl vypsan z noveho vlakna.");
            }
        };

        System.out.println("Vyvarin instanci vlakna.");
        //Thread vlaknoDedenim = new Thread(blokKoduProVlakno, "VlaknoRunnable");

        Thread vlaknoDedenim = new Thread(() -> {
            Util.cekej(5000);
            System.out.println("Tento text byl vypsan z noveho vlakna.");
        }, "VlaknoRunnable");


        System.out.println("Instance vlakna vytvorena, zahajuji spousteni.");
        vlaknoDedenim.start();   //!!!!! Pozor, vlakno se spusti metodou .start().
                            //  Pokud bychom zavolali prekrytou metou .run(), program by bezel v aktualnim vlakne
        System.out.println("Vlakno spusteno, cekam na jeho konec");
        vlaknoDedenim.join(); // Pockame na vlakno az skonci a pote skoncime.
        System.out.println("Vlakno ukonceno, take koncim.");

    }
}
