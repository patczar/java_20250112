package emps.streamy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class ObslugaCSV {
    public static List<Employee> wczytaj() {
        // używa domyślnego pliku
        return wczytaj("pliki/emps.csv");
    }

    public static List<Employee> wczytaj(String sciezka) {
        return wczytaj(new File(sciezka));
    }

    public static List<Employee> wczytaj(File plik) {
        List<Employee> emps = new ArrayList<>();
        try(Scanner scanner = new Scanner(plik)) {
            scanner.nextLine(); // pomijamy pierwszą linię
            while(scanner.hasNextLine()) {
                String linia = scanner.nextLine();
                Employee emp = parsujLinie(linia);
                emps.add(emp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            // w razie błędu (brak pliku) wypiszemy czerwone teksty na ekran, ale nie przerwiemy programu, tylko zwrócimy pustą listę
        }
        return emps;
    }

    public static Stream<Employee> wczytajStrumieniowo(Path plik) {
        try {
            return Files.lines(plik)
                    .skip(1)
                    .map(ObslugaCSV::parsujLinie);
        } catch (IOException e) {
            e.printStackTrace();
            return Stream.empty();
        }
    }

    public static Stream<Employee> wczytajStrumieniowo(File plik) {
        return wczytajStrumieniowo(plik.toPath());
    }

    public static Stream<Employee> wczytajStrumieniowo(String sciezka) {
        return wczytajStrumieniowo(Path.of(sciezka));
    }

    public static Stream<Employee> wczytajStrumieniowo() {
        return wczytajStrumieniowo("pliki/emps.csv");
    }

    public static void zapisz(List<Employee> lista, File plik) {
        try(PrintWriter out = new PrintWriter(plik)) {
            out.println(
                    "employee_id;first_name;last_name;job_title;salary;hire_date;department_name;address;postal_code;city;country");
            for (Employee emp : lista) {
                out.printf("%d;%s;%s;%s;%d;%s;%s;%s;%s;%s;%s\n", emp.getEmployeeId(), emp.getFirstName(),
                        emp.getLastName(), emp.getJobTitle(), emp.getSalary(), emp.getHireDate(),
                        emp.getDepartmentName(), emp.getAddress(), emp.getPostalCode(), emp.getCity(),
                        emp.getCountry());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void zapisz(List<Employee> lista, String sciezka) {
        zapisz(lista, new File(sciezka));
    }

    public static void zapisz(List<Employee> lista) {
        zapisz(lista, "pliki/emps.csv");
    }

    private static Employee parsujLinie(String linia) {
        String[] t = linia.split(";", -1);
        Employee emp = new Employee(Integer.parseInt(t[0]), t[1], t[2], t[3],
                Integer.parseInt(t[4]), LocalDate.parse(t[5]),
                t[6], t[7], t[8], t[9], t[10]);
        return emp;
    }

}

