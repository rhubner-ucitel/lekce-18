package cz.robotdreams.java.lekce18;

public class VlaknoInterrupt extends Thread {

    /**
     * Prekryjeme konstruktor, ktery nam dovoli pojmenovat vlakno.
     * @param name jmeno vlakna
     */
    public VlaknoInterrupt(String name) {
        super(name);
    }

    @Override
    public void run() {
        //Util.cekej(5000);
        long soucet = 0;

        for(long i = 0l ; i < 20_000_000_000l ; i++) {
            soucet =+ i;
            if(i % 10_000 == 0 &&  interrupted()) {
                return;
            }
        }


        System.out.println("Tento text byl vypsan z noveho vlakna : " + this.getName());
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Vytvarim instanci vlakna.");
        VlaknoInterrupt vlaknoDedenim = new VlaknoInterrupt("Vlakno1");
        System.out.println("Instance vlakna vytvorena, zahajuji spousteni.");
        vlaknoDedenim.start();   //!!!!! Pozor, vlakno se spusti metodou .start().
                            //  Pokud bychom zavolali prekrytou metou .run(), program by bezel v aktualnim vlakne


        System.out.println("Vlakno spusteno, cekam na jeho konec");

        while(true) {
            vlaknoDedenim.join(500);
            if (vlaknoDedenim.isAlive()) {
                System.out.println("Vlakno neskoncilo behem 500ms, ukoncuji nasilne.");
                vlaknoDedenim.interrupt();
            }else {
                System.out.println("Vlakno ukonceno");
                break;
            }
        }
    }
}
