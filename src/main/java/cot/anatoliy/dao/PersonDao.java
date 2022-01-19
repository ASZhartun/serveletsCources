package cot.anatoliy.dao;

import cot.anatoliy.entity.Person;

import java.util.List;

public interface PersonDao {
    // create, read, update, delete
    void createPerson(Person person);

    List<Person> readAllPersons();

    Person readPersonById(int id);
//
//    void updatePerson(int id);

    void deletePerson(int id);
}
