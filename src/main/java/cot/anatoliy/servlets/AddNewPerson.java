package cot.anatoliy.servlets;

import cot.anatoliy.entity.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddNewPerson extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("welcomeMessage", "Add new person:");
        req.setAttribute("requestName", "/servlets-app/createPerson");
        req.getRequestDispatcher("/pages/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameParam = req.getParameter("nameParam");
        int ageParam = 0;
        try {
            ageParam = Integer.parseInt(req.getParameter("ageParam"));
        } catch (NumberFormatException e) {
            req.getRequestDispatcher("/main").forward(req, resp);
            return;
        }
        if (!"".equals(nameParam) && ageParam > 0) {
            Person person = new Person(MainServlet.getId(), nameParam, ageParam);
            MainServlet.addPerson(person);
        }
        req.getRequestDispatcher("/main").forward(req, resp);
    }

}
