package p10_parallel_i_spliterator;

import java.util.Random;
import java.util.function.LongSupplier;
import java.util.stream.LongStream;

public class SumArray {
	static final int N = 120_000_000;
	static final int MAX = 1000;
	static final int POWTORZENIA = 40;
	static long[] tab;

	public static void main(String[] args) {
		
		System.out.println("Generuje dane");
		tab = new long[N];
		wylosuj();
		
		System.out.println("pętla");
		testuj(SumArray::petla);
		System.out.println("stream");
		testuj(SumArray::sekw);
		System.out.println("parallel stream");
		testuj(SumArray::parallel);
		System.out.println();

		System.out.println("pętla");
		testuj(POWTORZENIA, SumArray::petla);
		System.out.println("stream");
		testuj(POWTORZENIA, SumArray::sekw);
		System.out.println("parallel stream");
		testuj(POWTORZENIA, SumArray::parallel);

	}

	private static void testuj(LongSupplier metoda) {
		long start = System.currentTimeMillis();
		long wynik = metoda.getAsLong();
		long end = System.currentTimeMillis();
		System.out.printf("czas: %6d, wynik: %15d\n", end - start, wynik);
	}

	private static void testuj(int n, LongSupplier metoda) {
		long start = System.currentTimeMillis();
		long wynik = 0L;
		for(int i = 1; i <= n; i++) {
			wynik += metoda.getAsLong();
		}
		long end = System.currentTimeMillis();
		System.out.printf("czas: %6d, wynik: %15d\n", end - start, wynik);
	}

	private static void wylosuj() {
		Random r = new Random();
		for (int i = 0; i < tab.length; i++) {
			tab[i] = r.nextInt(MAX);
		}
	}
	
	private static long petla() {
		long suma = 0L;
		for (int i = 0; i < tab.length; i++) {
			suma += tab[i];
		}
		return suma;
	}

	private static long sekw() {
		return LongStream.of(tab).sum();
	}

	private static long parallel() {
		return LongStream.of(tab).parallel().sum();
	}
}
