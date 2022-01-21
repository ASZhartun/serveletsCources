package cot.anatoliy.dao;

import cot.anatoliy.entity.Department;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentDao {
    void createDepartment(Department department) throws SQLException;

    List<Department> readAllDepartments();

    Department readDepartmentById(int id);

    void updateDepartment(int id, Department updatedDepartment);

    void deleteDepartment(int id);
}
