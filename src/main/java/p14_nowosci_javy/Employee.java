package p14_nowosci_javy;

import java.time.LocalDate;

public record Employee(int employeeId, String firstName, String lastName, String jobTitle, int salary, LocalDate hireDate, String departmentName, String address, String postalCode, String city, String country) {

    // można definiować własne metody
    public String wizytowka() {
        return firstName + " " + lastName;
    }

}
