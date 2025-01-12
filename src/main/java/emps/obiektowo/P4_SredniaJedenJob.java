package emps.obiektowo;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.List;

// 4 - średnia pensja na wybranym stanowisku
public class P4_SredniaJedenJob {
    public static void main(String[] args) throws FileNotFoundException {
        List<Employee> emps = ObslugaCSV.readCSV("pliki/emps.csv");
        String szukanyJob = JOptionPane.showInputDialog("Podaj nazwę stanowiska");

        double suma = 0;
        int ile = 0;
        for(Employee emp : emps) {
            if(emp.getJobTitle().equalsIgnoreCase(szukanyJob)) {
                suma += emp.getSalary();
                ile++;
            }
        }
        if(ile == 0) {
            JOptionPane.showMessageDialog(null, "Nikt nie pracuje na stanowisku " + szukanyJob);
        } else {
            double srednia = suma / ile;
            JOptionPane.showMessageDialog(null, "Średnia pracowników na stanowisku " + szukanyJob + " wynosi " + srednia);
        }
    }
}

/*
 5 - wypisz dane pracowników, który zarabia najmniej, i który zarabia najwięcej
 6 - sortowanie - wypisz pracowników w kolejności rosnących pensji
 7 - wypisz nazwy jobów bez powtórzeń
 8 - (grupowanie) - dla każdego stanowiska (jobTitle) wypisz ilu pracownikóœ pracuje na tym stanowisku i jaka jest ich średnia pensja
 */