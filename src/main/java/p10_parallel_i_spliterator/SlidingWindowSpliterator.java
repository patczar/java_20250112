package p10_parallel_i_spliterator;

import java.util.*;
import java.util.function.Consumer;

public class SlidingWindowSpliterator<T> implements Spliterator<List<T>> {
    private final List<T> list;
    private final int windowSize;
    private int currentIndex = 0;

    public SlidingWindowSpliterator(List<T> list, int windowSize) {
        this.list = list;
        this.windowSize = windowSize;
    }

    @Override
    public boolean tryAdvance(Consumer<? super List<T>> action) {
        if (currentIndex + windowSize <= list.size()) {
            List<T> window = list.subList(currentIndex, currentIndex + windowSize);
            action.accept(window);
            currentIndex++;
            return true;
        }
        return false;
    }

    @Override
    public Spliterator<List<T>> trySplit() {
        return null; // Prosta implementacja, brak podziału
    }

    @Override
    public long estimateSize() {
        return list.size() - windowSize + 1L;
    }

    @Override
    public int characteristics() {
        return ORDERED | NONNULL | SIZED;
    }

    public static <T> Stream<List<T>> slidingWindowStream(List<T> list, int windowSize) {
        return StreamSupport.stream(new SlidingWindowSpliterator<>(list, windowSize), false);
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        SlidingWindowSpliterator.slidingWindowStream(numbers, 3)
                .forEach(System.out::println);

        // Wynik:
        // [1, 2, 3]
        // [2, 3, 4]
        // [3, 4, 5]
    }
}