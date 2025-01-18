package p09_streamy;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class KlasaOptional {

	public static void main(String[] args) {
		Optional<String> napis0 = Optional.empty();
		System.out.println(napis0);
		
		Optional<String> napis1 = Optional.of("Ala");
		System.out.println(napis1);
		
		// Można też tworzyć Optional w oparciu o wartość, która może być nullem (null oznacza empty)
		String a = "Ola", b = null;
		
		Optional<String> napis2 = Optional.ofNullable(a);
		Optional<String> napis3 = Optional.ofNullable(b);
		System.out.println(napis2);
		System.out.println(napis3);
		System.out.println();
		
		// Wartość, która jest w Optionalu, najprościej odczytać operacją get
		System.out.println(napis1.get());
		
		// ale w przypadku pustego Optionala spowodowałoby to wyjątek
		try {
			System.out.println(napis0.get());
		} catch (Exception e) {
			System.err.println("próba odczytu napis0.get(): " + e);
		}
		System.out.println();
		
		// Aby porównać działanie dla pustych i niepustych, operacje uruchamiam w pętli dla 3 przykładowych obiektów.
		List<Optional<String>> lista = new ArrayList<>(Arrays.asList(napis1, napis2, napis3));
		// Od Javy 9 możnaby (lista jest niemutowalna)
		// List<Optional<String>> lista = List.of(napis1, napis2, napis3);
		
		
		// Dla każdego Optionala można za pomocą if sprawdzić czy on zawiera wartość:
		for(Optional<String> opt : lista) {
			if(opt.isPresent()) {
				System.out.println("Jest wartość " + opt.get());
			} else {
				System.out.println("Brak wartości");
			}
		}
		System.out.println();
		
		// Można też pobierając wartość zastąpić ją wartością domyślną w przypadku braku danych:
		for(Optional<String> opt : lista) {
			String napis = opt.orElse("nieznana osoba");
			System.out.println("Witaj osobo " + napis);
		}
		System.out.println();
		
		// Ponieważ utworzenie domyślnej wartości może być czasami kosztowne,
		// albo musi być zrobione w czasie działania programu,
		// można też przekazać funkcję, która utworzy tę wartość - najczęściej jako wyrażenienie lambda:
		for(Optional<String> opt : lista) {
			String napis = opt.orElseGet(() -> "Brak danych stwierdzony o godzinie " + LocalTime.now());
			System.out.println("Halo halo " + napis);
		}
		System.out.println();
		
		// Można też wyrzucić wyjątek, ale własny zamiast standardowego
		try {
			for(Optional<String> opt : lista) {
				String napis = opt.orElseThrow(() -> new RuntimeException("Brak danych stwierdzony o godzinie " + LocalTime.now()));
				System.out.println("Helo helo " + napis);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		System.out.println();
		
		
		// Są też operacje "funkcyjne", które przypominają operacje na strumieniach.
		// Uwaga wstępna - wszystkie te operacjie noe modyfikują obiektu Optional w środku,
		// tylko w wyniku zwracają nowego Optionala.
		
		// Operacja map zamienia wartość w Optionalu na wynik funkcji,
		// ale w przypadku pustego Optionala zwraca pustego Optionala
		
		Optional<String> wynikMap0 = napis0.map(String::toUpperCase);
		Optional<String> wynikMap1 = napis1.map(String::toUpperCase);
		System.out.println(wynikMap0);
		System.out.println(wynikMap1);
		
		for(Optional<String> opt : lista) {
			System.out.println("hej " + opt.map(String::toLowerCase).orElse("nieznajomy"));
		}
		System.out.println();
		// 

		for(Optional<String> opt : lista) {
			String napis = opt.filter(s -> s.startsWith("O")).map(String::toUpperCase).orElse("---");
			System.out.println(napis); 
		}
	}

}
