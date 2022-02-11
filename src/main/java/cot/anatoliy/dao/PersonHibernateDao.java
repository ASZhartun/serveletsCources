package cot.anatoliy.dao;

import cot.anatoliy.dao.interfaces.PersonDao;
import cot.anatoliy.entity.Person;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component(value = "PersonHibernateDaoBean")
public class PersonHibernateDao implements PersonDao {

    @Override
    public long createPerson(Person person) {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
             Session session = factory.openSession();) {

            Transaction transaction = session.beginTransaction();
            try {
                Serializable generatedId = session.save(person);
                System.out.println(generatedId);
                transaction.commit();
                return (long) generatedId;
            } catch (Exception e) {
                transaction.rollback();
                e.printStackTrace();
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<Person> readAllPersons() {
        ArrayList<Person> personList = new ArrayList<>();
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
             Session session = factory.openSession();) {
            List employees = session.createQuery("FROM person").list();
            personList.addAll(employees);

        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return personList;
    }

    @Override
    public Person readPersonById(int id) {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
             Session session = factory.openSession();) {

            Person person = session.get(Person.class, id);
            return person;
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return new Person();
    }

    @Override
    public void updatePerson(Person updatedPerson) {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
             Session session = factory.openSession();) {

            Transaction transaction = session.beginTransaction();
            try {
                session.update(updatedPerson);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                e.printStackTrace();
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePerson(int id) {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
             Session session = factory.openSession()) {

            Transaction transaction = session.beginTransaction();
            try {
                Person person = readPersonById(id);
                session.delete(person);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                e.printStackTrace();
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
