package emps.obiektowo;

import java.io.FileNotFoundException;
import java.util.List;

// 2 - wypisz pracowników, którzy zarabiają co najmniej 10 tys
public class P2_WypiszBogatych {
    public static void main(String[] args) throws FileNotFoundException {
        List<Employee> emps = ObslugaCSV.readCSV("pliki/emps.csv");
        System.out.println("Odczytano " + emps.size() + " rekordów.");
        for(Employee emp : emps) {
            if(emp.getSalary() >= 10_000) {
                System.out.println(emp.getFirstName() + " " + emp.getLastName()
                        + " (" + emp.getJobTitle() + ") zarabia " + emp.getSalary());
            }
        }
    }
}

/*
 3 - średnia pensja wszystkich
 4 - średnia pensja na wybranym stanowisku

 5 - wypisz dane pracowników, który zarabia najmniej, i który zarabia najwięcej
 6 - sortowanie - wypisz pracowników w kolejności rosnących pensji
 7 - wypisz nazwy jobów bez powtórzeń
 8 - (grupowanie) - dla każdego stanowiska (jobTitle) wypisz ilu pracownikóœ pracuje na tym stanowisku i jaka jest ich średnia pensja

 */
