package p06_util_concurrent;

public class Afrykarium1_Wait {
    // wolne miejsca w środku
    private int wolne = 2000;

    public synchronized void wpuśćWycieczkę(int ilu) {
        try {
            while(wolne < ilu) {
                this.wait();
            }
            wolne -= ilu;
            // otwórz bramki
        } catch(InterruptedException e) {
        }
    }

    public synchronized void zwiedzającyWychodzi() {
        wolne++;
        notify();
    }
}
