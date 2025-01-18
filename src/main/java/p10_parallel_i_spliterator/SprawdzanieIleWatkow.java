package p10_parallel_i_spliterator;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class SprawdzanieIleWatkow {

	public static void main(String[] args) {
		AtomicIntegerArray array = new AtomicIntegerArray(64);
		
		IntUnaryOperator operacja = x -> {
			int id = (int)Thread.currentThread().getId();
			array.incrementAndGet(id);
			return 2*x;
		};
		
		int[] tab = new int[10_000_000];
		Arrays.fill(tab, 33);
		
		System.out.println("Tablica wątków na początku:");
		System.out.println(array);
		
		int suma2 = IntStream.of(tab).parallel().map(operacja).sum();
		System.out.println("suma2 = " + suma2);
		
		System.out.println();
		System.out.println("Tablica wątków na końcu:");
		System.out.println(array);
		
		int ileWatkow = 0;
		for (int i = 0; i < array.length(); i++) {
			if(array.get(i) > 0) {
				ileWatkow++;
				System.out.printf("wątek nr %3d - %8d razy\n", i, array.get(i));
			}
		}
		System.out.println();
		System.out.println("W sumie pracowało " + ileWatkow + " wątków.");
		
		System.out.println("Ilość procesorów: " + 
				Runtime.getRuntime().availableProcessors());
	}
}
