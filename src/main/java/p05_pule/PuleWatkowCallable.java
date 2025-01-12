package p05_pule;

import java.util.concurrent.*;

public class PuleWatkowCallable {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final int N = 10; // liczba procedur do wykonania
        final int M = 2; // liczba watkow w puli
        
        ExecutorService pool = Executors.newFixedThreadPool(M);

        Future<String> gfuture = null;
        
        Procedura proc = new Procedura();
        for(int i = 0; i < N; i++) {
            Future<String> future = pool.submit(proc);
            // System.out.println(future.isDone());
            gfuture = future;
            // odczytam wynik tylko jednego z tych zadań...
        }
        
        System.out.println("Zlecilem wykonanie");
        
        pool.shutdown();
        System.out.println("Po shutdown");
        System.out.println(gfuture.isDone());
        String wynik = gfuture.get();  // to powoduje oczekiwanie na zakończenie zadania
        System.out.println(gfuture.isDone() + wynik);
        //pool.shutdownNow();
        
        pool.awaitTermination(1, TimeUnit.DAYS);
        System.out.println("Zakończyły się");
        System.out.println(gfuture.isDone());
    }

    private static class Procedura implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.printf("Hej, tu watek %d%n", Thread.currentThread().getId());
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
            }
            return " Wynik, przygotował wątek nr " + Thread.currentThread().getId();
        }
    }
}
