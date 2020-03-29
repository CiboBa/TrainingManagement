package pl.bciborowski.trainingmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import pl.bciborowski.trainingmanagement.domain.Course;

public interface CourseRepository extends CrudRepository<Course, Integer> {
}
