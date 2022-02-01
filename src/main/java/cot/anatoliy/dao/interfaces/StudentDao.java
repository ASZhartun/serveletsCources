package cot.anatoliy.dao.interfaces;

import cot.anatoliy.entity.Course;
import cot.anatoliy.entity.Student;

import java.util.List;

public interface StudentDao {
    // create, read, update, delete
    int createStudent(Student person);

    List<Student> readAllStudents();

    Student readStudentById(int id);
    //
    void updateStudent(Student updatedStudent);

    void deleteStudent(int id);
}