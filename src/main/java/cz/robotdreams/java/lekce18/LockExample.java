package cz.robotdreams.java.lekce18;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService ec = Executors.newFixedThreadPool(2);

        final Lock lock = new ReentrantLock();

        Runnable dlouhyVypocet = () -> {
            lock.lock();
            try {
                Util.sout("Dlouhy vypocet");
                Util.cekej(1500);
                Util.sout("Vypocet hotov");
            } finally {
                lock.unlock(); // Vzdy uvolnit lock ve finally sekci.
            }
        };

        ec.execute(dlouhyVypocet);
        ec.execute(dlouhyVypocet);
        ec.execute(dlouhyVypocet);

        ec.shutdown();

    }


}
