package com.flashcards.backend.entities;
import javax.persistence.*;

//mark class as an Entity
@Entity
//defining class name as Table name
@Table
public class Challenge
{
    //mark id as primary key
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column
    private String question;

    @Column
    private String answer;
    
    @ManyToOne
    @JoinColumn(name="lesson_id", nullable=false)
    private Lesson lesson;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}