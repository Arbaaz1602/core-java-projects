package example.jdbc.entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleSelectQueryForEmp {

	public static void main(String[] args) {
		
		String sqlqry = "select empno, deptno, ename, sal from emp";
		
		try(Connection conn = jdbcUtils.buildConnection();
				
		Statement stm = conn.createStatement();		
		
		ResultSet Result = stm.executeQuery(sqlqry);)
		{
			
			while(Result.next())
			{
				int eno = Result.getInt(1);
				int dpt = Result.getInt(2);
				String name = Result.getString(3);
				int sal = Result.getInt(4);
				
				System.out.println("Emp-No: "+eno+" Dept-No: "+dpt+" Name: "+name+" Salary: "+sal);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
