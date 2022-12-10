import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import example.jdbc.entity.jdbcUtils;

public class NumerousQueries {
	
	//This method will excute Select query
	public static void ExecuteSelectQuery(java.sql.Statement obj) throws SQLException
	{
		ResultSet set = obj.executeQuery("select * from emp");
		
		while(set.next())
		{
			System.out.println("Emp. No: "+set.getInt(1)+"Employee name: "+set.getString(2)+" Salary: "+set.getInt(6));
		}
	}
	
	public static void createEmp(Connection con) throws SQLException
	{
		PreparedStatement pstmt = con.prepareStatement("insert into emp(?,?,?,?,?,?,?,?)");
		
		pstmt.setInt(1, 1002);
		pstmt.setString(2, "Arbaaz");
		pstmt.setString(3, "Developer");
		pstmt.setInt(4, 7839);
		pstmt.setDate(5,java.sql.Date.valueOf(java.time.LocalDate.now()));
		pstmt.setInt(6, 1000);
		pstmt.setInt(7, 100);
		pstmt.setInt(8, 10);
		int result = pstmt.executeUpdate();
		
		System.out.println("Rows affected: "+result);
	
		
	}

	public static void main(String[] args) {


		try {
			Connection newConn = jdbcUtils.buildConnection();
			
			NumerousQueries.createEmp(newConn);
			java.sql.Statement obj = newConn.createStatement();
			
			//NumerousQueries.ExecuteSelectQuery(obj); 
			NumerousQueries.createEmp(newConn);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
