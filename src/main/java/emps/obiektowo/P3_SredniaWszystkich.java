package emps.obiektowo;

import java.io.FileNotFoundException;
import java.util.List;

// 3 - średnia pensja wszystkich
public class P3_SredniaWszystkich {
    public static void main(String[] args) throws FileNotFoundException {
        List<Employee> emps = ObslugaCSV.readCSV("pliki/emps.csv");
        double suma = 0;
        for(Employee emp : emps) {
            suma += emp.getSalary();
        }
        double srednia = suma / emps.size();
        System.out.println("Średnia pensja wszystkich: " + srednia);
    }
}

/*
 4 - średnia pensja na wybranym stanowisku

 5 - wypisz dane pracowników, który zarabia najmniej, i który zarabia najwięcej
 6 - sortowanie - wypisz pracowników w kolejności rosnących pensji
 7 - wypisz nazwy jobów bez powtórzeń
 8 - (grupowanie) - dla każdego stanowiska (jobTitle) wypisz ilu pracownikóœ pracuje na tym stanowisku i jaka jest ich średnia pensja

 */
