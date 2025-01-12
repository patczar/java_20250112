package emps.nieobiektowo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// - oblicz średnią pensję wszystkich pracowników
public class P3_SredniaWszystkich {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(new File("pliki/emps.csv"))) {
            int suma = 0;
            int ile = 0;
            scanner.nextLine(); // aby pominąć nagłówki
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(";", -1);
                suma += Integer.parseInt(fields[4]);
                ile++;
            }
            double srednia = (double)suma / ile;
            System.out.println("Średnia wszystkich pracowników: " + srednia);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
