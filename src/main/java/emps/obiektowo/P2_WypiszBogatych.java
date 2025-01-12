package emps.obiektowo;

import java.io.FileNotFoundException;
import java.util.List;

// 2 - wypisz pracowników, którzy zarabiają co najmniej 10 tys
public class P2_WypiszBogatych {
    public static void main(String[] args) throws FileNotFoundException {
        List<Employee> emps = ObslugaCSV.wczytaj("pliki/emps.csv");
        System.out.println("Odczytano " + emps.size() + " rekordów.");
        for(Employee emp : emps) {
            if(emp.getSalary() >= 10_000) {
                System.out.println(emp.getFirstName() + " " + emp.getLastName()
                        + " (" + emp.getJobTitle() + ") zarabia " + emp.getSalary());
            }
        }
    }
}

