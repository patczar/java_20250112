package emps.streamy;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.List;

public class P4_SredniaJedenJob_v1 {

    public static void main(String[] args) throws FileNotFoundException {
        List<Employee> emps = ObslugaCSV.wczytaj();

        String szukanyJob = JOptionPane.showInputDialog("Podaj nazwę stanowiska");

        double srednia = emps.stream()
                .filter(emp -> emp.getJobTitle().equalsIgnoreCase(szukanyJob))
                .mapToInt(Employee::getSalary)
                .average()
                .orElse(0);

        JOptionPane.showMessageDialog(null, srednia);

    }
}
