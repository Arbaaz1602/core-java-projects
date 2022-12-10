import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import example.jdbc.entity.jdbcUtils;


public class SimpleSelectQueryUsingTryWith {

	public static void main(String[] args) {
		
		String sqlquery = "select roll, name, score from student";
		try(Connection conn = jdbcUtils.buildConnection();
		Statement stmt = conn.createStatement();
				
		
		ResultSet record =  stmt.executeQuery(sqlquery);){
				
	while(record.next())
{
	int roll = record.getInt(1);
	String name = record.getString(2);
	float score = record.getFloat(3);
					
	System.out.println("Roll.No:"+roll+" Name:"+name+" Score:"+score);
}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}