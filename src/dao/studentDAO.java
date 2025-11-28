package dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import entities.Professor;
import entities.Student;
import interfaces.studentManagement;

public class studentDAO implements studentManagement{
	DataBaseConnection Connection;
	Statement statement;
	public studentDAO() throws ClassNotFoundException, SQLException {
		Connection= new DataBaseConnection("root","");
	}
	
	@Override
	public int addStudent( Student s) throws SQLException {
		statement=Connection.getMyConnection().createStatement();
		String request="insert into professor values("+s.getRegistrationNumber()+",'"+s.getFirstName()+"','"+s.getLastName()+"')";
		return statement.executeUpdate(request);
	}

	@Override
	public void updateStudent( Student S, Student s1) throws SQLException {
		
	}

	@Override
	public void deleteStudent(Student S) throws SQLException {
		
	}

	@Override
	public void displayStudentList() throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
