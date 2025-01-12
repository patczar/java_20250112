package p03_watki;

import java.io.IOException;

public class Przerwanie {

    public static void main(String[] args) {
        System.out.println("main: początek programu");
        System.out.println("Mój obiekt Thread: " + Thread.currentThread());
        System.out.println("Moje id: " + Thread.currentThread().getId());
        
        Thread th = new Thread(() -> {
            System.out.println("Start");
            try {
                Thread.sleep(5000);
                System.out.println("sleep normalnie zakończony");
            } catch (InterruptedException e) {
                System.out.println("sleep przerwany " + e);
            }
            System.out.println("start pętli");
            Long suma = 0L; // Long z dużej celowo, aby spowolnić!
            for(int i = 0; i < 1_000_000_000; i++) {
                suma += i;
            }
            System.out.println("koniec pętli, suma: " + suma);
            System.out.println("interrupted() ? " + Thread.interrupted());
            System.out.println("Koniec");
        });
        
        System.out.println("main: robię th.start()");
        th.start();
        System.out.println("Wystartowałem wątek. Naciśnij enter, aby przerwać.");
        
        try {
            System.in.read();
            // czekamy na ENTER i gdy zostanie naciśnięty, wywołamy interrupt na wątku
            th.interrupt();
        } catch (IOException e) {
            e.printStackTrace();
        };
        
        System.out.println("Koniec main");
    }

}
