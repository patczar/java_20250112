package p09_streamy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class A4_Peek {
	public static void main(String[] args) {
		String[] tablica = { "Ala", "Ola", "Iwona", "Magdalena", "Joanna", "Anna", "Teresa",
				"Żaneta", "Ęcki", "Ącki", "Agnieszka", "ala", "Łucja", "Julia", "Julitta", "Zuzanna" };

		List<String> lista = new ArrayList<>(Arrays.asList(tablica));
		
		System.out.println("Przed tworzeniem strumienia");
		
		Stream<String> strumien = lista.stream()
			.peek(s -> System.out.println("\n F : " + s))
			.filter(s -> s.length() > 3)
			.peek(s -> System.out.println(" M : " + s))
			.map(String::toUpperCase)
			.peek(s -> System.out.println(" # : " + s));
			
		System.out.println("Strumień utworzony: " + strumien);
		System.out.println();
		System.out.println("Operacja terminująca:");
		strumien.forEach(s -> System.out.println(" * " + s));
		System.out.println("KONIEC");
		System.out.println();
		
		Stream<String> str2a = lista.stream();
		Stream<String> str2b = str2a.peek(s -> System.out.println(" % " + s));
		// peek nie wpływa na zawartość ani "widzianą z zewnątrz logikę" strumienia,
		// ale powoduje, że w momencie ewaluacji strumienia na każdym elemencie będzie wykonan podana operacja
		
		str2b.limit(5).forEach(s -> {});
	}

}
