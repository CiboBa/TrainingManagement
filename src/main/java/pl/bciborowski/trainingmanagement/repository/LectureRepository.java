package pl.bciborowski.trainingmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import pl.bciborowski.trainingmanagement.domain.Lecture;

public interface LectureRepository extends CrudRepository<Lecture, Integer> {
}
