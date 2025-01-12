package p01_klasy;

public class Konto {
    private final int numer;
    private int saldo;
    private Osoba wlasciciel;

    public Konto(int numer, int saldo, Osoba wlasciciel) {
        this.numer = numer;
        this.saldo = saldo;
        this.wlasciciel = wlasciciel;
    }

    @Override
    public String toString() {
        return "Konto{" +
                "numer=" + numer +
                ", saldo=" + saldo +
                ", wlasciciel=" + wlasciciel +
                '}';
    }

    public int getNumer() {
        return numer;
    }

    public Osoba getWlasciciel() {
        return wlasciciel;
    }

    public int getSaldo() {
        return saldo;
    }

    public void wplata(int kwota) {
        saldo += kwota;
    }

    public void wyplata(int kwota) {
        saldo -= kwota;
    }
}
