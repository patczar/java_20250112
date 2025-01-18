package emps.obiektowo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class PodwyzkaInteraktywna {

	public static void main(String[] args) throws FileNotFoundException {
		JFileChooser chooser = new JFileChooser(".");
		int coSieStalo = chooser.showOpenDialog(null);
		if(coSieStalo != JFileChooser.APPROVE_OPTION) {
			// jeśli nie wybrano pliku
			return;
		}
		File plikWejsciowy = chooser.getSelectedFile();
		
		List<Employee> emps = ObslugaCSV.wczytaj(plikWejsciowy);
		
		String[] jobs = emps.stream()
				.map(Employee::getJobTitle)
				.distinct()
				.sorted()
				.toArray(String[]::new);
		
		String szukanyJob = (String)JOptionPane.showInputDialog(null, "Wybierz nazwę stanowiska", "Wybierz",
				JOptionPane.QUESTION_MESSAGE, null, jobs, null);
		
		int podwyzka = Integer.parseInt(JOptionPane.showInputDialog("Podaj kwotę podwyżki"));
		int ile = 0;
		
		for(Employee emp : emps) {
			if(emp.getJobTitle().equals(szukanyJob)) {
				emp.setSalary(emp.getSalary() + podwyzka);
				ile++;
			}
		}
		chooser.showSaveDialog(null);
		if(coSieStalo != JFileChooser.APPROVE_OPTION) {
			return;
		}
		File plikWyjsciowy = chooser.getSelectedFile();
		ObslugaCSV.zapisz(emps, plikWyjsciowy);
		JOptionPane.showMessageDialog(null, "Zmieniono " + ile + " rekordów");
	}

}
