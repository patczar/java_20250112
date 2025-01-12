package emps.obiektowo;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Grupowanie5 {
	
	public static void main(String[] args) throws FileNotFoundException {
		List<Employee> emps = ObslugaCSV.readCSV();
		Map<String, int[]> slownik = new TreeMap<>();

		for(Employee emp : emps) {
			if(slownik.containsKey(emp.getJobTitle())) {
				// to jest kolejny pracownik z tego stanowiska → zwiększamy wartość w słowniku
				int[] t = slownik.get(emp.getJobTitle());
				t[0]++;
				t[1] += emp.getSalary();
				// dostaliśmy referencję do tablicy i gdy ją modyfikujemy, to słownik też to "widzi"
			} else {
				// to jest pierwszy pracownik z tego stanowiska → wpisujemy jego pensję jako wartość początkową
				slownik.put(emp.getJobTitle(), new int[] {1, emp.getSalary()});
			}
		}
		
		// przeglądamy "wpisy" w słowniku, czyli klucze wraz z wartościami
		for (Map.Entry<String, int[]> entry : slownik.entrySet()) {
			String job = entry.getKey();
			int[] t = entry.getValue();
			double srednia = (double)t[1] / t[0];
			System.out.printf("%-32s | %2d | %8.2f\n", job, t[0], srednia);
		}
	}

}
