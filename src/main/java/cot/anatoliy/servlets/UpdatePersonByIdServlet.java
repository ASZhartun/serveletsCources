package cot.anatoliy.servlets;

import cot.anatoliy.entity.Person;

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
        long personId = Long.parseLong(req.getParameter("updateById"));
        Person personById = MainServlet.getPersonById(personId);
        if (personById != null) {
            req.setAttribute("nameValue", personById.getName());
            req.setAttribute("ageValue", personById.getAge());
            req.setAttribute("personId", personById.getId());
        }
        req.getRequestDispatcher("/pages/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int ageChanged = Integer.parseInt(req.getParameter("ageParam"));
        if (ageChanged > 0) {
            long personId = Long.parseLong(req.getParameter("personId"));
            Person person = MainServlet.getPersonById(personId);
            try {
                if (person != null) {
                    person.setName(req.getParameter("nameParam"));
                    person.setAge(Integer.parseInt(req.getParameter("ageParam")));
                }
            } catch (Exception e) {
                System.out.println("Something wrong!");
            } finally {
                req.getRequestDispatcher("/main").forward(req, resp);
            }
        }
        else req.getRequestDispatcher("/main").forward(req, resp);



    }
}
