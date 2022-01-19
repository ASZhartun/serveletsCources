package cot.anatoliy.servlets;

import cot.anatoliy.entity.Person;
import cot.anatoliy.services.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdatePersonByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("welcomeMessage", "Update chosen person:");
        req.setAttribute("requestName", "/servlets-app/update");
        PersonService personService = new PersonService();
        Person person = personService.readPersonById(Integer.parseInt(req.getParameter("updateById")));
        req.setAttribute("nameParam",person.getName());
        req.setAttribute("ageParam",person.getAge());
        req.setAttribute("personId", person.getId());
        req.getRequestDispatcher("/pages/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/main").forward(req, resp);
    }
}
