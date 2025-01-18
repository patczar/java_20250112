package emps.streamy;

import java.util.Comparator;
import java.util.List;

public class P6b_Sortowanie_WieleKryteriow {

	public static void main(String[] args) {
		List<Employee> emps = ObslugaCSV.wczytaj();

		emps.stream()
			.sorted(Comparator.comparing(Employee::getCity)
						.thenComparing(Employee::getLastName)
						.thenComparing(Employee::getFirstName))
			.forEach(emp -> System.out.printf("%-15s %-15s %s%n",
					emp.getFirstName(), emp.getLastName(), emp.getCity()));
	}

}
