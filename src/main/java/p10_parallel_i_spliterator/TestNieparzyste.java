package p10_parallel_i_spliterator;

import java.util.Spliterator;
import java.util.function.Consumer;

public class TestNieparzyste {

	public static void main(String[] args) {
		Consumer<Integer> akcja = i -> System.out.print(i + ", ");
		
		SpliteratorLiczbyNieparzyste spl1 = new SpliteratorLiczbyNieparzyste(100);
		spl1.forEachRemaining(akcja);
		System.out.println();
		System.out.println();

		Spliterator<Integer> spl2 = new SpliteratorLiczbyNieparzyste(100);
		Spliterator<Integer> a = spl2.trySplit();
		Spliterator<Integer> b = a.trySplit();
		System.out.println("Fragmenty:");
		b.forEachRemaining(akcja);
		System.out.println();
		a.forEachRemaining(akcja);
		System.out.println();
		spl2.forEachRemaining(akcja);
		System.out.println();
		
		System.out.println();
	}
}
