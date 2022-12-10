import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SimpleSelectQuery {

	public static void main(String[] args) {
		
		//This class name varies from DB to DB
		String driverClassName = "com.mysql.cj.jdbc.Driver";
		//Oracle.jdbc.OracleDriver for Oracle
		
		//String connectionURL ="jdbc:mysql://localhost:3306/dac";//(main protocol (always jdbc): (suprotocol)://(IP address):(Port number)/(schema))
		String connectionURL ="jdbc:mysql://localhost:3306/dac?autoReconnect=true&useSSL=false";
		String userID= "root";
		String password = "Arbaazashroya@0334";
		try
		{
			//LOADING THE DRIVER
			Class.forName(driverClassName);
			System.out.println("Driver Loaded");
			System.out.println("---------------");
			
			//CONNECTING TO DB
			Connection conn = DriverManager.getConnection(connectionURL, userID, password);
			System.out.println("Connected to DB");
			
			
			
			//obtain the statememt
			Statement stm = conn.createStatement();
			
			//Execute SQl query
			String sqlquery = "select roll, name, score from student";
			
			ResultSet record =  stm.executeQuery(sqlquery);
			
			//Navigating on the data resultSet
			
			while(record.next())
			{
				int roll = record.getInt(1);
				String name = record.getString(2);
				float score = record.getFloat(3);
				
				System.out.println("Roll.No:"+roll+" Name:"+name+" Score:"+score);
			}
			
			

			}catch(ClassNotFoundException e)
		{
				e.printStackTrace();
		}
		catch(SQLException e)
		{
				e.printStackTrace();
		}

	}

}
