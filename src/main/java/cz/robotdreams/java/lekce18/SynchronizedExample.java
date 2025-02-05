package cz.robotdreams.java.lekce18;

public class SynchronizedExample {

    private int a;
    private int b;

    public synchronized void setValues(int a, int b) {
        Util.sout("Nastavuji hodnoty");
        Util.cekej(1000);
        this.a = a;
        this.b = b;
        Util.sout("Hodnoty nastaveny");
    }

    public synchronized int[] valuesAsVector() {
        Util.sout("Ctu hodnoty");
        return new int[] { a, b };
    }

    public static void main(String[] args) {
        SynchronizedExample example = new SynchronizedExample();

        Thread nastavT = new Thread(() -> example.setValues(10, 20), "VlaknoNastavovaci");
        nastavT.start();
        Thread ctuT = new Thread(() -> {
            Util.cekej(10);
            Util.sout("Zacinam cist hodnoty : ");
            example.valuesAsVector();
        }, "VlaknoCteci");
        ctuT.start();
    }
}