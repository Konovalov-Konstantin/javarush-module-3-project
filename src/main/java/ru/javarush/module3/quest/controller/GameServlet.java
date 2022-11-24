package ru.javarush.module3.quest.controller;

import ru.javarush.module3.quest.service.GameLogic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GameServlet", value = "/servlet")
public class GameServlet extends HttpServlet {

    GameLogic gameLogic = new GameLogic();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String playerName = request.getParameter("playerName");
        checkCorrectEnterName(request, response);
        session.setAttribute("playerName", playerName);
        session.setAttribute("step", gameLogic.getPlayerStep());

        request.setAttribute("questionId", gameLogic.getQuestionId());
        List<String> answers = gameLogic.getQuestQuestions().get(gameLogic.getQuestionId()).getAnswersAsString();
        request.setAttribute("question", gameLogic.getQuestion(gameLogic.getQuestionId()));

        request.setAttribute("firstAnswer", answers.get(0));
        request.setAttribute("secondAnswer", answers.get(1));

        request.getRequestDispatcher("/view/game.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.getAttribute("step");
        session.setAttribute("step", gameLogic.incrementPlayerStep());

        int questionIdFromRequest = Integer.parseInt(request.getParameter("questionId"));
        String answer = request.getParameter("answer");

        int questionId = gameLogic.checkAnswer(questionIdFromRequest, answer);
        List<String> answers = gameLogic.getQuestQuestions().get(questionId).getAnswersAsString();
        request.setAttribute("questionId", questionId);
        request.setAttribute("question", gameLogic.getQuestion(questionId));
        request.setAttribute("firstAnswer", answers.get(0));
        request.setAttribute("secondAnswer", answers.get(1));
        if (questionId % 2 == 0 && questionId < gameLogic.getCOUNTOFQUESTIONS()) {
            request.getRequestDispatcher("/view/game.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/view/endGame.jsp").forward(request, response);
            session.invalidate();
        }
    }

    protected void checkCorrectEnterName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NullPointerException {
        if(request.getParameter("playerName").equals("")) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}