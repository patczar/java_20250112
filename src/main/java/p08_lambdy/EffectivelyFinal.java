package p08_lambdy;

import java.util.ArrayList;
import java.util.List;

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
		
		// Głupie rozwiązanie problemu "ile jest jest imion 3-literowych"
		imiona.forEach(s -> {
			if(s.length() == 3) {			
				//NK x++; // wewnątrz wyrażeń lambda nie można modyfikować zmiennych lokalnych z otoczenia

				// ani nawet używać zmiennych modyfikowanych poza lambdą
				//NK System.out.println(liczba);
				
				// mamy dostęp do zmiennych z poziomu klasy (statycznych, isntancyjnych)
				statyczna++;
				// ale to zły styl
			}
		});
		
		System.out.println("        x : " + x);
		System.out.println("statyczna : " + statyczna);
	}
}
