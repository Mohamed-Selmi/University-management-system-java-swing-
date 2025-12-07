package controllers;

import java.sql.SQLException;
import java.util.List;

import entities.Groupe;
import entities.Student;

public interface IGroupeController {
	public boolean addGroup(Groupe g) throws SQLException;
	public boolean removeGroup(int codeGroup) throws SQLException;
	public List<Student> getStudentList(int idGroup) throws SQLException;
	public Groupe getGroupe(int idGroup) throws SQLException;
	public List<Groupe> displayGroupList() throws SQLException;
}
