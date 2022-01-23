package cot.anatoliy.dao;

import cot.anatoliy.dao.interfaces.DepartmentDao;
import cot.anatoliy.entity.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DepartmentJdbcDao implements DepartmentDao {

    public static void main(String[] args) {
        new DepartmentJdbcDao().updateDepartment(19, "Geologists", "Moscow");
    }

    @Override
    public void createDepartment(Department department) {
        String sql = "INSERT INTO `my_database`.`department` (`department_name`, `department_address`) VALUES (?, ?);\n";
        try (Connection connection = MySqlUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, department.getName());
            preparedStatement.setString(2, department.getAddress());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void createDepartment(List<Department> departmentList) {
        String sql = "INSERT INTO `my_database`.`department` (`department_name`, `department_address`) VALUES (?, ?);\n";
        try (Connection connection = MySqlUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            connection.setAutoCommit(false);
            for (Department department :
                    departmentList) {
                preparedStatement.setString(1, department.getName());
                preparedStatement.setString(2, department.getAddress());
                preparedStatement.execute();
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Department> readAllDepartments() {
        String sql = "select * from my_database.department";
        final ArrayList<Department> departments = new ArrayList<>();
        try (Connection connection = MySqlUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int department_id = resultSet.getInt("department_id");
                String department_name = resultSet.getString("department_name");
                String department_address = resultSet.getString("department_address");
                departments.add(new Department(department_id, department_name, department_address));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
    }

    @Override
    public Department readDepartmentById(int id) {
        String sql = "select * from my_database.department where id_department=?";
        try (Connection connection = MySqlUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int department_id = resultSet.getInt("department_id");
                String department_name = resultSet.getString("department_name");
                String department_address = resultSet.getString("department_address");
                return new Department(department_id, department_name, department_address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateDepartment(int id, String nameDepartment, String addressDepartment) {
        String sql = "UPDATE `my_database`.`department` SET `department_name` = ?, `department_address` = ? WHERE (`department_id` = ?);\n";
        try (Connection connection = MySqlUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, nameDepartment);
            preparedStatement.setString(2, addressDepartment);
            preparedStatement.setInt(3, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDepartment(int id) {
        String sql = "DELETE FROM `my_database`.`department` WHERE (`department_id` = ?);\n";
        try (Connection connection = MySqlUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
