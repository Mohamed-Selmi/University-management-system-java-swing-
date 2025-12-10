package controllers;

import java.sql.SQLException;
import java.util.List;

import dao.GroupeDAO;
import entities.Groupe;
import entities.Student;
import entities.Subject;

public class GroupeController implements IGroupeController{
GroupeDAO groupeDAO;
public GroupeController() throws ClassNotFoundException, SQLException {
	groupeDAO=new GroupeDAO();
}
	@Override
	public boolean addGroup(Groupe g) throws SQLException {
		// TODO Auto-generated method stub
		return groupeDAO.addGroup(g);
	}

	@Override
	public boolean removeGroup(int codeGroup) throws SQLException {
		// TODO Auto-generated method stub
		return groupeDAO.removeGroup(codeGroup);
	}

	@Override
	public List<Student> getStudentList(int idGroup) throws SQLException {
		return groupeDAO.getStudentList(idGroup);
	}

	@Override
	public Groupe getGroupe(int idGroup) throws SQLException {
		return groupeDAO.getGroup(idGroup);
	}

	@Override
	public List<Groupe> displayGroupList() throws SQLException {
		return groupeDAO.displayGroupList();
	}
	@Override
	public boolean addCurricilum(Groupe g, Subject s) throws SQLException {
		// TODO Auto-generated method stub
		return groupeDAO.addCurricilum(g, s);
	}

}
