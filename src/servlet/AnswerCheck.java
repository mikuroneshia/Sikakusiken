package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CollectAnswersDAO;
import dao.ReportDAO;
import model.Chapter;
import model.DBTable;
import model.GetQuestionInfoLogic;
import model.Judge;
import model.QuestionInfo;
import model.User;
@WebServlet("/AnswerCheck")
public class AnswerCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public AnswerCheck() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		
		String times=request.getParameter("times");
		String[] answers=request.getParameterValues("answer");
		request.setAttribute("answers", answers);
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		String name=user.getName();
		Chapter chapter=(Chapter)session.getAttribute("chapter");
		String textbook=chapter.getTextbook();
		GetQuestionInfoLogic gqil=new GetQuestionInfoLogic();
		List<QuestionInfo> questionInfoList=gqil.execute(textbook,chapter.getChapter());
		List<Integer> numberList=new ArrayList<>();
		for(QuestionInfo question:questionInfoList) {
			numberList.add(question.getNumber());
		}
		CollectAnswersDAO dao=new CollectAnswersDAO();
		List<String> collectAnswers=dao.collectAnswers(textbook,chapter.getChapter());
		Judge judge=new Judge();
		List<String> judgeList=judge.judgeLogic(answers,collectAnswers);

		DBTable dbTable=new DBTable(name,chapter.getChapter(),numberList,answers,judgeList);
		ReportDAO dao2=new ReportDAO();
		dao2.report(dbTable,textbook,times);
		session.setAttribute("dbTable",dbTable);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/answerCheck.jsp");
		dispatcher.forward(request, response);
		session.invalidate();
	}

}
