package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Groupe;
import entities.Student;
import entities.Subject;

public class GroupeDAO {
	DataBaseConnection myConnection;
	Statement myStatement;
	public GroupeDAO() throws ClassNotFoundException, SQLException {
		myConnection=DataBaseConnection.singleton();
	}
	public boolean addGroup(Groupe g) throws SQLException {
		String request="insert into groupe values(?,?)";
		PreparedStatement pst=myConnection.getMyConnection().prepareStatement(request);
		pst.setInt(1, g.getIdGroup());
		pst.setString(2, g.getNameGroup());
		return pst.executeUpdate()>0;	
		}
	public boolean removeGroup(int codeGroup) throws SQLException {
		myStatement=myConnection.getMyConnection().createStatement();
		String request="delete * from groupe where idGroup=?";
		PreparedStatement pst=myConnection.getMyConnection().prepareStatement(request);
		pst.setInt(0, codeGroup);
		return pst.executeUpdate()>0;
	}
	public List<Student> getStudentList(int idGroup) throws SQLException{
		Student s=null;
		List<Student> listStudents=new ArrayList<Student>();
		myStatement=myConnection.getMyConnection().createStatement();
		String request="select * from student where idGroup=?";
		PreparedStatement pst=myConnection.getMyConnection().prepareStatement(request);
		pst.setInt(1, idGroup);

		ResultSet result=pst.executeQuery();
		if (result.next()) {
			s=new Student(result.getString(1),result.getString(2),result.getString(3),result.getDate(4),result.getString(5));
			listStudents.add(s);
		}
		return listStudents;
		
	}
	public Groupe getGroup(int idGroup) throws SQLException {
		Groupe g=null;
		String request="select * from groupe where idGroup=?;";
		List<Student> studentList=getStudentList(idGroup);
		PreparedStatement pst=myConnection.getMyConnection().prepareStatement(request);
		pst.setInt(1, idGroup);
		ResultSet result=pst.executeQuery();
		if (result.next()) {
			g=new Groupe(result.getInt(1),result.getString(2),studentList);
		}
		return g;
	}
	public List<Groupe> displayGroupList() throws SQLException {
		Groupe g=null;
		List<Groupe> groupList=new ArrayList<Groupe>();
		String request="select * from groupe";
		PreparedStatement pst=myConnection.getMyConnection().prepareStatement(request);
		ResultSet result=pst.executeQuery();
		while (result.next()) {
			g=new Groupe(result.getInt(1),result.getString(2));
			groupList.add(g);
		}
		return groupList;
	}
	public boolean addCurricilum(Groupe g,Subject s) throws SQLException {
		String request="insert into curricilum values(?,?)";
		PreparedStatement pst=myConnection.getMyConnection().prepareStatement(request);
		pst.setInt(1, g.getIdGroup());
		pst.setInt(2, s.getSubjectID());
		return pst.executeUpdate()>0;	
	}
	
}
