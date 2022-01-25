package cot.anatoliy.dao;

import cot.anatoliy.dao.interfaces.PersonDao;
import cot.anatoliy.entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * JdbcDao is using for connect application with DB. It is isolated from servlets(web) and logic(services).
 */
public class PersonJdbcDao implements PersonDao {

    public static void main(String[] args) {
        new PersonJdbcDao().createPerson(new Person("bolvan", 1050));
    }

    @Override
    public long createPerson(Person person) {
        try (Connection connection = MySqlUtils.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = sqlBuildInsert(person);
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }


    @Override
    public List<Person> readAllPersons() {
        List<Person> personList = new ArrayList<>();
        try (Connection connection = MySqlUtils.getConnection();
                Statement statement = connection.createStatement()) {

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
    public Person readPersonById(long id) {
        try (Connection connection = MySqlUtils.getConnection();
             Statement statement = connection.createStatement()) {
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
    public void deletePerson(long id) {

        try (Connection connection = MySqlUtils.getConnection();
             Statement statement = connection.createStatement()){
            statement.execute(sqlBuildDelete(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updatePerson(long id, Person updatedPerson) {

        try (Connection connection = MySqlUtils.getConnection();
             Statement statement = connection.createStatement()){
            String sql = sqlBuildUpdate(id, updatedPerson);
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String sqlBuildUpdate(long id, Person updatedPerson) {
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
        sql.append("', ").append(person.getAge()).append(");");
        return sql.toString();
    }

    private String sqlBuildDelete(long id) {
        String opa = "DELETE FROM `my_database`.`person` WHERE (`id_person` = '13');\n";
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM `my_database`.`person` WHERE (`id_person` = '")
                .append(id)
                .append("');");
        return sql.toString();
    }
}
