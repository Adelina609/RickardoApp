package ru.kpfu.itis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.models.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class QuestionRepository {
    private static List<Question> questions  = new ArrayList();
    private static int count = 0;

    public void addAll(){
        questions.add(new Question(0,"src/main/assets/img/q1-1.jpg", "src/main/assets/img/q1-2.jpg","src/main/assets/img/q1-3.jpg","src/main/assets/img/q1-4.jpg","СОБАКА"));
        questions.add(new Question(0,"src/main/assets/img/q2-1.jpg", "src/main/assets/img/q2-2.jpg","src/main/assets/img/q2-3.jpg","src/main/assets/img/q2-4.jpg","ТУБЕТЕЙ"));
    }

    public Question getQuestion(){
        Question question = questions.get(count);
        count++;
        return question;
    }
}
