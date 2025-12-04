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
public class ProfessorIndexInterface {
	private Professor currentProfessor;
	private JButton manageGrades=new JButton("Manage grades");
	private JButton updateProfile=new JButton("Update profile");
	private JButton logOut=new JButton("Logout");
	private JFrame frame=new JFrame("Professor index");
	//The current professor is retrieved from login and used as a session
	public ProfessorIndexInterface(Professor currentProfessor) {
		this.currentProfessor=currentProfessor;
		content();
	}
	private void content() {
//		JPanel form=new JPanel();
//		form.setMaximumSize(new Dimension(600,200));
//		JLabel ProfessorCIN=new JLabel(String.valueOf(currentProfessor.getCIN()));
//		form.setLayout(new BoxLayout(form,BoxLayout.Y_AXIS));
//		form.add(ProfessorCIN);
		Box professorInfo=new Box(BoxLayout.Y_AXIS);
				Box professorCIN=new Box(BoxLayout.X_AXIS);
				JLabel CINLabel=new JLabel("CIN:");
				JLabel currentProfessorCIN=new JLabel(String.valueOf(currentProfessor.getCIN()));
				professorCIN.add(CINLabel);
				professorCIN.add(currentProfessorCIN);
			Box professorName=new Box(BoxLayout.X_AXIS);
				JLabel nameLabel=new JLabel("First name:");
				JLabel currentProfessorName=new JLabel(currentProfessor.getFirstName());
				professorName.add(nameLabel);
				professorName.add(currentProfessorName);
		professorInfo.add(professorCIN);
		professorInfo.add(professorName);
		JPanel form=new JPanel();
		form.setMaximumSize(new Dimension(500,500));
		form.setPreferredSize(new Dimension(500,500));
		form.setMinimumSize(new Dimension(500,500));
		GridLayout index=new GridLayout(4,1);
		form.setLayout(index);
		form.add(professorInfo);
		form.add(manageGrades);
		form.add(updateProfile);
		form.add(logOut);
		frame.add(form);
		logOut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				JFrame LoginProfessorInterface=new JFrame();
				new LoginProfessorInterface();
				
			}
			
		});
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(new Dimension(800,800));
		frame.setMinimumSize(frame.getMinimumSize());
		frame.setVisible(true);
		
	}
	
public static void main (String[] args) {
	javax.swing.SwingUtilities.invokeLater(new Runnable() {
		public void run() {
			new ProfessorIndexInterface(new Professor(10,"test","tests","test"));
		}
	});
}
}
