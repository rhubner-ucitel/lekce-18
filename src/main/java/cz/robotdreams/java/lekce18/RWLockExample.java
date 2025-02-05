package cz.robotdreams.java.lekce18;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RWLockExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService ec = Executors.newFixedThreadPool(3);

        final List<String> seznam = new ArrayList<>();

        final ReadWriteLock lock = new ReentrantReadWriteLock(true);

        Runnable updateList = () -> {
            lock.writeLock().lock();
            try {
                Util.sout("Zacinam update");
                Util.cekej(1500);
                Util.sout("UpdateHotov");
                seznam.add("polozka");
            } finally {
                lock.writeLock().unlock(); // Vzdy uvolnit lock ve finally sekci.
            }
        };

        Runnable ctiList = () -> {
            lock.readLock().lock();
            try {
                Util.sout("Ctu list");
                Util.cekej(100);
                Util.sout("List obsahuje " + seznam.size() + " elementu");
            }finally {
                lock.readLock().unlock(); // Vzdy uvolnit lock ve finally sekci
            }
        };


        ec.execute(updateList);
        ec.execute(updateList);
        ec.execute(ctiList);
        ec.execute(ctiList);
        ec.execute(ctiList);
        ec.execute(updateList);
        ec.execute(updateList);
        ec.execute(ctiList);
        ec.execute(ctiList);
        ec.execute(ctiList);
        ec.execute(ctiList);

        ec.shutdown();

    }


}
