package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContactDAO{

	private final String JDBC_URL ="jdbc:mysql://localhost:3306/game?serverTimezone=JST";
	private final String DB_USER ="root";
	private final String DB_PASS ="password";


	public boolean userdt(ContactBean contact) {

		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);

			//現在の日付を取得
//			java.util.Date today = new java.util.Date();
//			java.sql.Date(today.getTime());

			//入力された値をセット
			String sql = "INSERT INTO game (number_id,day,NAME, ADDRESS, CONTENT) VALUES(? , DATE ? , ? , ? , ? )";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, 1);
			pStmt.setDate(2, java.sql.Date.valueOf(java.time.LocalDate.now()));
			pStmt.setString(3, contact.getName());
			pStmt.setString(4, contact.getAddress());
			pStmt.setString(5, contact.getContent());

			// INSERT文を実行
			int result = pStmt.executeUpdate();

		    if (result != 1) {
		          return false;
		    }

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

	//自動採番のメソッド
	public int noget() {
		
		
		
		
		return 50;
	}
}






















