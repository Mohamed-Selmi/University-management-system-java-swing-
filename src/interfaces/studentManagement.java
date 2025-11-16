package interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import entities.Student;

public interface studentManagement {
	void addStudent(Statement statement,Connection connection,Student s) throws SQLException;
	void updateStudent(Statement statement,Connection connection,Student S,Student s1) throws SQLException;
	void deleteStudent(Statement statement,Connection connection,Student S) throws SQLException;
	void displayStudentList(Statement statement,Connection connection) throws SQLException;
}
