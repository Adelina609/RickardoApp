package ru.kpfu.itis.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "questions")
public class Question {
    private String img1;
    private String img2;
    private String img3;
    private String img4;
    private String answer;
}
