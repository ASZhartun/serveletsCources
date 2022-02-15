package cot.anatoliy.controller.rest;

import cot.anatoliy.entity.Person;
import cot.anatoliy.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/rest")
public class PersonRestController {
    @Autowired
    PersonService personService;

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

    @PostMapping("/addPerson")
    @ResponseBody
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

}
