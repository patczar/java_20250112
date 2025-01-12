package emps.obiektowo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ObslugaCSV {
    // to jest klasa narzędziowa - tu są tylko metody statyczne
    // mogą zakazać tworzenia obiektów tej klasy oznaczając konstruktor jako prywatny
    private ObslugaCSV() { }

    public static List<Employee> wczytaj(File file) throws FileNotFoundException {
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

    public static List<Employee> wczytaj(String path) throws FileNotFoundException {
        return wczytaj(new File(path));
    }

    public static List<Employee> wczytaj() throws FileNotFoundException {
        return wczytaj("pliki/emps.csv");
    }

    public static void zapisz(List<emps.streamy.Employee> lista, File plik) {
        try(PrintWriter out = new PrintWriter(plik)) {
            out.println(
                    "employee_id;first_name;last_name;job_title;salary;hire_date;department_name;address;postal_code;city;country");
            for (emps.streamy.Employee emp : lista) {
                out.printf("%d;%s;%s;%s;%d;%s;%s;%s;%s;%s;%s\n", emp.getEmployeeId(), emp.getFirstName(),
                        emp.getLastName(), emp.getJobTitle(), emp.getSalary(), emp.getHireDate(),
                        emp.getDepartmentName(), emp.getAddress(), emp.getPostalCode(), emp.getCity(),
                        emp.getCountry());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void zapisz(List<emps.streamy.Employee> lista, String sciezka) {
        zapisz(lista, new File(sciezka));
    }

    public static void zapisz(List<emps.streamy.Employee> lista) {
        zapisz(lista, "pliki/emps.csv");
    }
}
