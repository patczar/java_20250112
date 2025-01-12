package p09_streamy;

import java.util.stream.Collector;
import java.util.stream.Stream;

public class Collector_Test {

	public static void main(String[] args) {
		String[] imiona = {"Ala", "Ola", "Ela"};
		
		CollectorLaczacyNapisy collector1 = new CollectorLaczacyNapisy();
		String wynik1 = Stream.of(imiona).collect(collector1);
		System.out.println(wynik1);
		
		// Ale to samo można zrobić bezpośrednio w kodzie:
		
		// Najpierw wersja, że akumulator staje się wynikiem - nie ma funkcji finisher
		Collector<String, StringBuilder, StringBuilder> collector2 =
				Collector.of(StringBuilder::new, StringBuilder::append, StringBuilder::append);
		
		StringBuilder wynik2 = Stream.of(imiona).collect(collector2);
		System.out.println(wynik2);
		
		// Dodaję finisher równy StringBuilder.toString - ostateczny wynik typu String
		Collector<String, StringBuilder, String> collector3 =
				Collector.of(StringBuilder::new, StringBuilder::append, StringBuilder::append, StringBuilder::toString);
		
		String wynik3 = Stream.of(imiona).collect(collector3);
		System.out.println(wynik3);		
	}

}
