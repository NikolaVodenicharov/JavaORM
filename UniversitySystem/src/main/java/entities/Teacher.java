package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "teachers")
public class Teacher extends Human{
    private String email;
    private BigDecimal salaryPerHour;

    @OneToMany(mappedBy = "teacher", targetEntity = Course.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Course> courses;

    public Teacher() {
    }

    public Teacher(int id, String firstName, String lastName, String phoneNumber, String email, BigDecimal salaryPerHour, Set<Course> courses) {
        super(id, firstName, lastName, phoneNumber);
        this.setEmail(email);
        this.setSalaryPerHour(salaryPerHour);
        this.setCourses(courses);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(BigDecimal salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public Set<Course> getCourses() {
        return courses;
    }
    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
