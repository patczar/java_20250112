package p09_streamy;

import java.util.Collection;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import emps.streamy.Employee;
import emps.streamy.ObslugaCSV;

public class Kolektory1 {

	public static void main(String[] args) {
		//List<Employee> emps = Collections.emptyList();
		List<Employee> emps = ObslugaCSV.wczytaj();
		
		// collectory obliczające standardowe funkcje agregujące
		Long ilu = emps.stream().collect(Collectors.counting());
		Integer suma = emps.stream().collect(Collectors.summingInt(Employee::getSalary));
		Double avg = emps.stream().collect(Collectors.averagingInt(Employee::getSalary));
		// dla pustego zbioru danych wychodzi 0.0
		
		System.out.println(ilu + ", " + suma + ", " + avg);
		
		// Porównuje pracowników wg pensji
		Comparator<Employee> komp = Comparator.comparingInt(Employee::getSalary);
		
		Optional<Employee> min = emps.stream().collect(Collectors.minBy(komp));
		Optional<Employee> max = emps.stream().collect(Collectors.maxBy(komp));
		
		System.out.println(min);
		System.out.println(max);
		
		// przykład wyciągaia wartości z Optionala
		String str1 = min
			.map(emp -> emp.getFirstName()
					+ " " + emp.getLastName()
					+ " / " + emp.getSalary())
			.orElse("nie ma takiego gościa");
		System.out.println(str1);
		System.out.println();

		// Oblicza wszystkie 5 standardowe funkcje agregujące
		IntSummaryStatistics statystyki = emps.stream().collect(Collectors.summarizingInt(Employee::getSalary));
		System.out.println(statystyki);
		System.out.println(statystyki.getAverage());
		System.out.println();
		
		// Zestaw kolektorów zbierających dane do kolekcji:
		List<String> list1 = emps.stream()
			.map(Employee::getFirstName)
			.sorted()
			.distinct()
			.collect(Collectors.toList());
		System.out.println(list1);
	
		Set<String> set1 = emps.stream()
				.map(Employee::getCity)
				.collect(Collectors.toSet());
		System.out.println(set1);

		Collection<String> kolekcja = emps.stream()
				.map(Employee::getCity)
				.collect(Collectors.toCollection(TreeSet::new));
		System.out.println(kolekcja);
		System.out.println();
		
		// Tworząc słownik podajemy skąd się biorą klucze, skąd się biorą wartości
		// i ewentualnie jak aktualizować już wpisane wartości
		Map<String, Integer> grupy = emps.stream()
			.collect(Collectors.toMap(Employee::getCity,
					Employee::getSalary,
					Math::addExact));
		
		grupy.forEach((k,v) -> System.out.printf("%20s -> %10s\n", k, v));
		System.out.println();
		
		String txt1 = emps.stream()
			.map(Employee::getDepartmentName)
			.distinct()
			.collect(Collectors.joining());
		System.out.println(txt1);
		
		String txt2 = emps.stream()
				.map(Employee::getDepartmentName)
				.distinct()
				.collect(Collectors.joining(", "));
		System.out.println(txt2);
		
		String txt3 = emps.stream()
				.map(Employee::getDepartmentName)
				.distinct()
				.collect(Collectors.joining(", ", "<", ">"));
		System.out.println(txt3);
	}

}
