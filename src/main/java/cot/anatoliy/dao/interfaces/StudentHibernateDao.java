package cot.anatoliy.dao.interfaces;

import cot.anatoliy.entity.Course;
import cot.anatoliy.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class StudentHibernateDao implements StudentDao{
    @Override
    public int createStudent(Student person) {
        return 0;
    }

    @Override
    public List<Student> readAllStudents() {
        List<Student> studentList = new ArrayList<>();
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
             Session session = factory.openSession();) {
            List allStudent = session.createQuery("FROM student").list();
            studentList.addAll(allStudent);

        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return studentList;
    }

    @Override
    public Student readStudentById(int id) {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
             Session session = factory.openSession()) {

            Student student = session.get(Student.class, id);
            return student;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return new Student();
    }

    @Override
    public void updateStudent(Student updatedStudent) {

    }

    @Override
    public void deleteStudent(int id) {

    }
}
