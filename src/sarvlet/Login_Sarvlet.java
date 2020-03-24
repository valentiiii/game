package sarvlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ContactBean;
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
		//ログインの入力された値を取得
		request.setCharacterEncoding("UTF-8");
		String textid = request.getParameter("id");
		String textpass = request.getParameter("pass");


		//LoginBeanをインスタンス化して、入力された値をセット
		LoginBean textLogin = new LoginBean(textid,textpass);

		//LoginDaoをインスタンス化して、メソッドを実行してデータベース接続
		LoginDAO dao = new LoginDAO();
		dao.userdt();


		//データベースのログインの値と入力された値が、正しいか確認
		if ((textLogin.getId().equals(dao.getId())) && (textLogin.getPass().equals(dao.getPass()))) {

			//データベースのログイン情報のリストを取得
			List<ContactBean> beanlist = dao.content();

			//リストのセッションに保存
			request.setAttribute("beanlist",beanlist );

			//入力されたログイン、パスワード値をセッションに保存
			HttpSession session = request.getSession();
			session.setAttribute("LoginBean", textLogin);

			//お問い合わせ内容のページに移動
			RequestDispatcher dispatcher = request.getRequestDispatcher("html/maneger.jsp");
			dispatcher.forward(request, response);
		}else {
			//ログイン失敗したときに違うページに行く
			RequestDispatcher dispatcher = request.getRequestDispatcher("html/dalete.html");
			dispatcher.forward(request, response);
		}

	}

}

