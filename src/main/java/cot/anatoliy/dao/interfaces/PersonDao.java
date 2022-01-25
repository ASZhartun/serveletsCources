package cot.anatoliy.dao.interfaces;

import cot.anatoliy.entity.Person;

import java.util.List;

public interface PersonDao {
    // create, read, update, delete
    long createPerson(Person person);

    List<Person> readAllPersons();

    Person readPersonById(long id);
//
    void updatePerson(long id, Person updatedPerson);

    void deletePerson(long id);
}
