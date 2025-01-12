package emps.obiektowo;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

// 4 - średnia pensja na wybranym stanowisku
public class P4_SredniaJedenJob_Interaktywna {
    public static void main(String[] args) throws FileNotFoundException {
        JFileChooser fileChooser = new JFileChooser(".");
        int coSieStalo = fileChooser.showOpenDialog(null);
        if(coSieStalo != JFileChooser.APPROVE_OPTION) {
            // nie wskazano pliku - przerywam program
            return;
        }
        File selectedFile = fileChooser.getSelectedFile();
        List<Employee> emps = ObslugaCSV.wczytaj(selectedFile);
        Set<String> jobs = new TreeSet<>();
        for(Employee emp : emps) {
            jobs.add(emp.getJobTitle());
        }
        String szukanyJob = (String)JOptionPane.showInputDialog(null, "Wybierz stanowisko", "Pytanie",
                JOptionPane.QUESTION_MESSAGE, null, jobs.toArray(), "Programmer");

        double suma = 0;
        int ile = 0;
        for(Employee emp : emps) {
            if(emp.getJobTitle().equals(szukanyJob)) {
                suma += emp.getSalary();
                ile++;
            }
        }
        if(ile == 0) {
            JOptionPane.showMessageDialog(null,
                    String.format("Nikt nie pracuje na stanowisku %s", szukanyJob));
        } else {
            double srednia = suma / ile;
            JOptionPane.showMessageDialog(null,
                    String.format("Na stanowisku %s pracuje %d osób\na ich średnia pensja wynosi %.2f", szukanyJob, ile, srednia));
        }
    }
}
