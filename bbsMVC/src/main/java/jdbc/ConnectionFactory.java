package jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionFactory {
	private String driver;
	private String url;
	private String id;
	private String password;
	private int maxConn;
	//싱클톤
	private static ConnectionFactory instance = new ConnectionFactory();
	public static ConnectionFactory getInstance() {
		return instance;
	}
	private ConnectionFactory() {
		Properties prop = new Properties();
		InputStream reader = getClass().getClassLoader().getResourceAsStream("config/db.properties");
		try {
			prop.load(reader);
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			id = prop.getProperty("id");
			password= prop.getProperty("password");
			maxConn = Integer.parseInt(prop.getProperty("maxConn"));
			// 드라이버 로딩
			Class.forName(driver);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public int getMaxConn() {
		return maxConn;
	}
	// db와 conn객체를 생성해서 리턴하는 메소드
	public Connection getConnection() throws SQLException{
		Connection conn = DriverManager.getConnection(url, id, password);
		return conn;
	}
	public static void main(String[] args) {
		ConnectionFactory.getInstance();
	}
}
