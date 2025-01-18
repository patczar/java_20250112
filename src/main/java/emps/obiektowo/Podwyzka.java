package emps.obiektowo;

import java.io.FileNotFoundException;
import java.util.List;

import javax.swing.JOptionPane;

public class Podwyzka {

	public static void main(String[] args) throws FileNotFoundException {
		List<Employee> emps = ObslugaCSV.wczytaj("emps.csv");
		String szukanyJob = JOptionPane.showInputDialog("Podaj nazwę stanowiska");
		int podwyzka = Integer.parseInt(JOptionPane.showInputDialog("Podaj kwotę podwyżki"));
		int ile = 0;
		
		for(Employee emp : emps) {
			if(emp.getJobTitle().equalsIgnoreCase(szukanyJob)) {
				emp.setSalary(emp.getSalary() + podwyzka);
				ile++;
			}
		}
		ObslugaCSV.zapisz(emps, "zmieniony.csv");
		JOptionPane.showMessageDialog(null, "Zmieniono " + ile + " rekordów");
	}

}
