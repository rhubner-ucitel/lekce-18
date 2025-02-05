package cz.robotdreams.java.lekce18;

public class VlaknoDedenim extends Thread {

    /**
     * Prekryjeme konstruktor, ktery nam dovoli pojmenovat vlakno.
     * @param name jmeno vlakna
     */
    public VlaknoDedenim(String name) {
        super(name);
    }

    @Override
    public void run() {
        Util.cekej(100);
        System.out.println("Tento text byl vypsan z noveho vlakna.");
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Vyvarin instanci vlakna.");
        VlaknoDedenim vlaknoDedenim = new VlaknoDedenim("Pojmenovani vlakna");
        System.out.println("Instance vlakna vytvorena, zahajuji spousteni.");
        vlaknoDedenim.start();   //!!!!! Pozor, vlakno se spusti metodou .start().
                            //  Pokud bychom zavolali prekrytou metou .run(), program by bezel v aktualnim vlakne
        System.out.println("Vlakno spusteno, cekam na jeho konec");
        vlaknoDedenim.join(); // Pockame na vlakno az skonci a pote skoncime.
        System.out.println("Vlakno ukonceno, take koncim.");

    }
}
