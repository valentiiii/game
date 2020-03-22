package sarvlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginBean;
import model.LoginDAO;

/**
 * Servlet implementation class Login_Sarvlet
 */
@WebServlet("/Login_Sarvlet")
public class Login_Sarvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String textid = request.getParameter("id");
		String textpass = request.getParameter("pass");

		LoginBean textLogin = new LoginBean(textid,textpass);

		LoginDAO dao = new LoginDAO();
		dao.userdt();


		if ((textLogin.getId().equals(dao.getId())) && (textLogin.getPass().equals(dao.getPass()))) {
			HttpSession session = request.getSession();
			session.setAttribute("LoginBean", textLogin);
			RequestDispatcher dispatcher = request.getRequestDispatcher("html/contact.html");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("html/dalete.html");
			dispatcher.forward(request, response);
		}

	}

}
