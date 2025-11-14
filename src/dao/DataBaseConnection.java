package dao;
import entities.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DataBaseConnection {
	private String username;
	private String password;
	Connection myConnection;
	public DataBaseConnection(String username,String password) throws SQLException,ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/UniversityMgmt";
		myConnection=DriverManager.getConnection(url,username,password);
	}
	public static void main(String[] args) {
		try {
			DataBaseConnection m=new DataBaseConnection("root","");
			if (m!=null) {
				System.out.println("Connection successful.");
			}
		}
		catch ( SQLException  | ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("finish line!");
	}

}
