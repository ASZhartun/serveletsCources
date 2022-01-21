package cot.anatoliy.dao;

import cot.anatoliy.entity.Developer;

import java.util.List;

public interface DeveloperDao {
    void createDeveloper(Developer developer);

    List<Developer> readAllDevelopers();

    Developer readDeveloperById(int id);
    
    void updateDeveloper(int id, Developer updatedDeveloper);

    void deleteDeveloper(int id);
}
