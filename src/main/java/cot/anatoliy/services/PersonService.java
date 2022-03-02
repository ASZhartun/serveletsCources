package cot.anatoliy.services;

import cot.anatoliy.dao.PersonHibernateDao;
import cot.anatoliy.dao.interfaces.PersonDao;
import cot.anatoliy.dao.PersonJdbcDao;
import cot.anatoliy.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Logic for class Person in our app. It is isolated from Dao and Servlets.
 */
@Service
public class PersonService {
    //    private PersonDao personDao = new PersonJdbcDao();
    //    @Qualifier(value = "PersonHibernateDaoBean")
    @Autowired
    @Qualifier(value = "PersonSpringDataJPADaoBean")
    private PersonDao personDao;

    public void addPerson(Person person) {
        personDao.createPerson(person);
    }

    public List<Person> readAllPersons() {
        return this.personDao.readAllPersons();
    }

    public void deletePerson(int id) {
        personDao.deletePerson(id);
    }

    public void updatePerson(int id, String name, int age) {
        final Person updatedPerson = new Person(id, name, age);
        personDao.updatePerson(updatedPerson);
    }

    public Person readPersonById(int id) {
        return personDao.readPersonById(id);
    }
}
