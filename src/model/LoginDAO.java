package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO{

	private final String JDBC_URL ="jdbc:mysql://localhost:3306/game?serverTimezone=JST";
	private final String DB_USER ="root";
	private final String DB_PASS ="password";

	private String id;
	private String pass;


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


	/*	public void setId(String id) {
			this.id = id;
		}*/


	public String getPass() {
		return pass;
	}


	/*	public void setPass(String pass) {
			this.pass = pass;
		}*/
	}