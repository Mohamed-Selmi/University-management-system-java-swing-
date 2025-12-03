package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

import controllers.IProfessorController;
import controllers.ProfessorController;
import dao.DataBaseConnection;
import entities.Professor;
import dao.ProfessorDAO;
public class LoginProfessorInterface {
	
	private final int hGap=10;
	private final int vGap=10;
	private Connection c;
	private Dimension inputSize=new Dimension(200,100);
	//private IProfessorController professorController=new ProfessorController();
	private void createProfessorLoginGUI(){
		try {
			IProfessorController professorController;
			professorController=new ProfessorController();
		} 
		 catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		JFrame frame=new JFrame("Professor login");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(800,800);
			JPanel form=new JPanel();
			form.setMaximumSize(new Dimension(300,400));
			form.setLayout(new BoxLayout(form,BoxLayout.Y_AXIS));
				Box fieldCin=new Box(BoxLayout.X_AXIS);
					JTextField cinInput=new JTextField("Put your CIN here");
					cinInput.setMaximumSize(inputSize);
					JLabel cin=new JLabel("CIN:");
					fieldCin.add(cin);
					fieldCin.add(cinInput);
				Box fieldPassword=new Box(BoxLayout.X_AXIS);
					JTextField passwordInput=new JTextField("Put your CIN here");
					passwordInput.setMaximumSize(inputSize);
					JLabel password=new JLabel("CIN:");
					fieldPassword.add(password);
					fieldPassword.add(passwordInput);
				JButton login=new JButton("Login");
				login.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae){
						int proffessorCin=Integer.parseInt(cinInput.getText());
						String professorPassword=passwordInput.getText();
							//Statement statement=c.createStatement()
							try {
								IProfessorController professorController;
								professorController=new ProfessorController();
								if (professorController.loginProfessor(proffessorCin,professorPassword)==false)
								{
									System.out.println("No Professor added");
									JOptionPane.showMessageDialog(null,"Please check your CIN/Password");
								}
								else {
									System.out.println("Professor added");
									JOptionPane.showMessageDialog(null,"Professor added succesfully");
								}
							} catch (SQLException | ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						
						
					}
				});
			form.add(fieldCin);
			form.add(fieldPassword);
			form.add(login);
			frame.add(login);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new LoginProfessorInterface().createProfessorLoginGUI();
			}
		});
	}

}
