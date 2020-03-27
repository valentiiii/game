package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoginDAO{

	private final String JDBC_URL ="jdbc:mysql://localhost:3306/game?serverTimezone=JST";
	private final String DB_USER ="root";
	private final String DB_PASS ="password";

	private String id;
	private String pass;


	//ログインの照合
	public boolean userdt() {

		Connection conn = null;

		try {
			//データベースへ接続
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
			String sql = "SELECT LOGIN_ID, PASSWORD FROM login";

			//SELECT文の準備
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SELECTを実行し、結果票を取得
			ResultSet rs = pStmt.executeQuery();

			//結果票に格納されたレコード内容を、LoginBeanインスタンスに設定
			while(rs.next()) {
				id = rs.getString("login_id");
				pass = rs.getString("password");
			}

			/*			String id = rs.getString("login_id");
						String pass = rs.getString("password");
						LoginBean loginbean = new LoginBean(id,pass);*/
		}catch (SQLException e) {
		    e.printStackTrace();
		    return false;

		}catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();

		} finally {
			// データベース切断
		    if (conn != null) {
		    	try {
		    		conn.close();
		    	} catch (SQLException e) {
		    		e.printStackTrace();
		    	}
		    }
		}
		return true;
	}

	public String getId() {
		return id;
	}

	public String getPass() {
		return pass;
	}



	//問い合わせ結果の出力
	public List<ContactBean> content() {

		Connection conn = null;

		List<ContactBean> beanlist = new ArrayList<>();

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
			String sql = "SELECT number_id,day,name, address, content FROM game";

			//SELECT文の準備
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SELECTを実行し、結果票を取得
			ResultSet rs = pStmt.executeQuery();

			//結果票に格納されたレコード内容を、ContactBeanインスタンスに設定
			while(rs.next()) {
				int num = rs.getInt("number_id");
				Date date = rs.getDate("day");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String content = rs.getString("content");

				ContactBean lb = new ContactBean(num,date,name,address,content);
				beanlist.add(lb);
			}

		}catch(SQLException | ClassNotFoundException e){
			return null;
		}
		return beanlist;

	}
}