package emps.streamy;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;

public class P6_Sortowanie {

	public static void main(String[] args) throws FileNotFoundException {
		List<Employee> emps = ObslugaCSV.readCSV();
		emps.stream()
			.sorted(Comparator.comparingInt(Employee::getSalary).reversed())
			.map(emp -> emp.getFirstName() + " " + emp.getLastName() + " " + emp.getSalary())
			.forEach(System.out::println);
	}

}
