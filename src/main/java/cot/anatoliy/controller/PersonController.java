package cot.anatoliy.controller;

import cot.anatoliy.entity.Person;
import cot.anatoliy.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
//@RequestMapping("/mvc/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/main")
    public String getPersonListPage(Model model) {
//        PersonService personService = new PersonService();
        final List<Person> personList = personService.readAllPersons();
        model.addAttribute("ListOfPerson", personList);
        return "index";
    }

    @PostMapping(value = "/main")
    public ModelAndView postPersonListPage(Model model) {
        return new ModelAndView("redirect:/main");
    }

    @GetMapping(value = "/createPerson")
    public String getCreateNewPersonPage(Model model) {
        model.addAttribute("welcomeMessage", "Add new person:");
        model.addAttribute("requestName", "/servlets-app/createPerson");
        return "create";
    }

    @PostMapping(value = "/createPerson")
    public ModelAndView createPerson(@RequestParam(name = "nameParam") String name,
                                     @RequestParam(name = "ageParam") int age) {
//        PersonService personService = new PersonService();
        personService.addPerson(new Person(name, age));
        return new ModelAndView("forward:/main");
    }

    @GetMapping(value = "/update")
    public String getUpdatePersonPage(Model model,
                                      @RequestParam(name = "updateById") int id) {
        model.addAttribute("welcomeMessage", "Update person:");
        model.addAttribute("requestName", "/servlets-app/updatePerson");
//        PersonService personService = new PersonService();
        final Person person = personService.readPersonById(id);
        model.addAttribute("nameValue", person.getName());
        model.addAttribute("ageValue", person.getAge());
        model.addAttribute("personId", id);
        return "create";
    }

    @PostMapping(value = "/updatePerson")
    public ModelAndView updatePerson(@RequestParam(name = "nameParam") String name,
                                     @RequestParam(name = "ageParam") int age,
                                     @RequestParam(name = "personId") int id) {
//        PersonService personService = new PersonService();
        personService.updatePerson(id, name, age);
        return new ModelAndView("forward:/main");
    }

    @PostMapping(value = "/delete")
    public ModelAndView deletePerson(Model model,
                                     @RequestParam(name = "deleteById") int id) {
//        PersonService personService = new PersonService();
        personService.deletePerson(id);
        return new ModelAndView("forward:/main");
    }
}
