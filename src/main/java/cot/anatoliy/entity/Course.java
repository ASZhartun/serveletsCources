package cot.anatoliy.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int id;
    @Column(name = "name_id")
    private String name;
    @ManyToOne
    private Teacher teacher;
    @ManyToMany(mappedBy = "courseSet", cascade = CascadeType.ALL)

    private List<Student> studentList = new ArrayList<>();

    public Course(int id, String name, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
    }

    public Course(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    public Course() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
