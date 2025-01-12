package emps.obiektowo;

import java.io.FileNotFoundException;
import java.util.List;

// 5 - wypisz dane pracowników: który zarabia najmniej, i który zarabia najwięcej
public class P5_MinMax_v3 {
    public static void main(String[] args) throws FileNotFoundException {
        List<Employee> emps = ObslugaCSV.wczytaj("pliki/emps.csv");
        Employee maxEmployee = emps.get(0), minEmployee = emps.get(0);
        // Od Java 21: Employee maxEmployee = emps.getFirst(), minEmployee = emps.getFirst();

        for(Employee emp : emps) {
            if(emp.getSalary() > maxEmployee.getSalary()) {
                maxEmployee = emp;
            }
            if(emp.getSalary() < minEmployee.getSalary()) {
                minEmployee = emp;
            }
        }
        System.out.println(maxEmployee);
        System.out.println(minEmployee);
    }
}
