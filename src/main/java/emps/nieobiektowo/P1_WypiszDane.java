package emps.nieobiektowo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1_WypiszDane {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(new File("pliki/emps.csv"))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // System.out.println(line);
                String[] fields = line.split(";", -1);
                // System.out.println(java.util.Arrays.toString(fields));
                System.out.println("Pracownik " + fields[1] + " " + fields[2] + " zarabia " + fields[4]);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

// - oblicz średnią pensję wszystkich pracowników
// - użytkownik podaje nazwę stanowiska (np. Programmer), a program oblicza średnią pensję pracowników z tego stanowiska
// Integer.parseInt
// trzeba też ominąć pierwszą linię
// no i porównywanie Stringów