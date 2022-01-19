package cot.anatoliy.servlets;

import cot.anatoliy.services.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeletePersonByIdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("deleteById"));
        new PersonService().deletePerson(id);
        req.getRequestDispatcher("/main").forward(req, resp);
    }
}
