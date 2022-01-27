package cot.anatoliy.dao;

import cot.anatoliy.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class PersonHibernateDao implements PersonDao {
    private final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
        final PersonHibernateDao personHibernateDao = new PersonHibernateDao();
//        personHibernateDao.createPerson(new Person("Zhora", 77));
        System.out.println(personHibernateDao.readPersonById(12));
        final Person person = personHibernateDao.readPersonById(13);
        person.setAge(44);
        person.setName("Sarah Connor");
        personHibernateDao.updatePerson(person);
        personHibernateDao.deletePerson(13);
    }

    @Override
    public void createPerson(Person person) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            // do something
            session.save(person);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public List<Person> readAllPersons() {
        List<Person> personList = new ArrayList<>();
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            personList.addAll(session.createQuery("from person").list());
        }
        return personList;
    }

    @Override
    public Person readPersonById(int id) {
        Transaction transaction = null;
        Person person = new Person();
        try (Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            person = session.get(Person.class, id);
        }
        return person;
    }

    @Override
    public void updatePerson(Person updatedPerson) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            // do something
            session.update(updatedPerson);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deletePerson(int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            // do something
            session.delete(readPersonById(id));
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
