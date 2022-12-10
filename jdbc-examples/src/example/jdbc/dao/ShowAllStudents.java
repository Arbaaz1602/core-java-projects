package example.jdbc.dao;
import java.sql.*;

import java.util.Collection;

import example.jdbc.entity.Student;

public class ShowAllStudents {
	
	
	private static void deleteStudent()
	{
		IDao<Student,Integer> idaoref = new StudentDao();
		idaoref.deleteOne(15);
	}
	
	private static void updateStudent()
	{
		IDao<Student,Integer> idaoref = new StudentDao();
		Student foundstd = idaoref.getOne(11);
		if(foundstd!=null)
		{
			//Trying to update
			foundstd.setName("akash");
			foundstd.setPercent(58.25f);
			
			//Sending the modified state back to DAO iplementation to make changes into the database
			idaoref.update(foundstd);
		}
		
		else
			System.out.println("The course does not exist");
	}
	
	private static void CreateNewStudent()
	{
		IDao<Student, Integer>  idaoref = new StudentDao();
		Student S1 = new Student(15,"Omkar",96.22f);
		
		idaoref.create(S1);
	
		
	}
	
	private static void ShowOneStudent()
	{
		IDao<Student,Integer> idaoref = new StudentDao();
		Student foundstd = idaoref.getOne(11);
		if(foundstd==null)
		System.out.println("Data does not exist");
		else
		System.out.println("Found Course \n "+foundstd);
	}
	
	private static void showAllStudents()
	{
		//To show all the students it is necessary to obtain the collection from StudentDao through getAll
		IDao<Student,Integer> idao = new StudentDao();
		Collection<Student> stdlist = idao.getAll();
		for(Student st: stdlist)
		
			System.out.println(st);
		
	}

	public static void main(String[] args) {
		
		showAllStudents();
		//ShowOneStudent();

		//CreateNewStudent();
		
		//updateStudent();
	//	deleteStudent();
	}

}
