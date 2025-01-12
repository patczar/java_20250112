package emps.obiektowo;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Dla każdego joba obliczyć średnią pensję.

// To rozwiązanie nie ma optymalnej wydajności.
// Dla każdego joba od nowa przeglądamy całą listę pracowników. Dla naszych danych daje to (1+19) * 107 operacji.
public class Grupowanie0 {
    public static void main(String[] args) throws FileNotFoundException {
        List<Employee> emps = ObslugaCSV.readCSV();
        Set<String> jobs = new HashSet<>();
        for(Employee emp : emps) {
            jobs.add(emp.getJobTitle());
        }

        for(String job : jobs) {
            double suma = 0;
            int ile = 0;
            for(Employee emp : emps) {
                if(emp.getJobTitle().equals(job)) {
                    suma += emp.getSalary();
                    ile++;
                }
            }
            double srednia = suma / ile;
            System.out.printf("%-32s| %2d | %8.2f%n", job, ile, srednia);
        }
    }
}
