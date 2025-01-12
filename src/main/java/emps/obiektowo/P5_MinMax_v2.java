package emps.obiektowo;

import java.io.FileNotFoundException;
import java.util.List;

// 5 - wypisz dane pracowników: który zarabia najmniej, i który zarabia najwięcej
public class P5_MinMax_v2 {
    public static void main(String[] args) throws FileNotFoundException {
        List<Employee> emps = ObslugaCSV.wczytaj("pliki/emps.csv");
        Employee maxEmployee = null, minEmployee = null;

        for(Employee emp : emps) {
            if(maxEmployee == null || emp.getSalary() > maxEmployee.getSalary()) {
                maxEmployee = emp;
            }
            if(minEmployee == null || emp.getSalary() < minEmployee.getSalary()) {
                minEmployee = emp;
            }
        }
        System.out.println(maxEmployee);
        System.out.println(minEmployee);
    }
}
