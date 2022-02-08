package cot.anatoliy.controller;

import cot.anatoliy.entity.Person;
import cot.anatoliy.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/mvc/person")
public class PersonController {

//    @Autowired
//    PersonService personService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getPersonListPage(Model model) {
        PersonService personService = new PersonService();
        List<Person> personList = personService.readAllPersons();
        model.addAttribute("ListOfPerson", personList);
        return "index";
    }


    @GetMapping("/list2")
    public ModelAndView getPersonListPage2() {
        PersonService personService = new PersonService();
        List<Person> personList = personService.readAllPersons();

        ModelAndView mav = new ModelAndView();
        mav.addObject("ListOfPerson", personList);
        mav.setViewName("index");

        return mav;
    }


    @PostMapping("/bla")
    public String methodA(@RequestParam("deleteIdParam") String deleteIdVariable){
        int id = Integer.parseInt(deleteIdVariable);
        new PersonService().deletePerson(id);
        return "forward:/mvc/person/list";
//        return "redirect:/mvc/person/list";
    }

}
