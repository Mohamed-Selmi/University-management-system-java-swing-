package testing;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import controllers.DateConversion;
import controllers.IStudentController;
import controllers.StudentController;
import dao.DataBaseConnection;
import entities.Groupe;
import entities.Professor;
import entities.Student;
import dao.ProfessorDAO;
public class Test {

	public static void main(String[] args) {
		
		try {
			IStudentController studentController;
			studentController=new StudentController();
			Groupe g1=new Groupe(1,"Groupe1");
			//LocalDate date=LocalDate.parse("2021-01-08");
			DateConversion dateconversion=new DateConversion();
			LocalDate date=dateconversion.convertDate(2001,8,6);
			Student s1=new Student("24if015","Mohamed","Selmi",date,"password",g1);
			if (studentController.addStudent(s1))
				System.out.println("Student added");
			else 
				System.out.println("Student hasn't been added!");
		}
		catch (ClassNotFoundException | SQLException e) { 
			e.printStackTrace();
		}
	
	}
}
