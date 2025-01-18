package p09_streamy;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CustomCollectors {

    public static <T> Collector<T, ?, Set<T>> toImmutableSet() {
        return Collectors.collectingAndThen(
                Collectors.toSet(),
                set -> Collections.unmodifiableSet(set)
        );
    }

    public static void main(String[] args) {
        Set<String> immutableSet = Set.of("A", "B", "C").stream()
                .collect(toImmutableSet());

        System.out.println(immutableSet); // [A, B, C]

        // Próba modyfikacji spowoduje wyjątek
        try {
            immutableSet.add("D");
        } catch (UnsupportedOperationException e) {
            System.out.println("Set jest niemodyfikowalny!");
        }
    }
}