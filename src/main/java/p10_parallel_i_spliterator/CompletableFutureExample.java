package p10_parallel_i_spliterator;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> ("Hello, Async!"))
                         .thenApply(String::toUpperCase)
                         .thenAccept(System.out::println)
                ;
        System.out.println("Koniec main");
    }
}