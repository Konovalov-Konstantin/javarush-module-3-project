package ru.javarush.module3.quest.service;

import ru.javarush.module3.quest.entity.Answer;
import ru.javarush.module3.quest.entity.Question;

import java.util.List;

public class GameLogic {
    private final Initialization initialization;
    private final List<Question> questQuestions;
    private Integer questionId = 0;
    private Integer playerStep = 1;

    {
        initialization = new Initialization();
        questQuestions = initialization.initializeQuestionList();
    }

    private final int COUNTOFQUESTIONS = questQuestions.size() - 1;

    List<Answer> answersList = initialization.initAnswersList(questQuestions);

    public Integer checkAnswer(int inputQuestionId, String answer) {
        Integer result = -1;
        if (inputQuestionId >= 0 && inputQuestionId < COUNTOFQUESTIONS) {
            for (Answer ans : answersList) {
                if (ans.getTextAnswer().equals(answer)) {
                    if (ans.isNegative()) {
                        result = inputQuestionId += 1;
                    } else {
                        result = inputQuestionId += 2;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
        return result;
    }

    public Integer incrementPlayerStep() {
        return ++playerStep;
    }

    public String getQuestion(int questionId) {
        return questQuestions.get(questionId).getTextQuestion();
    }

    public Integer getPlayerStep() {
        return playerStep;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public List<Question> getQuestQuestions() {
        return questQuestions;
    }

    public int getCOUNTOFQUESTIONS() {
        return COUNTOFQUESTIONS;
    }

}
