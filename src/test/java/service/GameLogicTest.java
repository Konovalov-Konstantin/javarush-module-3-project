package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import ru.javarush.module3.quest.entity.Question;
import ru.javarush.module3.quest.service.GameLogic;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameLogicTest {

    GameLogic gameLogic;

    @BeforeEach
    void init() {
        gameLogic = new GameLogic();
    }

    @ParameterizedTest
    @CsvSource({"0, Take the challenge, 2",
            "0, Reject a call, 1"})
    void checkAnswerShouldReturnNextQuestionIDIfGivenCorrectPositiveOrNegativeAnswer(int questionID, String answer,
                                                                                     int nextQuestionID) {
        assertEquals(nextQuestionID, gameLogic.checkAnswer(questionID, answer));
    }

    @Test
    void checkAnswerShouldReturnMinusOneIfGivenIncorrectAnswer() {
        Integer answer = gameLogic.checkAnswer(0, "Incorrect answer");
        assertEquals(-1, answer);
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, 100})
    void checkAnswerShouldThrowExceptionIfGivenIncorrectQuestionID(Integer argument) {
        assertThrows(IllegalArgumentException.class, () -> {
            gameLogic.checkAnswer(argument, "Take the challenge");
        });
    }

    @ParameterizedTest
    @NullSource
    void checkAnswerShouldThrowExceptionIfQuestionIDIsNull(Integer argument) {
        assertThrows(NullPointerException.class, () -> {
                    gameLogic.checkAnswer(argument, "Some answer");
                }
        );
    }

    @Test
    void incrementPlayerStepShouldIncreasePlayerstep() {
        assertEquals(2, gameLogic.incrementPlayerStep());
    }

    @Test
    void getQuestionShouldReturnTextOfQuestionById() {
        List<Question> questionList = List.of(
                new Question(0, "You've lost your memory. Accept the UFO challenge?", null));

        assertEquals("You've lost your memory. Accept the UFO challenge?", gameLogic.getQuestion(0));
    }

    @Test
    void getQuestQuestionsShouldReturnListOfQuestions() {

        GameLogic gameLogic = Mockito.mock(GameLogic.class);

        List<Question> expectedList = List.of(
                new Question(0, "You've lost your memory. Accept the UFO challenge?", null),
                new Question(1, "You declined the call. Defeat.", null));

        Mockito.doReturn(expectedList).when(gameLogic).getQuestQuestions();

        assertEquals(expectedList, gameLogic.getQuestQuestions());

    }


}