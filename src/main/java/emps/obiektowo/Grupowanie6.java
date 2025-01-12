package emps.obiektowo;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// Podejście obiektowe do grupowania.

public class Grupowanie6 {

	public static void main(String[] args) throws FileNotFoundException {
		final List<Employee> emps = ObslugaCSV.wczytaj();
		final Map<String, JobInfo> mapa = new TreeMap<>();
		
		for (Employee emp : emps) {
			final String jobTitle = emp.getJobTitle();
			JobInfo jobInfo = mapa.get(jobTitle);
			if (jobInfo == null) {
				jobInfo = new JobInfo(jobTitle);
				mapa.put(jobTitle, jobInfo);
			}
			jobInfo.update(emp);
		}
		
		for (JobInfo jobInfo : mapa.values()) {
			System.out.println(jobInfo);
		}
	}

	// Klasa zgnieżdżona - tylko dla przykładu.
	// Równie dobrze mógłbym tę klase zdefiniować w osobnym pliku.
	
	// Obiekt tej klasy przechowuje statystyki job
	private static class JobInfo {
		final String jobTitle;
		int count = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		JobInfo(String jobTitle) {
			this.jobTitle = jobTitle;
		}

		void update(Employee emp) {
			int salary = emp.getSalary();
			count++;
			sum += salary;
			if(salary < min) {
				min = salary;
			}
			if(salary > max) {
				max = salary;
			}
		}
		
		double avg() {
			return (double)sum / count;
		}

		@Override
		public String toString() {
			return "jobTitle=" + jobTitle + ", count=" + count + ", sum=" + sum + ", min=" + min + ", max="
					+ max + ", avg=" + avg();
		}
	}
}
