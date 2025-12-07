package controllers;

import java.sql.SQLException;
import java.util.List;

import entities.Groupe;
import entities.Student;

public interface IStudentController {
	 boolean addStudent(Student s) throws SQLException, ClassNotFoundException;
	 boolean removeStudent(Student s) throws SQLException, ClassNotFoundException;
	 boolean updateStudent(Student s) throws SQLException, ClassNotFoundException;
	 Student getStudent(String registrationNumber) throws SQLException, ClassNotFoundException;
	 boolean loginStudent(String regisrationNumber,String password) throws SQLException, ClassNotFoundException;
	 List<Student> displayStudentsList(Groupe g) throws SQLException, ClassNotFoundException;

}
