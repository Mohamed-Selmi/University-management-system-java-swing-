package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controllers.IStudentController;
import controllers.StudentController;
import entities.Student;

public class LoginStudentInterface {

	private Dimension inputSize=new Dimension(200,100);
	private JFrame frame=new JFrame("Student login");
	public LoginStudentInterface() {
		studentLoginGUI();
	}
	private void studentLoginGUI() {
			JPanel form=new JPanel();
			form.setMaximumSize(new Dimension(500,500));
			form.setPreferredSize(new Dimension(500,500));
			form.setMinimumSize(new Dimension(500,500));
			form.setLayout(new BoxLayout(form,BoxLayout.Y_AXIS));
				Box fieldRegistrationNumber=new Box(BoxLayout.X_AXIS);
					JTextField registrationInput=new JTextField("Put your registration number here");
					registrationInput.setMaximumSize(inputSize);
					JLabel registrationNumber=new JLabel("Registration number:");
					fieldRegistrationNumber.add(registrationNumber);
					fieldRegistrationNumber.add(registrationInput);
				Box fieldPassword=new Box(BoxLayout.X_AXIS);
					JTextField passwordInput=new JTextField("Put your CIN here");
					passwordInput.setMaximumSize(inputSize);
					JLabel password=new JLabel("CIN:");
					fieldPassword.add(password);
					fieldPassword.add(passwordInput);
				JButton login=new JButton("Login");
				login.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae){
						
							//Statement statement=c.createStatement()
							try {
								String studentRegistrationNumber=registrationInput.getText();
								String studentPassword=passwordInput.getText();
								IStudentController studentController;
								studentController=new StudentController();
								if (studentController.loginStudent(studentRegistrationNumber,studentPassword)==false)
								{
									System.out.println("No Student nnection");
									JOptionPane.showMessageDialog(null,"Please check your CIN/Password");
							
								}
								
								//In case login is successful, I'm going to retrieve the professor object and pass it as parameter
								else {
									System.out.println("Student connected");
									JOptionPane.showMessageDialog(null,"Student logged in succesfully");
									frame.setVisible(false);
									Student currentStudent=studentController.getStudent(studentRegistrationNumber);
									JFrame ProfessorIndexInterface=new JFrame();
									//new ProfessorIndexInterface(currentStudent);
								}
							} catch (SQLException | ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							catch(NumberFormatException e) {
								JOptionPane.showMessageDialog(null,"Verify CIN input!");

							}
							catch(Exception e) {
								System.out.println("something went wrong!?");
							}
						
					}
				});
			Box box=new Box(BoxLayout.Y_AXIS);
			form.add(fieldRegistrationNumber);
			form.add(fieldPassword);
			form.add(login);
			box.add(box.createVerticalGlue());
			box.add(form);
			box.add(box.createVerticalGlue());
			frame.add(box);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setSize(new Dimension(800,800));
			frame.setMinimumSize(frame.getMinimumSize());
			frame.setVisible(true);	
	}
	public static void main(String[] args){
	javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new LoginStudentInterface();
			}
		});
	}
 }
