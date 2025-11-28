package controllers;

import java.sql.SQLException;
import java.util.List;

import dao.ProfessorDAO;
import entities.Professor;

public class ProfessorController implements IProfessorController {
	ProfessorDAO professorDAO;
	public ProfessorController() throws ClassNotFoundException, SQLException {
		professorDAO=new ProfessorDAO();
	}
	@Override
	public boolean addProfessor(Professor p) throws SQLException, ClassNotFoundException {
		return professorDAO.addProfessor(p);

	}
	@Override
	public boolean removeProfessor(Professor p) throws ClassNotFoundException, SQLException {
		return professorDAO.removeProfessor(p);

	}
	@Override
	public boolean updateProfessor(Professor p) throws ClassNotFoundException, SQLException {
		return professorDAO.updateProfessor(p);
	}
	@Override
	public Professor getProfessor(int CIN) throws ClassNotFoundException, SQLException {
		return professorDAO.getProfessor(CIN);
	}
	@Override
	public Boolean loginProfessor(int CIN, String password) throws ClassNotFoundException, SQLException {
		return true;
		//professorDAO.loginProfessor(CIN,password);
	}
	@Override
	public List<Professor> displayProfessors() throws ClassNotFoundException, SQLException {
		return professorDAO.displayProfessors();
	}
	
}
