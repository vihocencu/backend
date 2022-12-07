package com.flashcards.backend.entities;

import javax.persistence.*;

@Entity
//defining class name as Table name
@Table
public class Statistic
{
    //mark id as primary key
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    //defining name as column name
    @ManyToOne
    @JoinColumn(name="challenge_id", nullable=false)
    private Challenge challenge;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private int correct;

    @Column
    private int hint;

    @Column
    private String question;

    @Column
    private String answer;
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

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

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int richtig) {
        this.correct = richtig;
    }
}