package p13_wrappery;

// Integer i Long są dużo wolniejsze niż int i long
// z tego powodu używanie List<Integer> jest dużo wolniejsze niż int[]

// Gdy w Javie 8 wymyślano Streamy, stworzono osobne wersje IntStream, DoubleStream, LongStream
// i lepiej ich używać zamiast Stream<Integer> itd.
public class Wrappery3_Wydajnosc {

	static Long suma1(int n) {
		Long wynik = 0L;
		for(Integer i = 1; i <= n; i++) {
			wynik += i;
		}
		return wynik;
	}
	
	static long suma2(int n) {
		long wynik = 0L;
		for(int i = 1; i <= n; i++) {
			wynik += i;
		}
		return wynik;
	}
	
	public static void main(String[] args) {
		int n = 1_000_000_000;
		long p, k;
		System.out.println("v1 start");
		p = System.currentTimeMillis();
		Long wynik1 = suma1(n);
		k = System.currentTimeMillis();
		System.out.println("v1 wynik: " + wynik1);
		System.out.println("czas: " + (k - p));
		System.out.println();
		
		System.out.println("v2 start");
		p = System.currentTimeMillis();
		long wynik2 = suma2(n);
		k = System.currentTimeMillis();
		System.out.println("v2 wynik: " + wynik2);
		System.out.println("czas: " + (k - p));
	}

}
