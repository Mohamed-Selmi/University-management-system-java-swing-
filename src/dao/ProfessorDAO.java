package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Professor;


public class ProfessorDAO{
	DataBaseConnection myConnection;
	Statement myStatement;
	public ProfessorDAO() throws ClassNotFoundException, SQLException {
		myConnection=DataBaseConnection.singleton();
		
	}
	public boolean addProfessor(Professor p) throws SQLException {
		myStatement=myConnection.getMyConnection().createStatement();
		String request="insert into professor values("+p.getCIN()+",'"+p.getFirstName()+"','"+p.getLastName()+"','"+p.getPassword()+"')";
		return myStatement.executeUpdate(request)>0;
	}

	public boolean updateProfessor( Professor p)
			throws SQLException {
		myStatement=myConnection.getMyConnection().createStatement();	
		String request="update professor set CIN="+p.getCIN()+",firstName="+p.getFirstName()+",lastName="+p.getLastName()+"')";
		return myStatement.executeUpdate(request)>0;
	}

	public boolean removeProfessor (Professor p) throws SQLException {
		myStatement=myConnection.getMyConnection().createStatement();
		String request="delete * from professor where CIN="+p.getCIN();
		return myStatement.executeUpdate(request)>0;
	}
	public Professor getProfessor(int CIN) throws SQLException {
		Professor p=null;
		myStatement=myConnection.getMyConnection().createStatement();
		String request="select * from professor where CIN="+CIN;
		ResultSet result=myStatement.executeQuery(request);
		if (result.next()) {
			p=new Professor(result.getInt(1), result.getString(2),result.getString(3),result.getString(4));
		}
		return p;
	}
	public List<Professor> displayProfessors() throws SQLException {
		List<Professor> listProfessors=new ArrayList<Professor>();
		Professor p=null;
		myStatement=myConnection.getMyConnection().createStatement();
		String request="select * from professor";
		ResultSet result=myStatement.executeQuery(request);
		while(result.next()) {
			p=new Professor(result.getInt(1), result.getString(2),result.getString(3),result.getString(4));
			listProfessors.add(p);
		}
		return listProfessors;
	}
}
