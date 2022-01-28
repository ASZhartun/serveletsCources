package cot.anatoliy.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String lastName;
    @OneToMany (mappedBy = "teacher", fetch = FetchType.EAGER)
    private List<Course> coursesList;

    public Teacher(int id, String firstName, String lastName, List<Course> courseSList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.coursesList = courseSList;
    }

    public Teacher(String firstName, String lastName, List<Course> courseSList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.coursesList = courseSList;
    }

    public Teacher() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public List<Course> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(List<Course> coursesList) {
        this.coursesList = coursesList;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
