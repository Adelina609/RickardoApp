package ru.kpfu.itis.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "questions")
public class Question {
    private int id;
    private String img;
    private String answer;
}
