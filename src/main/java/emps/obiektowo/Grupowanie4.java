package emps.obiektowo;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// W tej wersji używam dodatkowej operacji Java 8 - merge
// merge realizuje dokładnie ten schemat, o który chodzi nam w tym zadaniu:
// - jeśli wartości jeszcze nie ma → wstawia początkową
// - jeśli wartość już jest → aktualizuje zgodnie z podaną funkcją
public class Grupowanie4 {
    public static void main(String[] args) throws FileNotFoundException {
        List<Employee> emps = ObslugaCSV.wczytaj();

        Map<String, Integer> sumy = new HashMap<>();
        Map<String, Integer> ilosci = new HashMap<>();

        for(Employee emp : emps) {
            // sumy.merge(emp.getJobTitle(), emp.getSalary(), (staraSuma, zmiana) -> staraSuma + zmiana);
            // Zamiast pisać wyrażenie lambda, możemy użyć istniejącej funkcji Integer.sum
            sumy.merge(emp.getJobTitle(), emp.getSalary(), Integer::sum);
            ilosci.merge(emp.getJobTitle(), 1, Integer::sum);
        }

        for(String job : sumy.keySet()) {
            int suma = sumy.get(job);
            int ile = ilosci.get(job);
            double srednia = 1. * suma / ile;
            System.out.printf("%-32s| %2d | %8.2f%n", job, ile, srednia);
        }
    }
}
