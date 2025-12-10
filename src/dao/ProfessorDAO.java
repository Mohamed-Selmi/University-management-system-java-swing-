package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Groupe;
import entities.Professor;


public class ProfessorDAO{
	DataBaseConnection myConnection;
	Statement myStatement;
	public ProfessorDAO() throws ClassNotFoundException, SQLException {
		myConnection=DataBaseConnection.singleton();
	}
	public boolean addProfessor(Professor p) throws SQLException {
		 String request="INSERT INTO professor values (?,?,?,?);";
			PreparedStatement pst=myConnection.getMyConnection().prepareStatement(request);
			pst.setInt(1, p.getCIN());
			pst.setString(2, p.getFirstName());
			pst.setString(3,p.getLastName());
			pst.setString(4, p.getPassword());
			return pst.executeUpdate()>0;
	}
	public boolean loginProfessor(int CIN, String password) throws SQLException,NumberFormatException {
		String request="select * from professor where CIN=? AND password=?;";
		PreparedStatement pst=myConnection.getMyConnection().prepareStatement(request);
		pst.setInt(1,CIN);
		pst.setString(2, password);
		ResultSet result=pst.executeQuery();
		if (result.next()) {
			return true;
		}
		return false;
	}
	public boolean updateProfessor( Professor p)
			throws SQLException {
		myStatement=myConnection.getMyConnection().createStatement();	
		String request="update professor set CIN="+p.getCIN()+",firstName="+p.getFirstName()+",lastName="+p.getLastName()+"')";
		return myStatement.executeUpdate(request)>0;
	}

	public boolean removeProfessor (Professor p) throws SQLException {
		String request="delete from professor where CIN=?:";
		PreparedStatement pst=myConnection.getMyConnection().prepareStatement(request);
		pst.setInt(1,p.getCIN());
		return pst.executeUpdate()>0;
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
	public List<Groupe> displayTaughtGroups(Professor p) throws SQLException, ClassNotFoundException{
		List<Groupe> taughtGroups=new ArrayList<Groupe>();
		Groupe g=null;
		String request="select * from teaching where CIN=?;";
		PreparedStatement pst=myConnection.getMyConnection().prepareStatement(request);
		pst.setInt(1, p.getCIN());
		ResultSet result=pst.executeQuery();
		while(result.next()){
			GroupeDAO groupeDAO=new GroupeDAO();
			System.out.println("these are the taught groups"+result.getInt(1));
			g=groupeDAO.getGroup(result.getInt(1));
			taughtGroups.add(g);
		}
		p.setTaughtGroups(taughtGroups);
		return taughtGroups;
	}
}
