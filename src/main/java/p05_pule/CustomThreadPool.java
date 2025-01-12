package p05_pule;

import java.util.concurrent.*;


public class CustomThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, 4, 60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10), // Ograniczona kolejka
                new ThreadPoolExecutor.CallerRunsPolicy() // Zadania są wykonywane przez wątek wywołujący w razie braku miejsca w tej puli
        );


        executor.submit(() -> System.out.println("Task executed"));
        executor.shutdown();
    }
}
