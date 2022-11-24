package ru.javarush.module3.quest.entity;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private Integer id;
    private String textQuestion;
    private List<Answer> answers;

    public Question(Integer id, String textQuestion, List<Answer> answers) {
        this.id = id;
        this.textQuestion = textQuestion;
        this.answers = answers;
    }

    public List<String> getAnswersAsString() {
        List<String> listAnswers = new ArrayList<>();
        for (Answer answer : answers) {
            listAnswers.add(answer.getTextAnswer());
        }
        return listAnswers;
    }

    public Integer getId() {
        return id;
    }

    public String getTextQuestion() {
        return textQuestion;
    }

    public List<Answer> getAnswers(){
        return answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {return false;}

        Question question = (Question) o;

        if (id != null ? !id.equals(question.id) : question.id != null) {return false;}
        if (textQuestion != null ? !textQuestion.equals(question.textQuestion) : question.textQuestion != null)
        {return false;}
        return answers != null ? answers.equals(question.answers) : question.answers == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (textQuestion != null ? textQuestion.hashCode() : 0);
        result = 31 * result + (answers != null ? answers.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", textQuestion='" + textQuestion + '\'' +
                ", answers=" + answers +
                '}';
    }
}