package dao;
import entities.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DataBaseConnection {
	private String username;
	private String password;
	Connection myConnection;
	 private static DataBaseConnection DataBaseConnection;

	public DataBaseConnection(String username,String password) throws SQLException,ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/UniversityMgmt";
		myConnection=DriverManager.getConnection(url,username,password);
	}
	

	public Connection getMyConnection() {
		return myConnection;
	}
	

	public static DataBaseConnection singleton() throws ClassNotFoundException,SQLException{
		if(DataBaseConnection==null) {
			DataBaseConnection=new DataBaseConnection("root","");
		}
		return DataBaseConnection;
	}

	public static void closeConnection() {
		DataBaseConnection=null;
	}
}
