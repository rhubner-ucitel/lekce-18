package cz.robotdreams.java.lekce18;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService ec = Executors.newFixedThreadPool(10);

        Future<String> vypocet1 = ec.submit(() -> {
            Util.sout("Dlouhy vypocet");
            Util.cekej(5000);
            Util.sout("Vypocet hotov");
            return "42";
        });

        while(true) {

            if(!vypocet1.isDone()) {
                Util.sout("Vypocet porad bezi, cekame....");
                Util.cekej(333);
            }else {
                break;
            }
        }


        Util.sout("Vysledek vypoctu : " + vypocet1.get());
        ec.shutdown();

    }


}
