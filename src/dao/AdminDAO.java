package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entities.Administrator;

public class AdminDAO {
	DataBaseConnection myConnection;
	Statement myStatement;
	public AdminDAO() throws ClassNotFoundException, SQLException {
		myConnection=DataBaseConnection.singleton();
	}
	 public boolean addAdministrator(Administrator a) throws SQLException { 
		 String request="INSERT INTO administrator values (?,?,?,?);";
			PreparedStatement pst=myConnection.getMyConnection().prepareStatement(request);
			pst.setInt(1, a.getCIN());
			pst.setString(2, a.getFirstName());
			pst.setString(3, a.getLastName());
			pst.setString(4, a.getPassword());
			return pst.executeUpdate()>0;
	 }
	 public boolean loginAdministrator(int CIN, String password) throws SQLException,NumberFormatException {
			String request="select * from admin where CIN=? AND password=?;";
			PreparedStatement pst=myConnection.getMyConnection().prepareStatement(request);
			pst.setInt(1,CIN);
			pst.setString(2, password);
			ResultSet result=pst.executeQuery();
			if (result.next()) {
				return true;
			}
			return false;
		}
	 public Administrator getAdmin(int CIN) throws SQLException {
			Administrator a=null;
			myStatement=myConnection.getMyConnection().createStatement();
			String request="select * from admin where CIN=?;";
			PreparedStatement pst=myConnection.getMyConnection().prepareStatement(request);
			pst.setInt(1,CIN);
			ResultSet result=pst.executeQuery();
			if (result.next()) {
				a=new Administrator(result.getInt(1), result.getString(2),result.getString(3),result.getString(4));
			}
			return a;
		}
	 public boolean Professor(Administrator a) throws SQLException { 
		 String request="INSERT INTO administrator values (?,?,?,?);";
			PreparedStatement pst=myConnection.getMyConnection().prepareStatement(request);
			pst.setInt(1, a.getCIN());
			pst.setString(2, a.getFirstName());
			pst.setString(3, a.getLastName());
			pst.setString(4, a.getPassword());
			return pst.executeUpdate()>0;
	 }
	 
}
