package emps.streamy;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.List;
import java.util.OptionalDouble;

public class P4_SredniaJedenJob_v2 {

    public static void main(String[] args) throws FileNotFoundException {
        List<Employee> emps = ObslugaCSV.wczytaj();

        String szukanyJob = JOptionPane.showInputDialog("Podaj nazwę stanowiska");

        OptionalDouble opt = emps.stream()
                .filter(emp -> emp.getJobTitle().equalsIgnoreCase(szukanyJob))
                .mapToInt(Employee::getSalary)
                .average();

        // Wynikiem operacji average jest obiekt OptionalDouble
        // dlaczego? bo w przypadku pustej listy nie da się obliczyć średniej
        // na tym obiekcie można wykonywać takie operacje:
        // toString
        System.out.println(opt);

        // getAsDouble - to by wyrzuciło wyjątek w razie braku danych
        // aby sprawdzić, czy wartość istnieje, można użyć isPresent / isEmpty
        if(opt.isPresent()) {
            System.out.printf("Pracownicy typu %s mają średnią pensję %.2f%n", szukanyJob, opt.getAsDouble());
        } else {
            System.out.printf("Nikt nie pracuje na stanowisku %s%n", szukanyJob);
        }

        // inne operacje
        // orElse - w razie braku danych zwraca domyślną wartość
        System.out.println(opt.orElse(0.0));

        // orElseGet - w razie braku danych wylicza domyślną wartość
        System.out.println(opt.orElseGet(() -> LocalTime.now().toNanoOfDay()));

        // ifPresent - wykonuje podany kod tylko gdy wartość istnieje
        opt.ifPresent(x -> System.out.println("Wynikiem jest wartość " + x));
    }
}
