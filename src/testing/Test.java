package testing;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import dao.DataBaseConnection;
import entities.Professor;
import dao.DataBaseCommands;
public class Test {

	public static void main(String[] args) {
		Statement myStatement;
		DataBaseCommands dataBaseCommands = new DataBaseCommands();
		
		try {
			DataBaseConnection m=new DataBaseConnection("root","");
			Connection c=m.getMyConnection();
			//Statement statement=c.createStatement()
			Professor p1=new Professor(188,"Med","Amine");
			if (dataBaseCommands.addProfessor(c, p1)==0)
			{
				System.out.println("No Professor added");
			}
			else {
				System.out.println("Professor added");
			}
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

