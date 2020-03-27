package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactDAO{

	private final String JDBC_URL ="jdbc:mysql://localhost:3306/game?serverTimezone=JST";
	private final String DB_USER ="root";
	private final String DB_PASS ="password";



	//問い合わせ情報を登録
	public boolean userdt(ContactBean contact) {

		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);

			//Noの最大値を取得するSELECT
			String maxno = "SELECT MAX(number_id) FROM game";
			PreparedStatement nopStmt = conn.prepareStatement(maxno);
			ResultSet rs = nopStmt.executeQuery();

			//入力された値をセット
			String sql = "INSERT INTO game (number_id,day,NAME, ADDRESS, CONTENT) VALUES(? , DATE ? , ? , ? , ? )";

			//No、送信日時、名前、アドレス、問い合わせ内容をセット
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, noget(rs));
			pStmt.setDate(2, java.sql.Date.valueOf(java.time.LocalDate.now()));
			pStmt.setString(3, contact.getName());
			pStmt.setString(4, contact.getAddress());

			//エスケープ処理を行い内容をセット
			pStmt.setString(5, htmlEscape(contact.getContent().toString()));

			// INSERTを実行
			int result = pStmt.executeUpdate();

		    if (result != 1) {
		          return false;
		    }

		}catch (SQLException e) {

		    e.printStackTrace();

		    return false;

		}catch (ClassNotFoundException e) {

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

	//自動採番を行う
	public int noget(ResultSet rs) throws SQLException {
		rs.next();
		int count = rs.getInt(1);

		if(count ==0) {
			count = 1;
		}else{
			count += 1;
		}
		return count;
	}

    /**
     * <p>[概 要] HTMLエスケープ処理</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param  str 文字列
     * @return HTMLエスケープ後の文字列
     */
	public static String htmlEscape(String str){
		StringBuffer result = new StringBuffer();
		for(char c : str.toCharArray()) {
			switch (c) {
			case '&' :
				result.append("&amp;");
				break;
			case '<' :
				result.append("&lt;");
				break;
			case '>' :
				result.append("&gt;");
				break;
			case '"' :
				result.append("&quot;");
				break;
			case '\'' :
				result.append("&#39;");
				break;
			case ' ' :
				result.append("&nbsp;");
				break;
			default :
				result.append(c);
				break;
			}
		}
		return result.toString();
	}
}






