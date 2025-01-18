package emps.v4_rekord;

public class S2_Filtrowanie {

	public static void main(String[] args) {
		ObslugaCSV.wczytajStrumieniowo("emps.csv")
			.filter(emp -> emp.salary() >= 10_000)
			.map(Employee::danePracownika)
			.forEach(System.out::println);
	}

}
