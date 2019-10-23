package spring.exercise.dataTransferObjects;

import java.util.List;

public class ManagerDto {
    private String firstName;
    private String lastName;
    private List<BasicEmployeeDto> employees;

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<BasicEmployeeDto> getEmployees() {
        return employees;
    }
    public void setEmployees(List<BasicEmployeeDto> employees) {
        this.employees = employees;
    }
}
