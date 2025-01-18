package p10_parallel_i_spliterator;

import java.util.function.LongSupplier;

public class MierzenieCzasu {
	
	public static void uruchom(LongSupplier metoda) {
		long start = System.nanoTime();
		
		long wynik = metoda.getAsLong();
		
		long end = System.nanoTime();
		
		System.out.printf("czas: %12d  , wynik = %d\n", (end - start) / 1000, wynik);
	}
	
	public static void uruchom(int n, LongSupplier metoda) {
		long start = System.currentTimeMillis();
		long wynik = 0L;
		for(int i = 1; i <= n; i++) {
			wynik += metoda.getAsLong();
		}
		long end = System.currentTimeMillis();
		System.out.printf("czas: %6d, wynik: %15d\n", end - start, wynik);
	}


}
