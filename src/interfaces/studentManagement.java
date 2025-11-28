package interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import entities.Student;

public interface studentManagement {
	void addStudent(Student s) throws SQLException;
	void updateStudent(Student S,Student s1) throws SQLException;
	void deleteStudent(Student S) throws SQLException;
	void displayStudentList() throws SQLException;
}
