package emps.obiektowo;

import java.io.FileNotFoundException;
import java.util.*;

// Dla każdego joba obliczyć średnią pensję.
// Klasyczny schemat grupowania za pomocą słowników.
// W tej wersji używamy wyłącznie podstawowych operacji dostepnych w tej formie od Java 5 (a w formie opartej o typ Object od Java 1.2).
public class Grupowanie1 {
    public static void main(String[] args) throws FileNotFoundException {
        List<Employee> emps = ObslugaCSV.readCSV();

        // dla każdego joba będziemy tu pamiętać sumę pensji
        Map<String, Integer> sumy = new HashMap<>();
        Map<String, Integer> ilosci = new HashMap<>();

        for(Employee emp : emps) {
            if(sumy.containsKey(emp.getJobTitle())) {
                int suma = sumy.get(emp.getJobTitle());
                sumy.put(emp.getJobTitle(), suma + emp.getSalary());
                int ile = ilosci.get(emp.getJobTitle());
                ilosci.put(emp.getJobTitle(), ile + 1);
            } else {
                sumy.put(emp.getJobTitle(), emp.getSalary());
                ilosci.put(emp.getJobTitle(), 1);
            }
        }

        for(String job : sumy.keySet()) {
            int suma = sumy.get(job);
            int ile = ilosci.get(job);
            double srednia = 1. * suma / ile;
            System.out.printf("%-32s| %2d | %8.2f%n", job, ile, srednia);
        }
    }
}
