package cot.anatoliy.dao.interfaces;

import cot.anatoliy.entity.Person;

import java.util.List;

public interface PersonDao {
    // create, read, update, delete
    long createPerson(Person person);

    List<Person> readAllPersons();

    Person readPersonById(int id);
//
    void updatePerson(Person updatedPerson);

    void deletePerson(int id);
}
