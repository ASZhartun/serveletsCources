package cot.anatoliy.controller.rest;

import cot.anatoliy.entity.Person;
import cot.anatoliy.repository.PersonRepository;
import cot.anatoliy.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/rest")
public class PersonRestController {

    @Autowired
    PersonService personService;
    @Autowired
    PersonRepository personRepository;

    @GetMapping("/getPerson/custom")
    public List<Person> getCustom(@RequestParam("name") String personName,
                                            @RequestParam("age") String personAge) {
        int age = Integer.parseInt(personAge);
        Optional<List<Person>> persons = personRepository.findByNameOrAge(personName, age);
        List<Person> personList = persons.orElse(new ArrayList<>());
        return personList;
    }

    @GetMapping("/getPerson/filter2")
    public List<Person> getListOfPersonById(@RequestParam("name") String personName,
                                            @RequestParam("ageFrom") String personAgeFrom,
                                            @RequestParam("ageTo") String personAgeTo) {
        int ageFrom = Integer.parseInt(personAgeFrom);
        int ageTo = Integer.parseInt(personAgeTo);
        Optional<List<Person>> persons = personRepository.findByNameOrAgeBetween(personName, ageFrom, ageTo);
        List<Person> personList = persons.orElse(new ArrayList<>());
        return personList;
    }

    @GetMapping("/getPerson/filter")
    public List<Person> getListOfPersonById(@RequestParam("name") String personName,
                                            @RequestParam("age") String personAge) {
        int age = Integer.parseInt(personAge);
        Optional<List<Person>> persons = personRepository.findByNameOrAge(personName, age);
        List<Person> personList = persons.orElse(new ArrayList<>());
        return personList;
    }

    @GetMapping("/getPerson/{name}")
    public List<Person> getListOfPersonById(@PathVariable("name") String personName) {
        Optional<List<Person>> persons = personRepository.findByName(personName);
        List<Person> personList = persons.orElse(new ArrayList<>());
        return personList;
    }

    @RequestMapping(value = "/firstPerson")
    public Person getFirstPersonFromList() {
        return new Person(1, "qwerty", 99);
    }

    @RequestMapping(value = "/personList")
    public List<Person> getList() {
        final List<Person> personList = personService.readAllPersons();
        return personList;
    }

    @GetMapping("/person/{id}")
    public Person getPersonById(@PathVariable("id") String paramId) {
        int id = Integer.parseInt(paramId);
        Person person = personService.readPersonById(id);
        return person;
    }

    @PostMapping("/addPerson") //TODO: DTO - data transfer object (all fields are string).
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

}
