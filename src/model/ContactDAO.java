package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContactDAO{

	private final String JDBC_URL ="jdbc:mysql://localhost:3306/MySQL";
	private final String DB_USER ="root";
	private final String DB_PASS ="password";


	public boolean userdt(ContactBean contact) {

		Connection conn = null;

		try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
		String sql = "INSERT INTO game (NAME, ADDRESS, CONTENT) VALUES( ? , ? , ? )";

		PreparedStatement pStmt = conn.prepareStatement(sql);
		pStmt.setString(1, contact.getName());
		pStmt.setString(2, contact.getAddress());
		pStmt.setString(3, contact.getContent());

		// INSERT文を実行
		int result = pStmt.executeUpdate();

	      if (result != 1) {
	          return false;
	        }
	      } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
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
}
