package controllers;

import java.sql.SQLException;

import entities.Grades;

public interface IGradeController {
	public boolean addGrade(Grades g) throws SQLException,ClassNotFoundException;
}
