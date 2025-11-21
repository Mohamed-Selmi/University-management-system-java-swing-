package swingInterfaces;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import dao.DataBaseConnection;
import entities.Professor;
import dao.DataBaseCommands;
public class RegisterProfessorInterface {
	
		
	private final int hGap=10;
	private final int vGap=10;
	private Connection c;
	private Dimension inputSize=new Dimension(200,100);
	private void createProfessorGUI() {
		JFrame frame=new JFrame("Professor registration");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(500,500);
		try {

			DataBaseConnection m=new DataBaseConnection("root","");
			 this.c=m.getMyConnection();
		}
		catch ( SQLException  | ClassNotFoundException e) {
			e.printStackTrace();
		}
//		Box vGlue=(Box) Box.createVerticalGlue();
//		Box hGlue=(Box) Box.createHorizontalGlue();
		//JPanel window=new JPanel()
		JPanel form=new JPanel();//(new FlowLayout(FlowLayout.CENTER,hGap,vGap));
		form.setMaximumSize(new Dimension(300,300));
		form.setLayout(new BoxLayout(form,BoxLayout.Y_AXIS));
		Box fieldCin=new Box(BoxLayout.X_AXIS);
		JTextField cinInput=new JTextField("Put your CIN here");
		cinInput.setMaximumSize(inputSize);
		JLabel cin=new JLabel("CIN:");
		fieldCin.add(cin);
		fieldCin.add(cinInput);
		Box fieldName=new Box(BoxLayout.X_AXIS);
		JTextField firstNameInput=new JTextField("Put your name here");
		firstNameInput.setMaximumSize(inputSize);
		JLabel firstname=new JLabel("firstName");
		fieldName.add(firstname);
		fieldName.add(firstNameInput);
		Box fieldLastName=new Box(BoxLayout.X_AXIS);
		JTextField lastNameInput=new JTextField("Put your last name here");
		lastNameInput.setMaximumSize(inputSize);
		JLabel lastName=new JLabel("LastName");
		fieldLastName.add(lastName);
		fieldLastName.add(lastNameInput);
		JButton register=new JButton("register");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){
				int proffessorCin=Integer.parseInt(cinInput.getText());
				String professorFirstName=firstNameInput.getText();
				String professorLastName=lastNameInput.getText();
				Professor p1=new Professor(proffessorCin,professorFirstName,professorLastName);
				Statement myStatement;
				DataBaseCommands dataBaseCommands = new DataBaseCommands();
					//Statement statement=c.createStatement()
					try {
						if (dataBaseCommands.addProfessor(c, p1)==0)
						{
							System.out.println("No Professor added");
						}
						else {
							System.out.println("Professor added");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				
			}
		});
		//form.add(Box.createVerticalGlue());
		form.add(fieldCin);
		form.add(fieldName);
		form.add(fieldLastName);
		form.add(register);
		frame.add(form);
		//frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new RegisterProfessorInterface().createProfessorGUI();
			}
		});
	}

}
