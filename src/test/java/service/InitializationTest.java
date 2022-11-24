package service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.javarush.module3.quest.entity.Answer;
import ru.javarush.module3.quest.entity.Question;
import ru.javarush.module3.quest.service.Initialization;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@ExtendWith(MockitoExtension.class)
class InitializationTest {

    @Test
    void initAnswersListShouldReturnListOfAnswers() {
        Initialization initialization = new Initialization();
        List<Question> questionList = List.of(new Question(0, "You've lost your memory. Accept the UFO challenge?",
                List.of(new Answer("Take the challenge", false, false, false),
                        new Answer("Reject a call", false, false, true))));

        String[] expectedArray = {"Take the challenge", "Reject a call"};
        List<Answer> answerList = initialization.initAnswersList(questionList);
        String[] answersArray = new String[answerList.size()];

        for (int i = 0; i < answersArray.length; i++) {
            answersArray[i] = answerList.get(i).getTextAnswer();
        }

        assertArrayEquals(expectedArray, answersArray);

    }

}