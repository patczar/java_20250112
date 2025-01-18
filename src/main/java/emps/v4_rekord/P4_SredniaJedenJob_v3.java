package emps.v4_rekord;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class P4_SredniaJedenJob_v3 {

	public static void main(String[] args) {
		JFileChooser chooser = new JFileChooser(".");
		chooser.setFileFilter(new FileNameExtensionFilter("Pliki CSV", "csv", "txt"));
		int coSieStalo = chooser.showOpenDialog(null);
		if(coSieStalo != JFileChooser.APPROVE_OPTION)
			return;
		
		File plik = chooser.getSelectedFile();
		List<Employee> emps = ObslugaCSV.wczytaj(plik);
		
		Set<String> jobs = new TreeSet<>();
		for(Employee emp : emps) {
			jobs.add(emp.jobTitle());
		}
		
		String szukanyJob = (String)JOptionPane.showInputDialog(null, "Wybierz stanowisko", "Wybór",
				JOptionPane.QUESTION_MESSAGE, null, jobs.toArray(), "Programmer");
		if(szukanyJob == null)
			return;
		
		double suma = 0;
		int ile = 0;
		for(Employee emp : emps) {
			if(szukanyJob.equals(emp.jobTitle())) {
				suma += emp.salary();
				ile++;
			}
		}

		if(ile > 0) {
			double srednia = suma / ile;
			JOptionPane.showMessageDialog(null, String.format(
					"Na stanowisku %s pracuje %d osób.\nŚrednia pensja wynosi %.2f",
					szukanyJob, ile, srednia));
		} else {
			JOptionPane.showMessageDialog(null, String.format("Nikt nie pracuje na stanowisku %s.", szukanyJob),
					"Brak danych", JOptionPane.WARNING_MESSAGE);
		}
	}
}
