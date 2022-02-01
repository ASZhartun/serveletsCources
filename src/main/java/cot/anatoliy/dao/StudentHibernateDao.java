package cot.anatoliy.dao;

import cot.anatoliy.dao.interfaces.StudentDao;
import cot.anatoliy.entity.Course;
import cot.anatoliy.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class StudentHibernateDao implements StudentDao {

    public static void main(String[] args) {
        StudentHibernateDao studentHibernateDao = new StudentHibernateDao();
        CourseHibernateDao courseHibernateDao = new CourseHibernateDao();
//        Course course = courseHibernateDao.readCourseById(2);
//        Course course1 = courseHibernateDao.readCourseById(3);
//
//        Student oleg = new Student("Oleg", "Ivanov");
//        Student zhenya = new Student("Zhenya", "Petrov");
//
//        oleg.getCourseSet().add(course);
//        oleg.getCourseSet().add(course1);
//
//        zhenya.getCourseSet().add(course1);
//
//        studentHibernateDao.createStudent(zhenya);
//        studentHibernateDao.createStudent(oleg);
//        System.out.println();

        Student student = new Student(2,"Albert", "Testov");
        studentHibernateDao.updateStudent(student);
    }

    @Override
    public void createStudent(Student student) {
        Transaction transaction = null;
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
             Session session = factory.openSession();) {
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }
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
        Transaction transaction = null;
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
             Session session = factory.openSession();) {
            transaction = session.beginTransaction();
            session.update(updatedStudent);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(int id) {
        Transaction transaction = null;
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
             Session session = factory.openSession();) {
            transaction = session.beginTransaction();
            session.delete(readStudentById(id));
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }
}
