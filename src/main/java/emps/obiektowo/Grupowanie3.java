package emps.obiektowo;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// W tej werji używam dodatkowych operacji Java 8 - putIfAbsent / computeIfPresent (istnieje też ogólna operacja compute)
public class Grupowanie3 {
    public static void main(String[] args) throws FileNotFoundException {
        List<Employee> emps = ObslugaCSV.readCSV();

        Map<String, Integer> sumy = new HashMap<>();
        Map<String, Integer> ilosci = new HashMap<>();

        for(Employee emp : emps) {
            sumy.putIfAbsent(emp.getJobTitle(), 0);
            ilosci.putIfAbsent(emp.getJobTitle(), 0);
            sumy.computeIfPresent(emp.getJobTitle(), (k, suma) -> suma + emp.getSalary());
            ilosci.computeIfPresent(emp.getJobTitle(), (k, v) -> v + 1);
        }

        for(String job : sumy.keySet()) {
            int suma = sumy.get(job);
            int ile = ilosci.get(job);
            double srednia = 1. * suma / ile;
            System.out.printf("%-32s| %2d | %8.2f%n", job, ile, srednia);
        }
    }
}
