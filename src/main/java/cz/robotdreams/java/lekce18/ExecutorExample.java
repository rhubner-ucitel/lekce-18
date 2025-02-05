package cz.robotdreams.java.lekce18;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

    public static void main(String[] args) {

        Executor ex = Executors.newFixedThreadPool(3);


        ex.execute(() -> Util.sout("Tento kod byl spusten ve vlakne pomoci Executor.execute"));
        ex.execute(() -> Util.sout("Tento kod byl spusten ve vlakne pomoci Executor.execute"));
        ex.execute(() -> Util.sout("Tento kod byl spusten ve vlakne pomoci Executor.execute"));
        ex.execute(() -> Util.sout("Tento kod byl spusten ve vlakne pomoci Executor.execute"));

        ((ExecutorService)ex).shutdown();
    }
}
