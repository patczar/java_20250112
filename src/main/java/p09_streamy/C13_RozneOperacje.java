package p09_streamy;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class C13_RozneOperacje {

	public static void main(String[] args) {
		String[] imiona = {"Ala", "Ola", "Basia", "Kasia", "Ela", "Ula", "Agnieszka", "Magdalena", "Anna", "Hanna", "Joanna", "Ala", "Agata", "Genowefa", "Grażyna", "Karolina", "Julia", "Zuzanna"};
		
		// ** operacje terminujące ** //
		
		// forEach - dla każdego elementu wykonaj akcję
		Stream.of(imiona).forEach(s -> System.out.println(s));

		// forEachOrdered - dla każdego elementu wykonaj akcję zachowując kolejność (istotne dla parallelStream)
		Stream.of(imiona).forEachOrdered(s -> System.out.println(s));

		System.out.println("\n--------------------------------\n");
		
		// count() - liczba elementów strumienia (też wymaga pobrania elementów !)
		long n = Stream.of(imiona).count();
		System.out.println("count: " + n);
		
		// toArray - tworzy nową tablicę i wstawia tam elementy
		Object[] array1 = Stream.of(imiona)
				.map(String::toLowerCase)
				.toArray();
		System.out.println(array1 + " , length="+array1.length);
		System.out.println(Arrays.toString(array1));
		System.out.println();
		
		// inna wersja: podajemy funkcję tworzącą tablice; korzyść: dostajemy String[] a nie Object[]
		String[] array2 = Stream.of(imiona)
			.sorted()
			.toArray(String[]::new);
		System.out.println(array2 + " , length="+array2.length);
		System.out.println(Arrays.toString(array2));
		System.out.println("\n--------------------------------\n");
		
		// reduce - redukcja w sposób właściwy dla klas niemutowalnych
		Optional<String> wynik01 = Stream.of(imiona)
			.reduce(String::concat);
		System.out.println("wynik01: " + wynik01);

		String wynik02 = Stream.of(imiona)
				.reduce("", String::concat);
		System.out.println("wynik02: " + wynik02);

		String wynik03 = Stream.of(imiona)
				.reduce("|", String::concat);
		System.out.println("wynik03: " + wynik03);

		String wynik04 = Stream.of(imiona)
				.parallel()
				.reduce("|", String::concat);
		System.out.println("wynik04: " + wynik04);
		
		// Takie użycie concat jest niewydaje i tego nie naśladujcie

		// wersja, w której typ wyniku może być inny niż typ elementów
		// tu przykład sumowania długości napisów
		Integer wynik05 = Stream.of(imiona)
			.reduce(0, (x, s) -> x+s.length(), (x,y)->x+y);
		System.out.println("wynik05: " + wynik05);
		System.out.println();
		
		// collect - redukcja w sposób właściwy dla klas mutowalnych
		StringBuilder wynik06 = Stream.of(imiona).collect(
				StringBuilder::new, // supplier - tworzy początkową "pusta" wartość
				StringBuilder::append, // accumulator - aktualizuje wartość na podstawie elementu strumienia
				StringBuilder::append); // combiner - łączy częściowe wyniki (które mogą się pojawić gdy mamy parallelStream)

		System.out.println("wynik06: " + wynik06);
		
		List<String> lista = Stream.of(imiona)
			.map(String::toUpperCase)
			.collect(Collectors.toList());
		System.out.println(lista);
		System.out.println("\n--------------------------------\n");
		
		// findFirst i findAny - wybór jednego elementu
		// findAny zwraca "jakikolwiek" - ale to nie znaczy "losowy"
		// po prostu implementacja zwróci ten, do którego ma najszybszy dostęp
		Optional<String> wynik07 = Stream.of(imiona).findFirst();
		Optional<String> wynik08 = Stream.of(imiona).findAny();
		Optional<String> wynik09 = Stream.of(imiona).parallel().findAny(); // niedeterministyczne, czasami była Ala a czasami Ula
		// jest szansa na zobaczenie innego imienia niż Ala :)
		
		System.out.println("findFirst  : " + wynik07);
		System.out.println("findAny    : " + wynik08);
		System.out.println("findAny par: " + wynik09);
		System.out.println();
		
		// kwantyfikatory logiczne - zwracają true albo false
		// działają w sposób leniwy - przestają pobierać kolejne elementy strumienia jeśli wynik jest rozstrzygnięty
		boolean bool1 = Stream.of(imiona).allMatch(s -> s.endsWith("a"));
		System.out.println("bool1 = " + bool1);

		boolean bool2 = Stream.of(imiona).allMatch(s -> s.startsWith("K"));
		System.out.println("bool2 = " + bool2);

		boolean bool3 = Stream.of(imiona).anyMatch(s -> s.startsWith("K"));
		System.out.println("bool3 = " + bool3);

		boolean bool4 = Stream.of(imiona).noneMatch(s -> s.startsWith("K"));
		System.out.println("bool4 = " + bool4);

	}

}
