package controllers;

import java.sql.SQLException;
import java.util.List;

import entities.Professor;

public interface IProfessorController {
	boolean addProfessor(Professor p) throws SQLException, ClassNotFoundException;
	boolean removeProfessor(Professor p) throws ClassNotFoundException, SQLException;
	boolean updateProfessor(Professor p) throws ClassNotFoundException, SQLException;
	Professor getProfessor(int CIN) throws ClassNotFoundException, SQLException;
	Boolean loginProfessor(int CIN,String password) throws ClassNotFoundException, SQLException;
	List<Professor> displayProfessors() throws ClassNotFoundException, SQLException;
}
