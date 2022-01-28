package cot.anatoliy.dao.interfaces;


import cot.anatoliy.entity.Teacher;

import java.util.List;

public interface TeacherDao {
    // create, read, update, delete
    int createTeacher(Teacher person);

    List<Teacher> readAllTeachers();

    Teacher readTeacherById(long id);
    //
    void updateTeacher(int id, Teacher updatedTeacher);

    void deleteTeacher(int id);
}
