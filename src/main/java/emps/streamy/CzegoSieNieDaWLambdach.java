package emps.streamy;

import java.io.FileNotFoundException;
import java.util.List;

public class CzegoSieNieDaWLambdach {
	static int sumaStatyczna = 0;

	public static void main(String[] args) throws FileNotFoundException {
		List<Employee> emps = ObslugaCSV.readCSV();

		// czy damy radę obliczyć sumę pensji za pomocą tego nowego forEach?
		int sumaLokalna = 0;
		int[] tablica = {0};

		emps.forEach(emp -> {
			// wewnątrz wyrażeń lambda nie wolno modyfikować zmiennych lokalnych
			// zdefiniowanych przed tym wyrażeniem
			// ograniczenie "effectively final"
			// sumaLokalna += emp.getSalary();

			// bardzo brzydkie, ale działa:
			sumaStatyczna += emp.getSalary();
			tablica[0] += emp.getSalary();
		});

		System.out.println(sumaLokalna);
		System.out.println(sumaStatyczna);
		System.out.println(tablica[0]);
		System.out.println();

		// właściwe podejście:
		int suma = emps.stream().mapToInt(Employee::getSalary).sum();
		System.out.println(suma);
	}
}
