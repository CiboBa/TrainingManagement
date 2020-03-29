package pl.bciborowski.trainingmanagement.service;

import pl.bciborowski.trainingmanagement.domain.Course;

import java.util.List;

public interface CourseService {

    List<Course> listAllCourse();

    Course getById(Integer id);

    Course save(Course course);

    void delete(Integer id);
}
