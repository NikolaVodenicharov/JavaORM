package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student extends Human {
    private double averageGrade;
    private int attendance;

    @ManyToMany()
    @JoinTable(
        name = "students_courses",
        joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
    private Set<Course> courses;

    public Student() {
    }

    public Student(int id, String firstName, String lastName, String phoneNumber, double averageGrade, int attendance, Set<Course> courses) {
        super(id, firstName, lastName, phoneNumber);
        this.setAverageGrade(averageGrade);
        this.setAttendance(attendance);
        this.setCourses(courses);
    }

    public double getAverageGrade() {
        return averageGrade;
    }
    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public int getAttendance() {
        return attendance;
    }
    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public Set<Course> getCourses() {
        return courses;
    }
    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
