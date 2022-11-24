package ru.javarush.module3.quest.entity;

public class Answer {

    private String textAnswer;
    private boolean isLose;
    private boolean isNegative;
    private boolean isWin;

    public Answer(String textAnswer, boolean isLose, boolean isWin, boolean isNegative) {
        this.textAnswer = textAnswer;
        this.isLose = isLose;
        this.isWin = isWin;
        this.isNegative = isNegative;
    }

    public String getTextAnswer() {
        return textAnswer;
    }

    public boolean isNegative() {
        return isNegative;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer = (Answer) o;

        if (isLose != answer.isLose) {return false;}
        if (isNegative != answer.isNegative) {return false;}
        if (isWin != answer.isWin) {return false;}
        return textAnswer != null ? textAnswer.equals(answer.textAnswer) : answer.textAnswer == null;
    }

    @Override
    public int hashCode() {
        int result = textAnswer != null ? textAnswer.hashCode() : 0;
        result = 31 * result + (isLose ? 1 : 0);
        result = 31 * result + (isNegative ? 1 : 0);
        result = 31 * result + (isWin ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "textAnswer='" + textAnswer + '\'' +
                ", isLose=" + isLose +
                ", isNegative=" + isNegative +
                ", isWin=" + isWin +
                '}';
    }
}