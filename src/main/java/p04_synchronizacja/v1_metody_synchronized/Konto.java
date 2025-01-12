package p04_synchronizacja.v1_metody_synchronized;

public class Konto {
    private final int numer;
    private String wlasciciel;
    private int saldo;

    public Konto(int numer, String wlasciciel, int saldo) {
        if(saldo < 0) {
            throw new IllegalArgumentException("Saldo ujemne");
        }
        this.numer = numer;
        this.setWlasciciel(wlasciciel);
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Konto nr " + numer + ", wł: " + wlasciciel + ", saldo: " + saldo;
    }

    public int getNumer() {
        return numer;
    }

    public String getWlasciciel() {
        return wlasciciel;
    }

    public void setWlasciciel(String wlasciciel) {
        if(wlasciciel == null) {
            throw new IllegalArgumentException("Wlasciciel nieokreślony");
        }
        this.wlasciciel = wlasciciel;
    }

    public synchronized int getSaldo() {
        return saldo;
    }

    // Gdy jeden wątek wykonuje metodę lubblok synchronizowany na obiekcie X,
    // to żaden inny wątek nie może wejść do metody lub sekcji synchronizowanej
    // NA TYM SAMYM OBIEKCIE. Taki wątek czeka, aż wykonujący wyjdzie z kodu synchronizowanego.
    public synchronized void wplata(int kwota) {
        if(kwota <= 0) {
            throw new IllegalArgumentException("Kwota wpłaty nie jest dodatnia");
        }
        saldo += kwota;
        notify();

        // System.out.println("I jeszcze coś robię");
        // saldo --; // potrącić prowizję

        // wątek obudzony z notify musi jeszcze poczekać, aż ja skończę tu robotę
        // bo to jeszcze ja zajmuję sekcje "synchorized"
    }

    public synchronized void wyplata(int kwota) throws BrakSrodkow {
        if(kwota <= 0) {
            throw new IllegalArgumentException("Kwota wypłaty nie jest dodatnia");
        }
        if(kwota > saldo) {
            throw new BrakSrodkow("Za mało środków na koncie nr " + numer);
        }
        saldo -= kwota;
    }

    public synchronized void wyplataCzekaj(int kwota) throws BrakSrodkow {
        if(kwota <= 0) {
            throw new IllegalArgumentException("Kwota wypłaty nie jest dodatnia");
        }
        try {
            while(kwota > saldo) {
                wait();
                // po obudzeniu (notify) ten wątek na normalnych prawach
                // czeka na dostęp do sekcji synchronizowanej
                // 1) wątek, który zrobił notify, musi wyjść
                // 2) może pojawić się trzeci wątek, który "wepchnie się" do metody synchronizowanej,
                // zanim zrobi to TEN wątek obudzony z wait-a
                // Również z tego powodu warunek oczekiwania należy sprawdzić ponownie po obudzeniu
                // Standardowy zapis - pętla while.
            }
            saldo -= kwota;
            notify();
        } catch (InterruptedException e) {
            // Taki wyjątek pojawi się gdy podczas gdy wątek A śpi (w wait, sleep itp.)
            // inny wątek B wywoła na wątku A metodę interrupt
            // Zazwyczaj robi się to, gdy kończy się program albo anuluje wątki, które nie będą potrzebne.

            // interrupt nie jest normalnym zakończeniem oczekiwania. Warunek logiczny nie został spełniony
            // - w takiej sytuacji nie powinniśmy podejmować akcji zmieniających stan,
            // ani nie powinnismy kontynuować czekania.
        }
    }

    // samo synchronized na poziomie metody to za mało, bo modyfikujemy też drugie konto...
    public synchronized void przelew(Konto cel, int kwota) throws BrakSrodkow {
        if(kwota <= 0) {
            throw new IllegalArgumentException("Kwota przelewu nie jest dodatnia");
        }
        if(kwota > saldo) {
            throw new BrakSrodkow("Za mało środków na koncie nr " + numer);
        }
        this.saldo -= kwota;
        cel.saldo += kwota;
    }
}
