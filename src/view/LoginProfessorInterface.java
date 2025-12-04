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
	private JFrame frame=new JFrame("Professor login");
	//private IProfessorController professorController=new ProfessorController();
	public LoginProfessorInterface() {
		createProfessorLoginGUI();
	}
	private void createProfessorLoginGUI(){	
				
			JPanel form=new JPanel();
			form.setMaximumSize(new Dimension(500,500));
			form.setPreferredSize(new Dimension(500,500));
			form.setMinimumSize(new Dimension(500,500));
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
						
							//Statement statement=c.createStatement()
							try {
								int proffessorCin=Integer.parseInt(cinInput.getText());
								String professorPassword=passwordInput.getText();
								IProfessorController professorController;
								professorController=new ProfessorController();
								if (professorController.loginProfessor(proffessorCin,professorPassword)==false)
								{
									System.out.println("No Professor nnection");
									JOptionPane.showMessageDialog(null,"Please check your CIN/Password");
							
								}
								
								//In case login is successful, I'm going to retrieve the professor object and pass it as parameter
								else {
									System.out.println("Professor connected");
									JOptionPane.showMessageDialog(null,"Professor logged in succesfully");
									frame.setVisible(false);
									Professor currentProfessor=professorController.getProfessor(proffessorCin);
									JFrame ProfessorIndexInterface=new JFrame();
									new ProfessorIndexInterface(currentProfessor);
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
			form.add(fieldCin);
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
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new LoginProfessorInterface();
			}
		});
	}

}
