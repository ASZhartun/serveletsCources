package cot.anatoliy.dao.interfaces;


import cot.anatoliy.entity.Teacher;

import java.util.List;

public interface TeacherDao {
    // create, read, update, delete
    void createTeacher(Teacher person);

    List<Teacher> readAllTeachers();

    Teacher readTeacherById(long id);
    //
    void updateTeacher(Teacher updatedTeacher);

    void deleteTeacher(int id);
}
