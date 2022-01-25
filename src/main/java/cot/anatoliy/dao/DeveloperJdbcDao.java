package cot.anatoliy.dao;
import cot.anatoliy.dao.interfaces.DeveloperDao;
import cot.anatoliy.entity.Developer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeveloperJdbcDao implements DeveloperDao {

//    public static void main(String[] args) {
//        final DeveloperJdbcDao devDao = new DeveloperJdbcDao();
//        devDao.createDeveloper(new Developer("Novikov", 2990, 2));
//        devDao.readAllDevelopers().stream().forEach(System.out::println);
//        devDao.updateDeveloper(11, "Bonch-Bruevich", 6000, 1);
//        devDao.deleteDeveloper(8);
//        devDao.deleteDeveloper(9);
//        devDao.deleteDeveloper(10);
//        System.out.println();
//        System.out.println("NO NOVIKOVES! In my list!");
//        devDao.readAllDevelopers().stream().forEach(System.out::println);
//    }

    @Override
    public void createDeveloper(Developer developer) {
        String sql = "INSERT INTO `my_database`.`developer` (`developer_name`, `developer_salary`, `department_id_fk`) VALUES (?, ?, ?);\n";
        try (Connection connection = MySqlUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, developer.getName());
            preparedStatement.setInt(2, developer.getSalary());
            preparedStatement.setInt(3, developer.getDepartmentIdFk());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Developer> readAllDevelopers() {
        String sql = "select * from my_database.developer";
        final ArrayList<Developer> developers = new ArrayList<>();
        try (Connection connection = MySqlUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int developerId = resultSet.getInt("developer_id");
                String developerName = resultSet.getString("developer_name");
                Integer developerSalary = resultSet.getInt("developer_salary");
                Integer departmentIdFk = resultSet.getInt("department_id_fk");
                developers.add(new Developer(developerId, developerName, developerSalary, departmentIdFk));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developers;
    }

    @Override
    public Developer readDeveloperById(int id) {
        String sql = "select * from my_database.developer where developer_id=?";
        try (Connection connection = MySqlUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int developerId = resultSet.getInt("developer_id");
                String developerName = resultSet.getString("developer_name");
                Integer developerSalary = resultSet.getInt("developer_salary");
                Integer departmentIdFk = resultSet.getInt("department_id_fk");
                return new Developer(developerId, developerName, developerSalary, departmentIdFk);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateDeveloper(int id, String developerName, int developerSalary, int departmentIdFk) {
        String sql = "UPDATE `my_database`.`developer` SET `developer_name` = ?, `developer_salary` = ?,`department_id_fk`=? WHERE (`developer_id` = ?);\n";
        try (Connection connection = MySqlUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, developerName);
            preparedStatement.setInt(2, developerSalary);
            preparedStatement.setInt(3, departmentIdFk);
            preparedStatement.setInt(4, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDeveloper(int id) {
        String sql = "DELETE FROM `my_database`.`developer` WHERE (`developer_id` = ?);\n";
        try (Connection connection = MySqlUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
