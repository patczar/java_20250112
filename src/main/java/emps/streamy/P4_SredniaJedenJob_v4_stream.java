package emps.streamy;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.List;

public class P4_SredniaJedenJob_v4_stream {

    public static void main(String[] args) throws FileNotFoundException {
        List<Employee> emps = ObslugaCSV.wczytaj();

        String szukanyJob = JOptionPane.showInputDialog("Podaj nazwę stanowiska");

        ObslugaCSV.wczytajStrumieniowo()
                .filter(emp -> emp.getJobTitle().equalsIgnoreCase(szukanyJob))
                .mapToInt(Employee::getSalary)
                .average()
                .ifPresentOrElse(
                    avg -> JOptionPane.showMessageDialog(null, String.format(
                            "Pracownicy typu %s mają średnią pensję %.2f", szukanyJob, avg)),
                    () -> JOptionPane.showMessageDialog(null, String.format("Nikt nie pracuje na stanowisku %s", szukanyJob)));
    }
}
