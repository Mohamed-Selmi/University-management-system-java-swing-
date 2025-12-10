package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Groupe;
import entities.Subject;

public class SubjectDAO {
	DataBaseConnection myConnection;
	Statement myStatement;
	public SubjectDAO() throws ClassNotFoundException, SQLException {
		myConnection=DataBaseConnection.singleton();
	}
	public boolean addSubject(Subject s) throws SQLException{
		String request="INSERT INTO subject values (?,?,?);";
		PreparedStatement pst=myConnection.getMyConnection().prepareStatement(request);
		pst.setInt(1, s.getSubjectID());
		pst.setString(2, s.getSubjectName());
		pst.setFloat(3, s.getSubjectCoefficient());
		
		return pst.executeUpdate()>0;
	}
	public boolean removeSubject(int subjectID) throws SQLException{
		String request="DELETE * from subject where subjectID=?;";
		PreparedStatement pst=myConnection.getMyConnection().prepareStatement(request);
		pst.setInt(1, subjectID);
		
		return pst.executeUpdate()>0;
	}
//	public boolean updateSubject(int subjectID) throws SQLException{
//		String request="DELETE * from subject where subjectID=?;";
//		PreparedStatement pst=myConnection.getMyConnection().prepareStatement(request);
//		pst.setInt(1, subjectID);
//		
//		return pst.executeUpdate()>0;
//	}
	public Subject getSubject(int subjectID) throws SQLException{
		Subject s=null;
		String request="SELECT * from subject where subjectID=?;";
		PreparedStatement pst=myConnection.getMyConnection().prepareStatement(request);
		pst.setInt(1, subjectID);
		ResultSet result=pst.executeQuery();
		if (result.next()) {
			s=new Subject(result.getInt(1),result.getString(2),result.getFloat(3));
		}
		return s;
	}
	public List<Subject> displaySubjects() throws SQLException{
		Subject s=null;
		String request="SELECT * from subject;";
		PreparedStatement pst=myConnection.getMyConnection().prepareStatement(request);
		List<Subject> subjectList=new ArrayList<Subject>();
		ResultSet result=pst.executeQuery();
		while (result.next()) {
			s=new Subject(result.getInt(1),result.getString(2),result.getFloat(3));
			subjectList.add(s);
		}
		return subjectList;
	}
	public List<Subject> displaySubjects(Groupe g) throws SQLException{
		Subject s=null;
		String request="SELECT * from subject where subjectID in (select subjectID from curricilum where idGroup=?);";
		PreparedStatement pst=myConnection.getMyConnection().prepareStatement(request);
		pst.setInt(1,g.getIdGroup());
		List<Subject> subjectList=new ArrayList<Subject>();
		ResultSet result=pst.executeQuery();
		while(result.next()) {
			s=new Subject(result.getInt(1),result.getString(2),result.getFloat(3));
			subjectList.add(s);
		}
		return subjectList;
	}
}
