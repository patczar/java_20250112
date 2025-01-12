package emps.obiektowo;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;

public class P6_Sortowanie2 {
    public static void main(String[] args) throws FileNotFoundException {
        List<Employee> emps = ObslugaCSV.wczytaj("pliki/emps.csv");
        System.out.println("Odczytano " + emps.size() + " rekordów.");

        // sortowanie malejące wg pensji
        emps.sort(Comparator.comparingInt(Employee::getSalary).reversed());

        for(Employee emp : emps) {
            System.out.println(emp.getFirstName() + " " + emp.getLastName() + " (" + emp.getJobTitle() + ") zarabia " + emp.getSalary());
        }
    }
}
