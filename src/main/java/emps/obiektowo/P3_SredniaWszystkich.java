package emps.obiektowo;

import java.io.FileNotFoundException;
import java.util.List;

// 3 - średnia pensja wszystkich
public class P3_SredniaWszystkich {
    public static void main(String[] args) throws FileNotFoundException {
        List<Employee> emps = ObslugaCSV.wczytaj("pliki/emps.csv");
        double suma = 0;
        for(Employee emp : emps) {
            suma += emp.getSalary();
        }
        double srednia = suma / emps.size();
        System.out.println("Średnia pensja wszystkich: " + srednia);
    }
}
