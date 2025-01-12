package emps.streamy;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;

public class P5_MinMax_v1 {

    public static void main(String[] args) throws FileNotFoundException {
        List<Employee> emps = ObslugaCSV.readCSV();

        // Gdyby strumień był pusty i min / max zwracały Optional.empty(), to opracja get skończy się wyjątkiem.
        Employee min = emps.stream().min(Comparator.comparingInt(Employee::getSalary)).get();
        Employee max = emps.stream().max(Comparator.comparingInt(Employee::getSalary)).get();

        System.out.println("min: " + min.getFirstName() + " " + min.getLastName() + " " + min.getSalary());
        System.out.println("max: " + max.getFirstName() + " " + max.getLastName() + " " + max.getSalary());
    }
}
