package cot.anatoliy.dao;

import cot.anatoliy.entity.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DepartmentJdbcDao implements DepartmentDao {

    public static void main(String[] args) {
        new DepartmentJdbcDao().createDepartment(Stream.of(
                new Department(61, "otdel1", "gomel"),
                new Department(62, "otdel2", "gomel"),
                new Department(63, "otdel3", "gomel"),
                new Department(64, "otdel4", "gomel")).collect(Collectors.toList()));
    }


    @Override
    public void createDepartment(Department department) throws SQLException {

//        String sql = "INSERT INTO `my_database`.`department` (`department_name`, `office_address`) " +
//                "VALUES ('" + department.getName() + "', " + department.getAddress() + " )";

        String sql = "INSERT INTO `my_database`.`department` (`department_id`, `department_name`, `office_address`) VALUES (?, ?, ?)";


        try (Connection connection = MySqlUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, department.getDepartmentId());
            statement.setString(2, department.getName());
            statement.setString(3, department.getAddress());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException(e);
        }
    }


    public void createDepartment(List<Department> departmentList) {
        Connection connection = null;
        try {
            connection = MySqlUtils.getConnection();

            //begin transaction
            connection.setAutoCommit(false);

            for (Department department : departmentList) {
                String sql = "INSERT INTO `my_database`.`department` (`department_id`, `department_name`, `office_address`) VALUES (?, ?, ?)";


                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setInt(1, department.getDepartmentId());
                    statement.setString(2, department.getName());
                    statement.setString(3, department.getAddress());
                    statement.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new SQLException(e);
                }
            }

            //commit transaction
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();

            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Department> readAllDepartments() {
        return null;
    }

    @Override
    public Department readDepartmentById(int id) {
        return null;
    }

    @Override
    public void updateDepartment(int id, Department updatedDepartment) {

    }

    @Override
    public void deleteDepartment(int id) {

    }
}
