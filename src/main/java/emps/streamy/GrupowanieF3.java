package emps.streamy;

import java.io.FileNotFoundException;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class GrupowanieF3 {

    public static void main(String[] args) throws FileNotFoundException {
        List<Employee> emps = ObslugaCSV.readCSV();

        Map<String, IntSummaryStatistics> grupy = emps.stream()
                .collect(Collectors.groupingBy(
                        Employee::getJobTitle,
                        TreeMap::new,
                        Collectors.summarizingInt(Employee::getSalary)));

        grupy.forEach((job, stats) -> {
            // System.out.printf("%-32s → %s%n", job, stats);
            System.out.printf("| %-32s | %2d | %5d | %8.2f | %5d |%n",
                    job, stats.getCount(), stats.getMin(), stats.getAverage(), stats.getMax());
        });
    }
}
