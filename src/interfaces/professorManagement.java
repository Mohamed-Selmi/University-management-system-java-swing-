package interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import entities.Professor;

public interface professorManagement {
	int addProfessor(Connection connection,Professor p) throws SQLException;
	//int addProfessor(Professor p) throws SQLException;
	void updateProfessor(Statement statement,Connection connection,Professor p,Professor p1) throws SQLException;
	void removeProfessor(Statement statement,Connection connection,Professor p) throws SQLException;
	void displayProfessors(Statement statement,Connection connection) throws SQLException;
	
}
