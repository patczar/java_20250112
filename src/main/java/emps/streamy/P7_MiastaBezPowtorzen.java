package emps.streamy;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class P7_MiastaBezPowtorzen {

	public static void main(String[] args) throws FileNotFoundException {
		List<Employee> emps = ObslugaCSV.wczytaj();
		// sposób 1: utworzyć zbiór Stringów
		// ma to sens, gdy potrzebujemy wykorzystać te dane w dalszej części programu
		Set<String> miasta = emps.stream()
			.map(Employee::getCity)
			.collect(Collectors.toSet());
		System.out.println(miasta);
		System.out.println("--------");
		
		// sposób 2: w łańcuchu poleceń (pipeline) umieścić operację distinct
		// ma to sens, gdy wykonujemy tylko jedną operację, np, chcemy tylko wypisać te miasta
		emps.stream()
			.map(Employee::getCity)
			.filter(s -> !s.isEmpty())
			.distinct()
			.sorted()
			.forEach(System.out::println);
	}

}
