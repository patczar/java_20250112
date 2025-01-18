package p09_streamy;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import emps.streamy.Employee;
import emps.streamy.ObslugaCSV;

public class Kolektory2 {

	public static void main(String[] args) {
		//List<Employee> emps = Collections.emptyList();
		List<Employee> emps = ObslugaCSV.wczytaj();
		
		// grouping by - zbiera elementy w grupy
		
		Map<String, List<Employee>> grupy1 = emps.stream()
			.collect(Collectors.groupingBy(Employee::getJobTitle));
		
		grupy1.forEach((k,v) -> {
			System.out.println(k);
			v.forEach(emp -> {
				System.out.printf("    %-12s %-12s %10s\n", emp.getFirstName(), emp.getLastName(), emp.getSalary());
			});
		});
		System.out.println();
		
		// Podajemy dodatkowy kolektor mówiący co robić z każdą grupą
		Map<String, Integer> grupy2 = emps.stream()
				.collect(Collectors.groupingBy(
						Employee::getJobTitle,
						Collectors.summingInt(Employee::getSalary)));
		
		grupy2.forEach((k,v) -> {
				System.out.printf("%-32s %12s\n", k, v);
		});
		System.out.println();
		
		// Możemy też podać fabrykę map jako środkowy parametr
		Map<String, Integer> grupy3 = emps.stream()
				.collect(Collectors.groupingBy(
						Employee::getJobTitle,
						TreeMap::new,
						Collectors.summingInt(Employee::getSalary)));
		
		grupy3.forEach((k,v) -> {
				System.out.printf("%-32s %12s\n", k, v);
		});
		System.out.println();
		System.out.println("================");
		
		
		Map<Boolean, List<Employee>> partycje1 = emps.stream()
			.collect(Collectors.partitioningBy(emp -> emp.getSalary() >= 10000));
		
		System.out.println("Bogaci:");
		partycje1.get(true)
			.forEach(emp -> System.out.println("  " + emp.getLastName()));

		System.out.println("\nBiedni:");
		partycje1.get(false)
			.forEach(emp -> System.out.println("  "+ emp.getLastName()));
		System.out.println();
		
		Map<Boolean, Long> partycje2 = emps.stream()
				.collect(Collectors.partitioningBy(
						emp -> emp.getSalary() >= 10000,
						Collectors.counting()));
		
		System.out.println("Bogatych " + partycje2.get(true));
		System.out.println("Biednych " + partycje2.get(false));
	}

}
