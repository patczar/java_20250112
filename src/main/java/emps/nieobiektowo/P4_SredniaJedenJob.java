package emps.nieobiektowo;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// - użytkownik podaje nazwę stanowiska (np. Programmer), a program oblicza średnią pensję pracowników z tego stanowiska
public class P4_SredniaJedenJob {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(new File("pliki/emps.csv"))) {
            String szukanyJob = JOptionPane.showInputDialog("Podaj nazwę stanowiska");
            int suma = 0;
            int ile = 0;
            scanner.nextLine(); // aby pominąć nagłówki
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(";", -1);
                // wersja odporna na null: Objects.equals(fields[3], szukanyJob)
                if(fields[3].equals(szukanyJob)) {
                    suma += Integer.parseInt(fields[4]);
                    ile++;
                }
            }
            if(ile == 0) {
                JOptionPane.showMessageDialog(null, "Nikt nie pracuje na stanowisku " + szukanyJob);
            } else {
                double srednia = (double) suma / ile;
                JOptionPane.showMessageDialog(null, "Średnia pracowników na stanowisku " + szukanyJob + " wynosi " + srednia);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
