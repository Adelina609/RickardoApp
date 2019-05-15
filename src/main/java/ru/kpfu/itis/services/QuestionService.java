package ru.kpfu.itis.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.models.Question;
import ru.kpfu.itis.repository.QuestionRepository;

@ComponentScan("ru.kpfu.itis.models")
@ComponentScan("ru.kpfu.itis.repository")
@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public Question getQuestion(Long id){
        return questionRepository.findById(id).get();
    }

    public boolean isRightAnswer(Long id, String answer){
        Question questionFromRepo =
                questionRepository.findById(id).get();
        return questionFromRepo.getAnswer().equals(answer);
    }
}
