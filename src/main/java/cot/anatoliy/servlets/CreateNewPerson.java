package cot.anatoliy.servlets;

import cot.anatoliy.entity.Person;
import cot.anatoliy.services.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateNewPerson extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("welcomeMessage", "Add new person:");
        req.setAttribute("requestName", "/servlets-app/createPerson");
        req.getRequestDispatcher("/pages/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PersonService personService = new PersonService();
        String name = req.getParameter("nameParam");
        int age = Integer.parseInt(req.getParameter("ageParam"));
        personService.addPerson(new Person(name,age));
        req.getRequestDispatcher("/main").forward(req, resp);
    }

}
