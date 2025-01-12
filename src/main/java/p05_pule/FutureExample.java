package p05_pule;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<Integer> future = executor.submit(() -> {
            Thread.sleep(1000); // Symulacja długiego zadania
            return 42;
        });

        System.out.println("Result: " + future.get()); // `get()` blokuje do zakończenia zadania

        executor.shutdown();
    }
}