package cot.anatoliy.dao;

import cot.anatoliy.dao.interfaces.CourseDao;
import cot.anatoliy.entity.Course;
import cot.anatoliy.entity.Teacher;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class CourseHibernateDao implements CourseDao {
    public static void main(String[] args) {
        CourseHibernateDao courseHibernateDao = new CourseHibernateDao();

    }


    @Override
    public void createCourse(Course course) {
        Transaction transaction = null;
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
             Session session = factory.openSession();) {
            transaction = session.beginTransaction();
            session.save(course);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<Course> readAllCourses() {
        ArrayList<Course> courseList = new ArrayList<>();
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
             Session session = factory.openSession();) {
            List allCourses = session.createQuery("FROM course").list();
            courseList.addAll(allCourses);

        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return courseList;
    }

    @Override
    public Course readCourseById(int id) {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
             Session session = factory.openSession();) {

            Course course = session.get(Course.class, id);
            return course;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return new Course();
    }

    @Override
    public void updateCourse(Course updatedCourse) {
        Transaction transaction = null;
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
             Session session = factory.openSession();) {
            transaction = session.beginTransaction();
            session.update(updatedCourse);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCourse(int id) {
        Transaction transaction = null;
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
             Session session = factory.openSession();) {
            transaction = session.beginTransaction();
            session.delete(readCourseById(id));
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }
}