package emps.streamy;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GrupowanieF1 {

    public static void main(String[] args) throws FileNotFoundException {
        List<Employee> emps = ObslugaCSV.readCSV();

        // Dla każdej wartości jobTitle w słowniku zapisana jest lista pracowników, którzy mieli tę wartość.
        Map<String, List<Employee>> grupy = emps.stream().collect(Collectors.groupingBy(Employee::getJobTitle));
        // System.out.println(grupy);

        grupy.forEach((job, lista) -> {
            System.out.println("Pracownicy ze stanowiska " + job + " (" + lista.size() + " sztuk):");
            lista.forEach(emp -> {
                System.out.println(" * " + emp.getFirstName() + " " + emp.getLastName() + " " + emp.getSalary());
            });
            System.out.println();
        });
    }
}
