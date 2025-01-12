package p04_synchronizacja.v1_metody_synchronized;

public class Przeploty {

    public static void main(String[] args) {
        final int KWOTA = 10;
        final int ILE_RAZY = 100_000;

        Konto konto = new Konto(1, "Ala", 1_000_000);
        System.out.println("początek main: " + konto);
        Thread wplacacz = new Thread(() -> {
            for(int i = 0; i < ILE_RAZY; i++) {
                konto.wplata(KWOTA);
            }
        });
        Thread wyplacacz = new Thread(() -> {
            for(int i = 0; i < ILE_RAZY; i++) {
                try {
                    konto.wyplata(KWOTA);
                } catch (BrakSrodkow e) {
                    System.err.println(e.getMessage());
                }
            }
        });
        try {
            wplacacz.start();
            wyplacacz.start();

            // main poczeka, aż zakończą się uruchomione wątki
            wplacacz.join();
            wyplacacz.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("  koniec main: " + konto);
    }
}
