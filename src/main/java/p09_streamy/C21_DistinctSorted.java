package p09_streamy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class C21_DistinctSorted {
	public static void main(String[] args) {
		String[] tablica = { "Ala", "Ola", "Iwona", "Magdalena", "Joanna", "Anna", "Teresa", "Ola",
				"Żaneta", "Ęcki", "Ącki", "Agnieszka", "ala", "Łucja", "Julia", "Julitta", "Zuzanna" };

		List<String> lista = new ArrayList<>(Arrays.asList(tablica));
		
		System.out.println("Przed tworzeniem strumienia");
		
		// distinct i sorted to są opearacje "stateful intermediate"
		// one są wykonywane dopiero gdy na strumieniu jest odpalona operacja terminalna
		// ale mogą wymagać zebrania większej ilości danych (nawet wszystkich) przed przepuszczeniem elementów do dalszych etapów przetwarzania
		
		// Wynika z tego, że nie powinny być stosowane do strumieni nieskończonych.
		String napis = lista.stream()
			.distinct()
			.map(String::toUpperCase)
			.sorted()
			.collect(Collectors.joining(", "));

		 System.out.println(napis);
	}

}
