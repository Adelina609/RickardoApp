package ru.kpfu.itis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.models.Question;
import java.util.Optional;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {

    @Override
    Optional<Question> findById(Long aLong);
}
