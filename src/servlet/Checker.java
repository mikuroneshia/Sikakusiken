package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Chapter;

@WebServlet("/Checker")
public class Checker extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public Checker() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/checker.jsp");
		dispatcher.forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String chapter=request.getParameter("chapter");
		String textbook=request.getParameter("textbook");
		HttpSession session=request.getSession();
		Chapter chapterI=new Chapter(textbook,chapter);
		session.setAttribute("chapter", chapterI);
		request.setAttribute("textbook", textbook);
		request.setAttribute("chapter",chapter);
		session.setMaxInactiveInterval(3600);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/checker.jsp");
		dispatcher.forward(request,response);
	}

}
