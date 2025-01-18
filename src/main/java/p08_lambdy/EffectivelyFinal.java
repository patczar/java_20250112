package p08_lambdy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class EffectivelyFinal {
	private static int statyczna = 0;

	public static void main(String[] args) {
		
		// W wyrażeniach lambda (podobnie jak w klasach anonimowych) nie można używać zmiennych lokalnych, które są modyfikowane
		
		// Przykład kiedy to przeszkadza w praktyce:
		
		List<String> imiona = new ArrayList<>();
		imiona.add("Ala");
		imiona.add("Aleksandra");
		imiona.add("Ula");
		imiona.add("Elżbieta");
		
		double liczba = 0;
		liczba = liczba + imiona.size();
		
		int x = 0;
		AtomicInteger ai = new AtomicInteger();
		
		// Głupie rozwiązanie problemu "ile jest jest imion 3-literowych"
		imiona.forEach(s -> {
			if(s.length() == 3) {			
				//NK x++; // wewnątrz wyrażeń lambda nie można modyfikować zmiennych lokalnych z otoczenia

				// ani nawet używać zmiennych modyfikowanych poza lambdą
				//NK System.out.println(liczba);
				
				// mamy dostęp do zmiennych z poziomu klasy (statycznych, isntancyjnych)
				statyczna++;
				// ale to zły styl

				// lepszym pomysłem  jest obiekt "mutowalny", np. AtomicInteger (który zadziałałby także w kontekście wielowątkowym)
				ai.incrementAndGet();
			}
		});

		// w jeszcze lepszym stylu byłoby tutaj zastosowanie strumienia z filtrem
		long y = imiona.stream().filter(s -> s.length() == 3).count();

		System.out.println("        x : " + x);
		System.out.println("statyczna : " + statyczna);
		System.out.println("atomic    : " + ai);
		System.out.println("count     : " + y);
	}
}
