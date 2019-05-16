package ru.kpfu.itis.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.models.Question;
import ru.kpfu.itis.repository.QuestionRepository;
import ru.kpfu.itis.utils.Utils;

import java.util.List;

@ComponentScan("ru.kpfu.itis.models")
@ComponentScan("ru.kpfu.itis.repository")
@Service
public class QuestionService {

    static Question existQuestion;

    private QuestionRepository questionRepository = new QuestionRepository();

    public Question getNewQuestion(){
        existQuestion = questionRepository.getQuestion();
        return existQuestion;
    }


    public Question getExistQuestion(){
        return existQuestion;
    }

    public void addAll(){
        questionRepository.addAll();
    }
    //experimental
//    public List<Question> getAll(){
//        return Utils.fillQuestions();
//    }
//
//    public boolean isRightAnswer(Long id, String answer){
//        Question questionFromRepo = getQuestion(id);
//        return questionFromRepo
//                .getAnswer().equals(answer);
//    }
}
