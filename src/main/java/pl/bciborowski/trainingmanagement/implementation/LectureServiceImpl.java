package pl.bciborowski.trainingmanagement.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bciborowski.trainingmanagement.domain.Lecture;
import pl.bciborowski.trainingmanagement.repository.LectureRepository;
import pl.bciborowski.trainingmanagement.service.LectureService;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class LectureServiceImpl implements LectureService {

    @Autowired
    private LectureRepository lectureRepository;

    public LectureServiceImpl() {
    }

    @Override
    public List<Lecture> listAllLecture() {
        List<Lecture> result = new LinkedList<>();
        lectureRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Lecture getById(Integer id) {
        Optional<Lecture> result = lectureRepository.findById(id);
        return result.orElse(new Lecture());
    }

    @Override
    public Lecture save(Lecture lecture) {
        if (lecture != null) {
            return lectureRepository.save(lecture);
        } else {
            throw new RuntimeException("Nie mogę zapisać wykładu!!! Wypełnij wszystkie pola!!!");
        }
    }

    @Override
    public void delete(Integer id) {
        lectureRepository.delete(getById(id));
    }
}
