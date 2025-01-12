package emps.streamy;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P8_Partycje {

	public static void main(String[] args) throws FileNotFoundException {
		List<Employee> emps = ObslugaCSV.wczytaj();
		
		// Podział rekordów na dwie części i zapisanie w słowniku,
		// w którym kluczem są wartości true/false
		Map<Boolean, List<Employee>> grupy = emps.stream()
			.collect(Collectors.partitioningBy(emp -> emp.getSalary() >= 10_000));
		
		System.out.println("Bogaci:");
		grupy.get(true).forEach(emp -> {
			System.out.printf(" * %s %s (%s), pensja: %s\n", emp.getFirstName(), emp.getLastName(), emp.getJobTitle(), emp.getSalary());
		});

		System.out.println("\nBiedni:");
		grupy.get(false).forEach(emp -> {
			System.out.printf(" * %s %s (%s), pensja: %s\n", emp.getFirstName(), emp.getLastName(), emp.getJobTitle(), emp.getSalary());
		});
	}

}
