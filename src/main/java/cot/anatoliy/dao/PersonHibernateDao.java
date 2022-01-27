package cot.anatoliy.dao;

import cot.anatoliy.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class PersonHibernateDao implements PersonDao {


    public static void main(String[] args) {
        final PersonHibernateDao personHibernateDao = new PersonHibernateDao();
        personHibernateDao.createPerson(new Person("Zhora", 77));
    }

    @Override
    public void createPerson(Person person) {
        final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
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
        return null;
    }

    @Override
    public Person readPersonById(int id) {
        return null;
    }

    @Override
    public void updatePerson(Person updatedPerson) {

    }

    @Override
    public void deletePerson(int id) {

    }
}
