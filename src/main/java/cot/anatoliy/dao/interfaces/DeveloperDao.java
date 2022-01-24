package cot.anatoliy.dao.interfaces;

import cot.anatoliy.entity.Developer;

import java.util.List;

public interface DeveloperDao {
    void createDeveloper(Developer developer);

    List<Developer> readAllDevelopers();

    Developer readDeveloperById(int id);
    
    void updateDeveloper(int id, String name, int salary, int departmentIdFk);

    void deleteDeveloper(int id);
}
