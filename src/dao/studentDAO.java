package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Grades;
import entities.Groupe;
import entities.Student;

public class StudentDAO{
	DataBaseConnection myConnection;
	Statement myStatement;
	public StudentDAO() throws ClassNotFoundException, SQLException {
		myConnection=DataBaseConnection.singleton();
	}
	
	public boolean addStudent( Student s) throws SQLException {
		String request="INSERT INTO student values (?,?,?,?,?,?);";
		PreparedStatement pst=myConnection.getMyConnection().prepareStatement(request);
		pst.setString(1, s.getRegistrationNumber());
		pst.setString(2, s.getFirstName());
		pst.setString(3, s.getLastName());
		pst.setObject(4, s.getDateOfBirth());
		pst.setString(5, s.getPassword());
		pst.setInt(6, s.getGroup().getIdGroup());
		return pst.executeUpdate()>0;
	}

	public boolean loginStudent(String registrationNumber, String password) throws SQLException,NumberFormatException {
		String request="select * from student where registrationNumber=? AND password=?;";
		PreparedStatement pst=myConnection.getMyConnection().prepareStatement(request);
		pst.setString(1,registrationNumber);
		pst.setString(2, password);
		ResultSet result=pst.executeQuery();
		if (result.next()) {
			return true;
		}
		return false;
	}
	
	public boolean updateStudent( Student s, Student s1) throws SQLException {
		return true;
	}

	
	public boolean removeStudent(Student s) throws SQLException {
		//The plan is to select students to remove students via a list, but I will probably change this to take registration number directly later
		myStatement=myConnection.getMyConnection().createStatement();
		String request="delete * from student where registrationNumber="+s.getRegistrationNumber();
		return myStatement.executeUpdate(request)>0;
	}
	public Student getStudent(String registrationNumber) throws SQLException {
		Student s=null;
		String request="select * from student where registrationNumber=?";
		PreparedStatement pst=myConnection.getMyConnection().prepareStatement(request);
		pst.setString(1,registrationNumber);
		ResultSet result=pst.executeQuery();
		if (result.next()) {
			s=new Student(result.getString(1),result.getString(2),result.getString(3),result.getObject(4),result.getString(5));
		}
		return s;
	}

	public List<Student> displayStudentList(Groupe g) throws SQLException {
		Student s=null;
		List<Student> listStudents=new ArrayList<Student>();
		String request="select * from student where idGroup=?";
		PreparedStatement pst=myConnection.getMyConnection().prepareStatement(request);
		pst.setInt(1,g.getIdGroup());
		ResultSet result=pst.executeQuery();
		while(result.next()) {
			s=new Student(result.getString(1),result.getString(2),result.getString(3),result.getDate(4),result.getString(5));
			listStudents.add(s);
		}
		return listStudents;	
	}
	
}
