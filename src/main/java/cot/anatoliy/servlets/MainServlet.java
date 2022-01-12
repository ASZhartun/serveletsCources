package cot.anatoliy.servlets;

import cot.anatoliy.entity.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainServlet extends HttpServlet {
    private static List<Person> personList;
    private static long id;

    static {
        personList = new ArrayList<>();
    }

    public static long getId() {
        id = 1;
        if (personList.size() == 0) return id;
        if (personList.get(0).getId() != id) return id;
        id++;
        for (int i = 1; i < personList.size(); i++) {
            if (personList.get(i).getId() != id) return id;
            id++;
        }
        return id;
    }

    public static Person getPersonById(long id) {
        for (Person person :
                personList) {
            if (person.getId() == id) return person;
        }
        return null;
    }

    private static void sort() {
        personList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                String byO1 = String.valueOf(o1.getId());
                String byO2 = String.valueOf(o2.getId());
                return byO1.compareTo(byO2);
            }
        });
    }

    public static void addPerson(Person person) {
        personList.add(person);
        sort();
    }

    public static void deletePersonById(long id) {
        for (Person personToDelete :
                personList) {
            if (personToDelete.getId() == id) {
                personList.remove(personToDelete);
                break;
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("ListOfPerson", personList);
        req.getRequestDispatcher("/pages/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/servlets-app/main");
    }

}
