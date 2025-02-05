package cz.robotdreams.java.lekce18;

public class VlaknoJoin extends Thread {

    /**
     * Prekryjeme konstruktor, ktery nam dovoli pojmenovat vlakno.
     * @param name jmeno vlakna
     */
    public VlaknoJoin(String name) {
        super(name);
    }

    @Override
    public void run() {
        Util.cekej(5000);
        System.out.println("Tento text byl vypsan z noveho vlakna : " + this.getName());
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Vyvarin instanci vlakna.");
        VlaknoJoin vlaknoDedenim = new VlaknoJoin("Pojmenovani vlakna");
        System.out.println("Instance vlakna vytvorena, zahajuji spousteni.");
        vlaknoDedenim.start();   //!!!!! Pozor, vlakno se spusti metodou .start().
                            //  Pokud bychom zavolali prekrytou metou .run(), program by bezel v aktualnim vlakne
        System.out.println("Vlakno spusteno, cekam na jeho konec");

        while(true) {
            vlaknoDedenim.join(500);
            if (vlaknoDedenim.isAlive()) {
                System.out.println("Vlakno neskoncilo");
            }else {
                System.out.println("Vlakno ukonceno");
                break;
            }
        }
    }
}
