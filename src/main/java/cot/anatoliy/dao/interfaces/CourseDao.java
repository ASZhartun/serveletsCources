package cot.anatoliy.dao.interfaces;

import cot.anatoliy.entity.Course;

import java.util.List;

public interface CourseDao {
    // create, read, update, delete
    int createCourse(Course person);

    List<Course> readAllCourses();

    Course readCourseById(int id);
    //
    void updateCourse(int id, Course updatedCourse);

    void deleteCourse(int id);
}
