package emps.v4_rekord;

import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Grupowanie9 {

	public static void main(String[] args) {
		Map<String, IntSummaryStatistics> grupy = ObslugaCSV.wczytajStrumieniowo("emps.csv")
				.collect(Collectors.groupingBy(
						Employee::jobTitle,
						TreeMap::new,
						Collectors.summarizingInt(Employee::salary)));
		
		grupy.forEach((job, stats) -> {
			System.out.printf("| %-32s | %2d | %5d | %8.2f | %5d |%n",
	                job, stats.getCount(), stats.getMin(), stats.getAverage(), stats.getMax());
		});
	}

}
