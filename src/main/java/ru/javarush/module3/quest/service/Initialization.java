package ru.javarush.module3.quest.service;

import ru.javarush.module3.quest.entity.Answer;
import ru.javarush.module3.quest.entity.Question;

import java.util.ArrayList;
import java.util.List;

public class Initialization {

    private final List<Question> questionList = new ArrayList<>();

    private final List<Answer> answersList = new ArrayList<>();

    public List<Question> initializeQuestionList() {
        questionList.add(
                new Question(0, "You've lost your memory. Accept the UFO challenge?",
                        List.of(new Answer("Take the challenge", false, false, false),
                                new Answer("Reject a call", false, false, true))));
        questionList.add(
                new Question(1, "You declined the call. Defeat.",
                        List.of(new Answer("", true, false, true),
                                new Answer("", true, false, true)
                        )));
        questionList.add(
                new Question(2, "You accepted the challenge. Will you go up to the captain's bridge?",
                        List.of(new Answer("Climb to the bridge", false, false, false),
                                new Answer("Refuse to go up to the bridge", false, false, true))));
        questionList.add(
                new Question(3, "You didn't negotiate. Defeat.",
                        List.of(new Answer("", true, false, true),
                                new Answer("", true, false, true)
                        )));
        questionList.add(
                new Question(4, "You went up to the bridge. Who are you?",
                        List.of(new Answer("Tell the truth about yourself", false, false, false),
                                new Answer("Lie about yourself", false, false, true))));
        questionList.add(
                new Question(5, "Your lies have been exposed. Defeat.",
                        List.of(new Answer("", true, false, true),
                                new Answer("", true, false, true)
                        )));
        questionList.add(
                new Question(6, "You've been brought home. Victory!",
                        List.of(new Answer("", false, true, true),
                                new Answer("", false, true, true)
                        )));
        return questionList;
    }

    public List<Answer> initAnswersList(List<Question> questionList) {
        for (Question questQuestion : questionList) {
            answersList.addAll(questQuestion.getAnswers());
        }
        return answersList;
    }

}