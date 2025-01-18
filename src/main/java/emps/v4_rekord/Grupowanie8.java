package emps.v4_rekord;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Grupowanie8 {

	public static void main(String[] args) {
		List<Employee> emps = ObslugaCSV.wczytaj("emps.csv");
		
		Map<String, Double> grupy = emps.stream()
				.collect(Collectors.groupingBy(
						Employee::jobTitle,
						Collectors.averagingInt(Employee::salary)));
		
		grupy.forEach((job, srednia) -> {
			System.out.printf("%-32s → %8.2f%n", job, srednia);
		});
	}

}
