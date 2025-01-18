package emps.v4_rekord;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Grupowanie2 {
	
	public static void main(String[] args) {
		List<Employee> emps = ObslugaCSV.wczytaj("emps.csv");
		
		Map<String, Integer> sumy = new TreeMap<>();
		Map<String, Integer> ilosci = new TreeMap<>();

		for(Employee emp : emps) {
			int suma = sumy.getOrDefault(emp.jobTitle(), 0);
			sumy.put(emp.jobTitle(), suma + emp.salary());
			int ile = ilosci.getOrDefault(emp.jobTitle(), 0);
			ilosci.put(emp.jobTitle(), ile+1);
		}

		for(String job : sumy.keySet()) {
			int suma = sumy.get(job);
			int ile = ilosci.get(job);
			double srednia = (double)suma / ile;
			System.out.printf("| %-32s | %2d | %8.2f |%n", job, ile, srednia);
		}
	}

}
