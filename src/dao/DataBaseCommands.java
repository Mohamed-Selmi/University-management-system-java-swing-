package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import entities.Professor;
import entities.Student;
import interfaces.professorManagement;
import interfaces.studentManagement;

public class DataBaseCommands implements professorManagement,studentManagement{

	@Override
	public void addStudent(Statement statement, Connection connection, Student s) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStudent(Statement statement, Connection connection, Student S, Student s1) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStudent(Statement statement, Connection connection, Student S) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayStudentList(Statement statement, Connection connection) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int addProfessor(Connection connection, Professor p) throws SQLException {
		Statement statement=connection.createStatement();
		String request="insert into professor values("+p.getCIN()+",'"+p.getFirstName()+"','"+p.getLastName()+"')";
		return statement.executeUpdate(request);
	}

	@Override
	public void updateProfessor(Statement statement, Connection connection, Professor p, Professor p1)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeProfessor(Statement statement, Connection connection, Professor p) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayProfessors(Statement statement, Connection connection) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
