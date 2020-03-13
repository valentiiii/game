package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class ContactDAO{

	private final String JDBC_URL ="";
	private final String DB_USER ="MySQL";
	private final String DB_PASS ="password";

	public void userdt(ContactBean contact) {

		Connection conn = null;

		try{
			conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);

			String sql = "INSERT INTO user_db (NAME, ADDRESS, CONTENT) VALUES( ? , ? , ? )";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, contact.getName());
			pStmt.setString(2, contact.getAddress());
			pStmt.setString(3, contact.getContent());

		}catch (Exception e) {

			e.printStackTrace();
		}
	}
}