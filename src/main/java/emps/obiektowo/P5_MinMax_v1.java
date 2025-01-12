package emps.obiektowo;

import java.io.FileNotFoundException;
import java.util.List;

// 5 - wypisz dane pracowników: który zarabia najmniej, i który zarabia najwięcej
public class P5_MinMax_v1 {
    public static void main(String[] args) throws FileNotFoundException {
        List<Employee> emps = ObslugaCSV.readCSV("pliki/emps.csv");

        int maxSalary = 0, minSalary = Integer.MAX_VALUE;
        String maxEmployee = "", minEmployee = "";

        for(Employee emp : emps) {
            if(emp.getSalary() > maxSalary) {
                maxSalary = emp.getSalary();
                maxEmployee = emp.getFirstName() + " " + emp.getLastName();
            }
            if(emp.getSalary() < minSalary) {
                minSalary = emp.getSalary();
                minEmployee = emp.getFirstName() + " " + emp.getLastName();
            }
        }
        System.out.println(maxSalary + " - tyle zarabia " + maxEmployee);
        System.out.println(minSalary + " - tyle zarabia " + minEmployee);
    }
}
