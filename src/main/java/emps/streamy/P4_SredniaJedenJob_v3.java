package emps.streamy;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.OptionalDouble;

public class P4_SredniaJedenJob_v3 {

    public static void main(String[] args) throws FileNotFoundException {
        List<Employee> emps = ObslugaCSV.readCSV();

        String szukanyJob = JOptionPane.showInputDialog("Podaj nazwę stanowiska");
        // optSrednia.ifPresent(avg -> System.out.println("Średnia = " + avg));

        emps.stream()
                .filter(emp -> emp.getJobTitle().equalsIgnoreCase(szukanyJob))
                .mapToInt(Employee::getSalary)
                .average()
                .ifPresentOrElse(
                    avg -> JOptionPane.showMessageDialog(null, String.format(
                            "Pracownicy typu %s mają średnią pensję %.2f", szukanyJob, avg)),
                    () -> JOptionPane.showMessageDialog(null, String.format("Nikt nie pracuje na stanowisku %s", szukanyJob)));
    }
}
