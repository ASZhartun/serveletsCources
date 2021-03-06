package cot.anatoliy.dao;

import cot.anatoliy.entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * JdbcDao is using for connect application with DB. It is isolated from servlets(web) and logic(services).
 */
public class PersonJdbcDao implements PersonDao {

    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/my_database";
    public static final String JDBC_USER = "root";
    public static final String JDBC_PASSWORD = "root";
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    public static void main(String[] args) {
//        new PersonJdbcDao().readAllPersons();
        new PersonJdbcDao().createPerson(null);
    }

    @Override
    public void createPerson(Person person) {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);) {
            Statement statement = connection.createStatement();
            String sql = sqlBuildInsert(person);
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
    }

    @Override
    public List<Person> readAllPersons() {
        List<Person> personList = new ArrayList<>();
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            Statement statement = connection.createStatement();
            String sql = "select * from my_database.person;";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id_person");
                String name = resultSet.getString("name_person");
                int age = resultSet.getInt("age_person");
                personList.add(new Person(id, name, age));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personList;
    }

    @Override
    public Person readPersonById(int id) {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery("select * from my_database.person where id_person=" + id);
            if (resultSet.next()) {
                int id_person = resultSet.getInt(1);
                String name_person = resultSet.getString(2);
                int age_person = resultSet.getInt(3);
                return new Person(id_person, name_person, age_person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deletePerson(int id) {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            Statement statement = connection.createStatement();
            statement.execute(sqlBuildDelete(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updatePerson(int id, Person updatedPerson) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            final Statement statement = connection.createStatement();
            String sql = sqlBuildUpdate(id, updatedPerson);
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String sqlBuildUpdate(int id, Person updatedPerson) {
        Person person = readPersonById(id);
        final StringBuilder sql = new StringBuilder();
        if (person != null) {
            sql.append("UPDATE `my_database`.`person` SET `name_person` = '")
                    .append(updatedPerson.getName())
                    .append("', `age_person` = '")
                    .append(updatedPerson.getAge())
                    .append("' WHERE (`id_person` = '")
                    .append(id)
                    .append("');");
        }
        return sql.toString();
    }

    private String sqlBuildInsert(Person person) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO `my_database`.`person` (`name_person`, `age_person`) VALUES ('");
        sql.append(person.getName());
        sql.append("', '").append(person.getAge()).append("');");
        return sql.toString();
    }

    private String sqlBuildDelete(int id) {
        String opa = "DELETE FROM `my_database`.`person` WHERE (`id_person` = '13');\n";
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM `my_database`.`person` WHERE (`id_person` = '")
                .append(id)
                .append("');");
        return sql.toString();
    }
}
