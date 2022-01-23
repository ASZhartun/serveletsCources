package cot.anatoliy.services;

import cot.anatoliy.dao.DepartmentJdbcDao;
import cot.anatoliy.dao.interfaces.DepartmentDao;
import cot.anatoliy.entity.Department;

import java.util.List;

public class DepartmentService {
    private DepartmentDao departmentDao = new DepartmentJdbcDao();

    public void addDepartment(Department department) {
        departmentDao.createDepartment(department);
    }

    public List<Department> readAllDepartments() {
        return this.departmentDao.readAllDepartments();
    }

    public void deleteDepartment(int id) {
        departmentDao.deleteDepartment(id);
    }

    public void updateDepartment(int id, String name, String address) {
        departmentDao.updateDepartment(id, name, address);
    }

    public Department readDepartmentById(int id) {
        return departmentDao.readDepartmentById(id);
    }
}
