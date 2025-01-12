package emps.obiektowo;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;

// 6 - sortowanie - wypisz pracowników w kolejności rosnących pensji
public class P6_Sortowanie1 {
    public static void main(String[] args) throws FileNotFoundException {
        List<Employee> emps = ObslugaCSV.readCSV("pliki/emps.csv");
        System.out.println("Odczytano " + emps.size() + " rekordów.");

        // to jest poprawne, zakłądając, że pensje nie są ujemne
        // emps.sort((lewy, prawy) -> lewy.getSalary() - prawy.getSalary());
        // gdyby mogłby być ujemne, to groziłoby nam "integer overflow; bezpieczniej jest używać Integer.compare zamiast odejmowania
        emps.sort((lewy, prawy) -> Integer.compare(lewy.getSalary(), prawy.getSalary()));

        // emps.sort(Comparator.comparingInt(Employee::getSalary));


        for(Employee emp : emps) {
            System.out.println(emp.getFirstName() + " " + emp.getLastName() + " (" + emp.getJobTitle() + ") zarabia " + emp.getSalary());
        }
    }
}
