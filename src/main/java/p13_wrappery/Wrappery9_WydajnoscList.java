package p13_wrappery;

import java.util.ArrayList;
import java.util.Locale;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Wrappery9_WydajnoscList {
	// wiekość tablicy
	private static final int N = 100_000_000;
	// ilość powtórzeń odczytu
	private static final int K = 20;
	
	private static void zmierzCzas(String tytul, Runnable procedura) {
		System.out.println("\nZaczynam " + tytul);
		long start = System.nanoTime();
		procedura.run();
		long koniec = System.nanoTime();
		double czas = (koniec - start) * 1e-9;
		System.out.printf(Locale.US, "%s: %10.6f s\n", tytul, czas);
	}
	
	private static void wyczysc() {
		try {
			System.gc();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
	}
	
	private static void petla() {
		long suma = 0L;
		for(int k = 0; k < K; k++) {
			for(int i = 0; i < N; i++) {
				suma += i;
			}
		}
		System.out.println(suma);
	}

	private static void tablica() {
		int[] t = new int[N];
		for(int i = 0; i < N; i++) {
			t[i] = i;
		}
		
		long suma = 0L;
		for(int k = 0; k < K; k++) {
			for(int x : t) {
				suma += x;
			}
		}
		System.out.println(suma);
	}

	private static void array_list() {
		ArrayList<Integer> l = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			l.add(i);
		}
		
		long suma = 0L;
		for(int k = 0; k < K; k++) {
			for(int x : l) {
				suma += x;
			}
		}
		System.out.println(suma);
	}
	
	private static void stream_range() {
		long suma = 0L;
		for(int k = 0; k < K; k++) {
			suma += LongStream.range(0, N).sum();
		}
		System.out.println(suma);
	}
	
	private static void stream_tablica() {
		int[] t = IntStream.range(0, N).toArray();
		
		long suma = 0L;
		for(int k = 0; k < K; k++) {
			suma += IntStream.of(t).asLongStream().sum();
		}
		System.out.println(suma);
	}

	
	public static void main(String[] args) {
		System.out.println("Startujemy...");
		zmierzCzas("Pętla bez kolekcji", Wrappery9_WydajnoscList::petla);
		wyczysc();

		zmierzCzas("Tablica", Wrappery9_WydajnoscList::tablica);
		wyczysc();

		zmierzCzas("ArrayList", Wrappery9_WydajnoscList::array_list);
		wyczysc();

		zmierzCzas("Stream (range)", Wrappery9_WydajnoscList::stream_range);
		wyczysc();

		zmierzCzas("Stream (tablica)", Wrappery9_WydajnoscList::stream_tablica);
		wyczysc();
		
		System.out.println("Koniec");
	}

}
