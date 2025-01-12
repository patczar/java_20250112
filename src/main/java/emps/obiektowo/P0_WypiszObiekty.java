package emps.obiektowo;

import java.io.FileNotFoundException;
import java.util.List;

public class P0_WypiszObiekty {
    public static void main(String[] args) throws FileNotFoundException {
        List<Employee> emps = ObslugaCSV.wczytaj("pliki/emps.csv");
        System.out.println("Odczytano " + emps.size() + " rekordów.");
        for (Employee emp : emps) {
            System.out.println(emp);
        }
    }
}

/*
 1 - wypisz wybrane pola, np "Pracownik Steven King zarabia 24000"
 2 - wypisz pracowników, którzy zarabiają >= 10 tys
 3 - średnia pensja wszystkich
 4 - średnia pensja na wybranym stanowisku

 5 - wypisz dane pracowników, który zarabia najmniej, i który zarabia najwięcej
 6 - sortowanie - wypisz pracowników w kolejności rosnących pensji
 7 - wypisz nazwy jobów bez powtórzeń
 8 - (grupowanie) - dla każdego stanowiska (jobTitle) wypisz ilu pracowników pracuje na tym stanowisku i jaka jest ich średnia pensja
 */
