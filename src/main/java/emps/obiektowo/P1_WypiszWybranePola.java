package emps.obiektowo;

import java.io.FileNotFoundException;
import java.util.List;

//  1 - wypisz wybrane pola, np "Steven King zarabia 24000"
public class P1_WypiszWybranePola {
    public static void main(String[] args) throws FileNotFoundException {
        List<Employee> emps = ObslugaCSV.wczytaj("pliki/emps.csv");
        System.out.println("Odczytano " + emps.size() + " rekordów.");
        for (Employee emp : emps) {
            System.out.println(emp.getFirstName() + " " + emp.getLastName() + " zarabia " + emp.getSalary());
        }
    }
}
