package interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import entities.Professor;

public interface professorManagement {
	int addProfessor(Connection connection,Professor p) throws SQLException;
	//int addProfessor(Professor p) throws SQLException;
	int updateProfessor(Connection connection,Professor p,Professor p1) throws SQLException;
	int removeProfessor(Connection connection,Professor p) throws SQLException;
	void displayProfessors(Connection connection) throws SQLException;
	
}
