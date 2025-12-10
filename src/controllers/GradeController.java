package controllers;

import java.sql.SQLException;

import dao.GradeDAO;
import entities.Grades;

public class GradeController implements IGradeController{
	GradeDAO gradeDAO;
	public GradeController() throws ClassNotFoundException, SQLException {
		gradeDAO=new GradeDAO();
	}
	@Override
	public boolean addGrade(Grades g) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return gradeDAO.addGrade(g);
	}

}
