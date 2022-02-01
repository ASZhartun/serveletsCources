package cot.anatoliy.dao;

import cot.anatoliy.dao.interfaces.TeacherDao;
import cot.anatoliy.entity.Person;
import cot.anatoliy.entity.Teacher;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class TeacherHibernateDao implements TeacherDao {
    public static void main(String[] args) {
        TeacherHibernateDao teacherHibernateDao = new TeacherHibernateDao();
        List<Teacher> teachers = teacherHibernateDao.readAllTeachers();
        System.out.println();
    }

    @Override
    public void createTeacher(Teacher person) {
        Transaction transaction = null;
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
             Session session = factory.openSession();) {
            transaction = session.beginTransaction();
            session.save(person);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<Teacher> readAllTeachers() {
        ArrayList<Teacher> teacherList = new ArrayList<>();
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
             Session session = factory.openSession();) {
            List allTeachers = session.createQuery("FROM teacher").list();
            teacherList.addAll(allTeachers);

        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return teacherList;
    }

    @Override
    public Teacher readTeacherById(long id) {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
             Session session = factory.openSession();) {

            Teacher teacher = session.get(Teacher.class, id);
            return teacher;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return new Teacher();
    }

    @Override
    public void updateTeacher(Teacher updatedTeacher) {
        Transaction transaction = null;
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
             Session session = factory.openSession();) {
            transaction = session.beginTransaction();
            session.update(updatedTeacher);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTeacher(int id) {
        Transaction transaction = null;
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
             Session session = factory.openSession();) {
            transaction = session.beginTransaction();
            session.delete(readTeacherById(id));
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }
}
