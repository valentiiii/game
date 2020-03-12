package connecter;

import static constant.GrConst.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/* データベースに接続と切断を行うクラス*/
public class Connecter {

    /* シングルトンパターンでインスタンスを作成*/
    private final static Connecter qConnecter = new Connecter();

    /* コンストラクタを作成*/
    private Connecter() {
    }

    /* データベースに接続するメソッド
     *
     * @return con
     */
    public Connection getConnection() {

        Connection con = null;

        try {

            Class.forName(DRIVER_NAME);
            con = DriverManager.getConnection(DRIVER_URL, USER_NAME, PASSWORD);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;

    }

    /**
     * データベースから切断するメソッド
     *
     * @param Connection
     *            con 接続オブジェクト
     * @throws SQLException
     */
    public void closeConnection(Connection con) {

        try {

            con.close();
        }}
