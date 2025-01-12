package emps.streamy;

import java.io.FileNotFoundException;
import java.util.List;

public class P1_WypiszWybranePola {

    public static void main(String[] args) throws FileNotFoundException {
        List<Employee> emps = ObslugaCSV.readCSV();
        System.out.println("Wczytano " + emps.size() + " rekordów.");

//        emps.forEach(emp -> System.out.println(emp.getFirstName()
//                + " " + emp.getLastName() + " zarabia " + emp.getSalary()));

// Też OK:
//        emps.stream()
//                .forEach(emp -> System.out.println(emp.getFirstName()
//                        + " " + emp.getLastName() + " zarabia " + emp.getSalary()));

        emps.stream()
                .map(emp -> emp.getFirstName() + " " + emp.getLastName() + " zarabia " + emp.getSalary())
                .forEach(System.out::println);
    }
}
