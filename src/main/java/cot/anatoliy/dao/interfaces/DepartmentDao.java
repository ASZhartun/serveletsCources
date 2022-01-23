package cot.anatoliy.dao.interfaces;

import cot.anatoliy.entity.Department;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentDao {
    void createDepartment(Department department);

    List<Department> readAllDepartments();

    Department readDepartmentById(int id);

    void updateDepartment(int id, String nameDepartment, String addressDepartment);

    void deleteDepartment(int id);
}
