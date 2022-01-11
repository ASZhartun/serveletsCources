package cot.anatoliy.servlets;

import cot.anatoliy.entity.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainServlet extends HttpServlet {

    static List<Person> collect = Stream.of(
            new Person(100, "Tolya", 32),
            new Person(101, "Ivan", 43),
            new Person(102, "Dima", 45),
            new Person(103, "Zhenya", 55),
            new Person(104, "Yura", 21)
    ).collect(Collectors.toList());

    private int number = 1;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Person person = new Person(100, "Petrov Pavel Petrovich", 420);
//        req.setAttribute("samplePerson", person);

        req.setAttribute("personList", collect);
        req.setAttribute("message", number);
        number++;
        req.getRequestDispatcher("pages/index.jsp").forward(req, resp);
//        resp.sendRedirect(contextPath + "/pages/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("personList", collect);
        req.setAttribute("message", number);
        req.getRequestDispatcher("pages/index.jsp").forward(req, resp);
    }
}
