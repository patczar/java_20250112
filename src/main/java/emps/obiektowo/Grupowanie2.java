package emps.obiektowo;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// W tej werji używam dodatkowej operacji Java 8 - getOrDefault
public class Grupowanie2 {
    public static void main(String[] args) throws FileNotFoundException {
        List<Employee> emps = ObslugaCSV.readCSV();

        Map<String, Integer> sumy = new HashMap<>();
        Map<String, Integer> ilosci = new HashMap<>();

        for(Employee emp : emps) {
            int suma = sumy.getOrDefault(emp.getJobTitle(), 0);
            sumy.put(emp.getJobTitle(), suma + emp.getSalary());
            int ile = ilosci.getOrDefault(emp.getJobTitle(), 0);
            ilosci.put(emp.getJobTitle(), ile + 1);
        }

        for(String job : sumy.keySet()) {
            int suma = sumy.get(job);
            int ile = ilosci.get(job);
            double srednia = 1. * suma / ile;
            System.out.printf("%-32s| %2d | %8.2f%n", job, ile, srednia);
        }
    }
}
