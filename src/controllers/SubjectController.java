package controllers;

import java.sql.SQLException;
import java.util.List;

import dao.StudentDAO;
import dao.SubjectDAO;
import entities.Groupe;
import entities.Subject;

public class SubjectController implements ISubjectController {
SubjectDAO subjectDAO;
public SubjectController() throws SQLException,ClassNotFoundException{
	subjectDAO=new SubjectDAO();
}
	@Override
	public boolean addSubject(Subject s) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return subjectDAO.addSubject(s);
	}

	@Override
	public boolean removeSubject(int subjectID) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return subjectDAO.removeSubject(subjectID);
	}
	public Subject getSubject(int subjectID) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return subjectDAO.getSubject(subjectID);
	}
	public List<Subject> displaySubjects() throws SQLException, ClassNotFoundException{
		return subjectDAO.displaySubjects();
	}
	@Override
	public List<Subject> displaySubjects(Groupe g) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return subjectDAO.displaySubjects(g);
	}
}
