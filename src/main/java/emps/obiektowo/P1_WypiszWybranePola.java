package emps.obiektowo;

import java.io.FileNotFoundException;
import java.util.List;

//  1 - wypisz wybrane pola, np "Steven King zarabia 24000"
public class P1_WypiszWybranePola {
    public static void main(String[] args) throws FileNotFoundException {
        List<Employee> emps = ObslugaCSV.readCSV("pliki/emps.csv");
        System.out.println("Odczytano " + emps.size() + " rekordów.");
        for (Employee emp : emps) {
            System.out.println(emp.getFirstName() + " " + emp.getLastName() + " zarabia " + emp.getSalary());
        }
    }
}

/*
 2 - wypisz pracowników, którzy zarabiają >= 10 tys
 3 - średnia pensja wszystkich
 4 - średnia pensja na wybranym stanowisku

 5 - wypisz dane pracowników, który zarabia najmniej, i który zarabia najwięcej
 6 - sortowanie - wypisz pracowników w kolejności rosnących pensji
 7 - wypisz nazwy jobów bez powtórzeń
 8 - (grupowanie) - dla każdego stanowiska (jobTitle) wypisz ilu pracownikóœ pracuje na tym stanowisku i jaka jest ich średnia pensja

 */
