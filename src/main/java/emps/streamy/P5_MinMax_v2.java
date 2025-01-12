package emps.streamy;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;

public class P5_MinMax_v2 {

    public static void main(String[] args) throws FileNotFoundException {
        List<Employee> emps = ObslugaCSV.wczytaj();
        Comparator<Employee> comparator = Comparator.comparingInt(Employee::getSalary);

        emps.stream()
                .min(comparator)
                .map(emp -> "min: " + emp.getFirstName() + " " + emp.getLastName() + " " + emp.getSalary())
                .ifPresent(System.out::println);

        emps.stream()
                .max(comparator)
                .map(emp -> "max: " + emp.getFirstName() + " " + emp.getLastName() + " " + emp.getSalary())
                .ifPresent(System.out::println);
    }
}
