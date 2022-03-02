package cot.anatoliy.dao;

import cot.anatoliy.dao.interfaces.PersonDao;
import cot.anatoliy.entity.Person;
import cot.anatoliy.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Component("PersonSpringDataJPADaoBean")
public class PersonSpringDataJPADao implements PersonDao {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public long createPerson(Person person) {
        Person save = personRepository.save(person);
        return save.getId();
    }

    @Override
    public List<Person> readAllPersons() {
        Iterable<Person> all = personRepository.findAll();
//        ArrayList<Person> people = new ArrayList<>();
//        Iterator<Person> iterator = all.iterator();
//        while (iterator.hasNext()) people.add(iterator.next());
//        return people;
        return (List<Person>) all;
    }

    @Override
    public Person readPersonById(int id) {
        Optional<Person> byId = personRepository.findById(id);
        return byId.orElse(new Person());
    }

    @Override
    public void updatePerson(Person updatedPerson) {
        personRepository.save(updatedPerson);
    }

    @Override
    public void deletePerson(int id) {
        personRepository.deleteById(id);
    }
}
