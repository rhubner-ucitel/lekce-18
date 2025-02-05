package cz.robotdreams.java.lekce18;

public class Util {


    public static void sout(String msg) {
        Thread t = Thread.currentThread();
        System.out.println(t.getName() + ": " + msg);
    }


    public static void cekej(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println("Vlakno : " + Thread.currentThread().getName() + " bylo nasilne probuzeno.");
        }
    }
}