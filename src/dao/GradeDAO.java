package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Grades;
import entities.Student;

public class GradeDAO {
	DataBaseConnection myConnection;
	Statement myStatement;
	public GradeDAO() throws ClassNotFoundException, SQLException {
		myConnection=DataBaseConnection.singleton();
	}
	
	public boolean addGrade(Grades g) throws SQLException{
		String request="insert into grade values(?,?,?,?)";
		PreparedStatement pst=myConnection.getMyConnection().prepareStatement(request);
		pst.setString(1, g.getStudent().getRegistrationNumber());
		pst.setInt(2, g.getSubject().getSubjectID());
		pst.setFloat(3,g.getDsGrade());
		pst.setFloat(4,g.getExamGrade());
		return pst.executeUpdate()>0;
	}
	public Grades getGrade(Student s,int subjectID) throws SQLException, ClassNotFoundException{
		Grades g=null;
		String request="select * from grade where registrationNumber=? AND subjectID=?)";
		PreparedStatement pst=myConnection.getMyConnection().prepareStatement(request);
		pst.setString(1,s.getRegistrationNumber());
		pst.setInt(2, subjectID);
		ResultSet result=pst.executeQuery();
		if (result.next()) {
			StudentDAO studentDAO=new StudentDAO();
			SubjectDAO subjectDAO=new SubjectDAO();
			g=new Grades(studentDAO.getStudent(result.getString(1)),subjectDAO.getSubject(result.getInt(2)),result.getFloat(3),result.getFloat(4));
		}
		return g;
	}
	public List<Grades> displayGrades(Student s) throws SQLException,ClassNotFoundException{
		Grades g=null;
		List<Grades> gradeList=new ArrayList<Grades>();
		String request="select * from grades registrationNumber=?";
		PreparedStatement pst=myConnection.getMyConnection().prepareStatement(request);
		pst.setString(1,s.getRegistrationNumber());
		ResultSet result=pst.executeQuery();
		while(result.next()) {
			StudentDAO studentDAO=new StudentDAO();
			SubjectDAO subjectDAO=new SubjectDAO();
			g=new Grades(studentDAO.getStudent(result.getString(1)),subjectDAO.getSubject(result.getInt(2)),result.getFloat(3),result.getFloat(4));
			gradeList.add(g);
		}
		s.setStudentGrades(gradeList);
		return gradeList;
	}
}
