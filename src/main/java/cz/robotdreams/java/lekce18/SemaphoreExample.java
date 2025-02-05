package cz.robotdreams.java.lekce18;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    public static void main(String[] args) {
        ExecutorService ec = Executors.newFixedThreadPool(30);

        final Semaphore s = new Semaphore(3);

        Runnable pomalaOperace = () -> {

            try {
                s.acquire(); //Muze vyhodit vyjimku InterruptedException

                Util.sout("Zacinam vypocet");
                Util.cekej(2500);
                Util.sout("Vypocet dokoncen");
            }catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                s.release();
            }
        };

        ec.execute(pomalaOperace);
        ec.execute(pomalaOperace);
        ec.execute(pomalaOperace);
        ec.execute(pomalaOperace);
        ec.execute(pomalaOperace);
        ec.execute(pomalaOperace);
        ec.execute(pomalaOperace);

        ec.shutdown();

    }



}
