package p14_nowosci_javy;

public class EmployeeTest {

    public static void main(String[] args) {
        Employee employee = new Employee(0, "Fejkowy", "Pracownik", "nikt", -1, null, "", "", "", "", "nieznany kraj");
        System.out.println(employee);

        // są dostępne gettery, ale bez słowa "get"
        System.out.println(employee.salary());
        //  nie ma setterów, bo rekordy są niemutowalne
    }
}
