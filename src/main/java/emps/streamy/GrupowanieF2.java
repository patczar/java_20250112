package emps.streamy;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GrupowanieF2 {

    public static void main(String[] args) throws FileNotFoundException {
        List<Employee> emps = ObslugaCSV.readCSV();

        // Drugim paramterm kolektora groupingBy może być inny kolektor, który mówi "co zrobić z każdą grupą"
        Map<String, Double> srednie = emps.stream().collect(Collectors.groupingBy(
                Employee::getJobTitle, Collectors.averagingInt(Employee::getSalary)));

        srednie.forEach((job, srednia) -> {
            System.out.println(job + " → " + srednia);
        });
    }
}
