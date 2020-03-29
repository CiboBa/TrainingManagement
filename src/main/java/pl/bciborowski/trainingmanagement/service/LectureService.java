package pl.bciborowski.trainingmanagement.service;

import pl.bciborowski.trainingmanagement.domain.Lecture;

import java.util.List;

public interface LectureService {

    List<Lecture> listAllLecture();

    Lecture getById(Integer id);

    Lecture save(Lecture lecture);

    void delete(Integer id);
}
