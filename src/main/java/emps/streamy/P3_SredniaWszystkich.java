package emps.streamy;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

public class P3_SredniaWszystkich {

    public static void main(String[] args) throws FileNotFoundException {
        List<Employee> emps = ObslugaCSV.wczytaj();

        /*
        // W Javie wewnątrz wyrażeń lambda nie wolno modyfikować zmiennych lokalnych zadeklarowanych w bloku zewnętrznym.
        // Nie wolno odwoływać się do zmiennych, które się w ogóle zmieniają (czyli nie mogą być oznaczone final).
        double suma = 0;
        emps.stream().forEach(emp -> {
            suma += emp.getSalary();
        });
        */

        double srednia1 = emps.stream()
                .mapToInt(Employee::getSalary)
                .average()
                .orElse(0);
        System.out.println(srednia1);

        Double srednia2 = emps.stream().collect(Collectors.averagingInt(Employee::getSalary));
        System.out.println(srednia2);

        // zadanie: P4_SredniaJedenJob za pomocą strumieni

        // dla chętnych: również P5 MinMax - P6_Sortowanie P7_UnikalneJoby (albo zrobić miasta..)

        // grupowanie za pomocą streamów i odpowiedniego Collectora

    }
}
