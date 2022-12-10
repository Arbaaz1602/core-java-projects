package example.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import example.jdbc.entity.Student;
import example.jdbc.entity.jdbcUtils;

public class StudentDao implements IDao<Student, Integer> {

	public StudentDao() {
		
	}

	@Override
	public void create(Student t) {//The object will be stored as a record into the database table
		
		//Extract the data available in the Student Object using getters
		int roll = t.getRoll();
		String name = t.getName();
		float score = t.getPercent();
		
		String slquery = "insert into student values(?,?,?)";
		try(Connection con = jdbcUtils.buildConnection();
		PreparedStatement pstmt = con.prepareStatement(slquery))
		{
		pstmt.setInt(1, roll);
		pstmt.setString(2, name);
		pstmt.setFloat(3, score);
		
		try {
			int insertCount =pstmt.executeUpdate();
			if(insertCount == 0)
				System.out.println("Rows affected: "+insertCount);
			else
				System.out.println("Rows affected: "+insertCount);
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
			catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		}
	

	@Override
	public Collection<Student> getAll() {
		Collection<Student> allStudents = new ArrayList<Student>();
		try(Connection con = jdbcUtils.buildConnection();
			Statement stm = con.createStatement();
			ResultSet recordSet = stm.executeQuery("select * from student");
				){
			while(recordSet.next())
			{
				int roll = recordSet.getInt(1);
				String name = recordSet.getString(2);
				float score = recordSet.getFloat(3);
				
				//System.out.println("Roll.No:"+roll+" Name:"+name+" Score:"+score);
				
				Student std = new Student(roll,name,score);
				allStudents.add(std);
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return allStudents;
	}

	@Override
	public Student getOne(Integer key) { 
		Student foundStudent = null;
		String sqlQuery = "select * from student where roll=?";
		try(Connection con = jdbcUtils.buildConnection();
				PreparedStatement pstmt = con.prepareStatement(sqlQuery)){
				pstmt.setInt(1, key);
			ResultSet recordSet = pstmt.executeQuery();
			if(recordSet.next())
			{
				int roll = recordSet.getInt(1);
				String name = recordSet.getString(2);
				float score = recordSet.getFloat(3);
				
				foundStudent = new Student(key,name,score);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return foundStudent;
	}

	@Override
	public void update(Student updatedStudent) {
		//Extract the values for the fields for all the fields except iroll_no
		int roll = updatedStudent.getRoll();
		String name = updatedStudent.getName();
		float score = updatedStudent.getPercent();
		String sqlQuery = "update student set name=?,score=? where roll=?";
		try(Connection conn = jdbcUtils.buildConnection();
			
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery))
		{
			pstmt.setInt(3, roll);
			pstmt.setString(1, name);
			pstmt.setFloat(2, score);
			int updateCount = pstmt.executeUpdate();
			System.out.println("Rows affected "+updateCount);
	    }
		

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
	}

	@Override
	public void deleteOne(Integer key) {
		
		String sqlqry = "delete from student where roll=?";
		try(Connection conn = jdbcUtils.buildConnection();
				
				PreparedStatement pstmt = conn.prepareStatement(sqlqry))
		{
			pstmt.setInt(1,key);
			int deleteCount = pstmt.executeUpdate();
			if(deleteCount == 0 )
				System.out.println("Rows affected "+deleteCount);
			else
			System.out.println("Rows affected "+deleteCount);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
