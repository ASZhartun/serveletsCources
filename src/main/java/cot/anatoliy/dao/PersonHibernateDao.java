package cot.anatoliy.dao;

import cot.anatoliy.dao.interfaces.PersonDao;
import cot.anatoliy.entity.Person;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PersonHibernateDao implements PersonDao {
    public static void main(String[] args) {
        PersonHibernateDao personHibernateDao = new PersonHibernateDao();
        long generatedId = personHibernateDao.createPerson(new Person(
                "Pushkin", 777
        ));
        Person person = personHibernateDao.readPersonById(generatedId);
        person.setAge(444);
        person.setName("Bonch");
        personHibernateDao.updatePerson(generatedId, person);
        personHibernateDao.deletePerson(generatedId);
        List<Person> personList = personHibernateDao.readAllPersons();
        personList.forEach(System.out::println);
    }

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
    public Person readPersonById(long id) {
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
    public void updatePerson(long id, Person updatedPerson) {
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
    public void deletePerson(long id) {
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
