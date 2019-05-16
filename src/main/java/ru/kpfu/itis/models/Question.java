package ru.kpfu.itis.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Question {

    private int id;

    private String img;

    private String answer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Question(int id, String img, String answer) {
        this.id = id;
        this.img = img;
        this.answer = answer;
    }
}
