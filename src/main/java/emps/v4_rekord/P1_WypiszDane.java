package emps.v4_rekord;

import java.util.List;

// Program dla każdego pracownika wypisuje tekst postaci
// Steven King (President) zarabia 24000
public class P1_WypiszDane {

	public static void main(String[] args) {
		List<Employee> emps = ObslugaCSV.wczytaj("emps.csv");
		for(Employee emp : emps) {
			// System.out.println(emp.getFirstName() + " " + emp.getLastName());
			System.out.printf("Pracownik %s %s (%s) zarabia %s%n",
					emp.firstName(), emp.lastName(), emp.jobTitle(), emp.salary());
		}
	}

}

// TODO napisać programy P2 P3 P4 działające tak, jak w wersji nieobiektowej,
// ale w oparciu o listę obiektów Emeployee
