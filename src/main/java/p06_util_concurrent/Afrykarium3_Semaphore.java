package p06_util_concurrent;

import java.util.concurrent.Semaphore;

public class Afrykarium3_Semaphore {
    // wolne miejsca w środku
    private Semaphore miejsca = new Semaphore(2000, true);

    public void wpuśćWycieczkę(int ilu) {
        try {
            // zmniejsza wartość semafora o ilu,
            // ale jeśli wartość semafora < ilu, to czeka, aż semafor uzyska odp. wartość.
            miejsca.acquire(ilu);  // -= akademicko : P
        } catch(InterruptedException e) {
        }
        // otwórz bramki
    }

    public void zwiedzającyWychodzi() {
        miejsca.release();		// ++ akademicko: V
    }
}
