package emps.streamy;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

public class P4_SredniaJedenJob_v1 {

    public static void main(String[] args) throws FileNotFoundException {
        List<Employee> emps = ObslugaCSV.readCSV();

        String szukanyJob = JOptionPane.showInputDialog("Podaj nazwę stanowiska");

        double srednia = emps.stream()
                .filter(emp -> emp.getJobTitle().equalsIgnoreCase(szukanyJob))
                .mapToInt(Employee::getSalary)
                .average()
                .orElse(0);

        JOptionPane.showMessageDialog(null, srednia);

    }
}
