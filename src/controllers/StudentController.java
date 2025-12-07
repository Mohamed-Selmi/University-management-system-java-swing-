package controllers;

import java.sql.SQLException;
import java.util.List;

import dao.StudentDAO;
import entities.Groupe;
import entities.Student;

public class StudentController implements IStudentController{
StudentDAO studentDao;
public StudentController() throws SQLException,ClassNotFoundException{
	studentDao=new StudentDAO();
}
@Override
public boolean addStudent(Student s) throws SQLException, ClassNotFoundException {
	return studentDao.addStudent(s);
}
@Override
public boolean removeStudent(Student s) throws SQLException, ClassNotFoundException {
	return studentDao.removeStudent(s);
}
@Override
public boolean updateStudent(Student s) throws SQLException, ClassNotFoundException {
	return true;//studentDao.updateStudent(s);
}
@Override
public Student getStudent(String registrationNumber) throws SQLException, ClassNotFoundException {
	return studentDao.getStudent(registrationNumber);
}
@Override
public boolean loginStudent(String regisrationNumber, String password) throws SQLException, ClassNotFoundException {
	return studentDao.loginStudent(regisrationNumber, password);
}
@Override
public List<Student> displayStudentsList(Groupe g) throws SQLException, ClassNotFoundException {
	return studentDao.displayStudentList(g);
}

}
