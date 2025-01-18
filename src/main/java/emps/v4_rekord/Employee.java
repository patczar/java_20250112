package emps.v4_rekord;

import java.time.LocalDate;

public record Employee(int employeeId, String firstName, String lastName, String jobTitle, int salary, LocalDate hireDate,
		String departmentName, String address, String postalCode, String city, String country) {
    // Rekord to jest "taka klasa", dla której automatycznie tworzone są:
    // - deklaracje podanych pól, które wszystkie są "private final"
    // - konstruktor z wszystkimi parametrami
    // - gettery do wszystkich pól, ale uwaga, nazwą metody jest po prostu "salary()", a nie "getSalary()"
    // - toString, equals i hashCode w sposób standardowy dla klas typu "value object"

    // Do rekordu można dodawać własne metody. Rekord może implementować interfejsy.
    public String danePracownika() {
        return String.format("%s %s (%s) zarabia %d", firstName, lastName, jobTitle, salary);
    }

    public static int dodaj(int x, int y) {
    	return x + y;
    }
}
