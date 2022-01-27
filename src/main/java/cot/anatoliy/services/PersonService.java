package cot.anatoliy.services;

import cot.anatoliy.dao.PersonDao;
import cot.anatoliy.dao.PersonHibernateDao;
import cot.anatoliy.dao.PersonJdbcDao;
import cot.anatoliy.entity.Person;

import java.util.List;

/**
 * Logic for class Person in our app. It is isolated from Dao and Servlets.
 */
public class PersonService {
    private PersonDao personDao = new PersonHibernateDao();

    public void addPerson(Person person) {
        personDao.createPerson(person);
    }

    public List<Person> readAllPersons() {
        return this.personDao.readAllPersons();
    }

    public void deletePerson(int id) {
        personDao.deletePerson(id);
    }

    public void updatePerson(Person updatedPerson) {
        personDao.updatePerson(updatedPerson);
    }

    public Person readPersonById(int id) {
        return personDao.readPersonById(id);
    }
}
