package cot.anatoliy.servlets;

import cot.anatoliy.entity.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddNewPerson extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("http://localhost:8080/servlets-app/pages/create.html");
//        req.getRequestDispatcher("pages/create.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Create new Entity!");
        System.out.println("With next params:");
        Integer idParam = Integer.parseInt(req.getParameter("idParam"));
        String nameParam = req.getParameter("nameParam");
        Integer ageParam = Integer.parseInt(req.getParameter("ageParam"));

        Person newPerson = new Person(generateId(), nameParam, ageParam);
        MainServlet.collect.add(newPerson);



        System.out.println(idParam + nameParam + ageParam);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/servlets-app/main");
//        req.getRequestDispatcher("/main").forward(req, resp);

    }

    private int generateId() {
        return 999;
    }
}
