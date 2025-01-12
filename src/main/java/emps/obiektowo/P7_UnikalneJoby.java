package emps.obiektowo;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

// wypisz nazwy jobów bez powtórzeń
public class P7_UnikalneJoby {
    public static void main(String[] args) {
        try {
            List<Employee> emps = ObslugaCSV.readCSV();
            Set<String> jobs = new TreeSet<>();
            for(Employee emp : emps) {
                jobs.add(emp.getJobTitle());
            }
            System.out.println(jobs);
            System.out.println(jobs.size());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
