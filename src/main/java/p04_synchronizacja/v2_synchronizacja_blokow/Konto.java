package p04_synchronizacja.v2_synchronizacja_blokow;

class Konto {
    private final int numer;
    private int saldo;
    private Osoba wlasciciel;
    
    public Konto(int numer, int saldo, Osoba wlasciciel) {
        this.numer = numer;
        this.saldo = saldo;
        this.wlasciciel = wlasciciel;
    }

    public synchronized Osoba getWlasciciel() {
        return wlasciciel;
    }

    public synchronized void setWlasciciel(Osoba wlasciciel) {
        this.wlasciciel = wlasciciel;
    }

    public int getNumer() {
        return numer;
    }

    public synchronized int getSaldo() {
        return saldo;
    }
    
    public void wplata(int kwota) {
        if(kwota < 0) {
            throw new IllegalArgumentException("Ujemna kwota " + kwota + " we wpłacie");
        }
        
        synchronized(this) {
            saldo += kwota;
            this.notify();
        }
    }

    public void wyplata(int kwota) throws BrakSrodkow {
        if(kwota < 0) {
            throw new IllegalArgumentException("Ujemna kwota " + kwota + " w wypłacie");
        }
        
        // Jeśli mamy warunek i w zależności od warunku zmieniamy dane,
        // to warunek i operacja zmiany muszą być RAZEM w jednym bloku synchronizowanym.
        synchronized(this) {
            if(kwota > saldo) {
                throw new BrakSrodkow("Brak środków na koncie nr " + numer);
            }
            saldo -= kwota;
        }
    }
    
    public void wyplataCzekaj(int kwota) {
        if(kwota < 0) {
            throw new IllegalArgumentException("Ujemna kwota " + kwota + " w wypłacie");
        }
        try {
            synchronized(this) {
                while(kwota > saldo) {
                    this.wait();
                }
                saldo -= kwota;
                this.notify();
            }
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }

    public void przelewBlokada(Konto cel, int kwota) throws BrakSrodkow {
        if(kwota <= 0) {
            throw new IllegalArgumentException("Kwota przelewu nie jest dodatnia");
        }
        synchronized(this) {
            if (kwota > saldo) {
                throw new BrakSrodkow("Za mało środków na koncie nr " + numer);
            }
            this.saldo -= kwota;
            synchronized(cel) {
                cel.saldo += kwota;
            }
        }
        // uwaga - w tej wersji istnieje ryzyko "zakleszczenia" / deadlock
        // gdyby dwa wątki w tym samym czasie chciały robić przelew z A na B i z B na A
    }

    public void przelewProsty(Konto cel, int kwota) throws BrakSrodkow {
        if(kwota <= 0) {
            throw new IllegalArgumentException("Kwota przelewu nie jest dodatnia");
        }
        synchronized(this) {
            if (kwota > saldo) {
                throw new BrakSrodkow("Za mało środków na koncie nr " + numer);
            }
            this.saldo -= kwota;
        }
        synchronized(cel) {
            cel.saldo += kwota;
        }

        // w tej wersji najpierw zabieramy pieniądze z jednego, a potem dodajmey do drugiego
        // nie jest to "ACID" w sensie bazodanowym (przez chwilę widać stan, gdzie suma kont jest zbyt mała)
        // ale nie ma deadlocków, a pieniądze "w końcu dostrą"
    }

    public void przelew(Konto cel, int kwota) throws BrakSrodkow {
        if(kwota <= 0) {
            throw new IllegalArgumentException("Kwota przelewu nie jest dodatnia");
        }

        /* "sortuję" obiekty this i cel wg ich hashkodów
           (które w praktyce są różne dla różnych obiektów, jeśli się nie nadpisuje, a my nie nadpisywaliśmy)
           Blokowanie dostępu do obiektów kolejności ich haszkodów zapobiegnie scenariuszowi deadlocka.
         */
        Object pierwszy, drugi;
        if(this.hashCode() < cel.hashCode()) {
            pierwszy = this;
            drugi = cel;
        } else {
            pierwszy = cel;
            drugi = this;
        }
        synchronized(pierwszy) {
            synchronized(drugi) {
                if (kwota > saldo) {
                    throw new BrakSrodkow("Za mało środków na koncie nr " + numer);
                }
                this.saldo -= kwota;
                cel.saldo += kwota;
                cel.notify();
            }
        }
    }
    
    public String toString() {
        return "Konto nr " + getNumer() + ", saldo: " + getSaldo() + ", wł.: " + getWlasciciel();			
    }
}

