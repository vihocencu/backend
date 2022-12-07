package com.flashcards.backend.entities;
import javax.persistence.*;
import java.util.Set;

//mark class as an Entity
@Entity
//defining class name as Table name
@Table
public class User
{
    //mark id as primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;
    //defining name as column name

    @Column
    private
    String name;
    
    @Column
    private String language;
    //defining age as column name
    @Column
    private int age;
    //defining email as column name
    @Column
    private String email;

    @Column
    private Boolean isAdmin;

    @Column
    private String secret;

    @Column
    private String secretAnswer;

    @OneToMany(mappedBy = "user")
    private Set<Statistic> statistic;

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getLanguage()
    {
        return language;
    }
    public void setLanguage(String name)
    {
        this.language = name;
    }
    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}