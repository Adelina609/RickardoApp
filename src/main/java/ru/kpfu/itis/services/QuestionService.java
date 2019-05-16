package ru.kpfu.itis.services;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.models.Question;
import ru.kpfu.itis.repository.QuestionRepository;

@ComponentScan("ru.kpfu.itis.models")
@ComponentScan("ru.kpfu.itis.repository")
@Service
public class QuestionService {

    private static Question existingQuestion;

    private QuestionRepository questionRepository = new QuestionRepository();

    public Question getNewQuestion(){
        existingQuestion = questionRepository.getQuestion();
        return existingQuestion;
    }

    public Question getExistQuestion(){
        return existingQuestion;
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
