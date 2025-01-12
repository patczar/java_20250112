package p04_synchronizacja.v1_metody_synchronized;

public class WyplacanieZOczekiwaniem {

    public static void main(String[] args) {
        Konto konto = new Konto(1, "Ala", 15_000);
        System.out.println("początek main: " + konto);
        Thread wplacacz = new Thread(() -> {
            try {
                while(true) {
                    Thread.sleep(10_000);
                    konto.wplata(10_000);
                    System.out.println("Po wpłacie jest " + konto.getSaldo());
                }
            } catch (InterruptedException e) {}
        });
        Thread wyplacacz = new Thread(() -> {
            try {
                while(true) {
                    try {
                        Thread.sleep(500);
                        konto.wyplataCzekaj(700);
                        System.out.println("Po wypłacie jest " + konto.getSaldo());
                    } catch (BrakSrodkow e) {
                        System.err.println(e.getMessage());
                    }
                }
            } catch (InterruptedException e) {}
        });
        wplacacz.start();
        wyplacacz.start();

        System.out.println("wątki uruchomione");
    }
}
