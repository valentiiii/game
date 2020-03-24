package sarvlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ContactBean;
import model.ContactDAO;

/**
 * Servlet implementation class Contact_Sarvlet
 */
@WebServlet("/Contact_Sarvlet")
public class Contact_Sarvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest session, HttpServletResponse response)
			throws ServletException, IOException {

		ContactDAO dao = new ContactDAO();


		// 文字コードのセット
        session.setCharacterEncoding("UTF-8");
        
        	
        //名前、アドレス、問い合わせ内容をセット
        String name = session.getParameter("name");
   		String address = session.getParameter("address");
   		String content = session.getParameter("content");

   		ContactBean contact = new ContactBean(name,address,content);
   		
   		
		session.setAttribute("contact",contact);

		dao.userdt(contact);

		response.sendRedirect("html/contactEnd.html");
	}
}
