package emps.obiektowo;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ObslugaCSV {
    // to jest klasa narzędziowa - tu są tylko metody statyczne
    // mogą zakazać tworzenia obiektów tej klasy oznaczając konstruktor jako prywatny
    private ObslugaCSV() { }

    public static List<Employee> readCSV(File file) throws FileNotFoundException {
        List<Employee> emps = new ArrayList<>();
        try(Scanner scanner = new Scanner(file)) {
            scanner.nextLine();
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(";", -1);
                Employee emp = new Employee(Integer.parseInt(fields[0]), fields[1], fields[2], fields[3], Integer.parseInt(fields[4]),
                        LocalDate.parse(fields[5]), fields[6], fields[7], fields[8], fields[9], fields[10]);
                emps.add(emp);
            }
        }
        return emps;
    }

    public static List<Employee> readCSV(String path) throws FileNotFoundException {
        return readCSV(new File(path));
    }

    public static List<Employee> readCSV() throws FileNotFoundException {
        return readCSV("pliki/emps.csv");
    }

}
