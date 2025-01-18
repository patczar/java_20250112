package p10_parallel_i_spliterator;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureMonadExample {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello, Monads!")
                .thenApply(String::toUpperCase) // Zmiana na wielkie litery
                .thenApply(result -> result + " with CompletableFuture");

        future.thenAccept(System.out::println); // Wyświetlenie wyniku
    }
}