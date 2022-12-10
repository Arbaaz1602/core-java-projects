package example.jdbc.entity;
import java.sql.Connection;
import java.sql.DriverManager;

public class jdbcUtils {
	
	public static Connection buildConnection() throws Exception{
		String driverClassName = "com.mysql.cj.jdbc.Driver";
		String connectionURL ="jdbc:mysql://localhost:3306/dac?autoReconnect=true&useSSL=false";
		String userID= "root";
		String password = "Arbaazashroya@0334";
		Class.forName(driverClassName);
		Connection conn = DriverManager.getConnection(connectionURL, userID, password);
		return conn;
	}

}
