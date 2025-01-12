package emps.streamy;

import java.io.FileNotFoundException;
import java.util.List;

public class P2_WypiszBogatych {

    public static final int GRANICA_ZAROBKOW = 10000;

    public static void main(String[] args) throws FileNotFoundException {
        List<Employee> emps = ObslugaCSV.readCSV();
        System.out.println("Wczytano " + emps.size() + " rekordów.");
        System.out.println("Pracownicy zarabiający co najmniej "+GRANICA_ZAROBKOW+":");

        emps.stream()
                .filter(emp -> emp.getSalary() >= GRANICA_ZAROBKOW)
                .forEach(emp -> System.out.println(emp.getFirstName()
                    + " " + emp.getLastName() + " zarabia " + emp.getSalary()));

        System.out.println("\n----------------\n");

        emps.parallelStream()
                .filter(emp -> emp.getSalary() >= GRANICA_ZAROBKOW)
                .map(emp -> emp.getFirstName() + " " + emp.getLastName() + " zarabia " + emp.getSalary())
                .forEachOrdered(System.out::println);

        System.out.println("\nLista nadal zawiera " + emps.size() + " elementów.");
    }
}
