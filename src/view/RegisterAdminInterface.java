package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.IAdminController;
import controllers.AdminController;
import entities.Administrator;

public class RegisterAdminInterface {
	private Dimension inputSize=new Dimension(200,100);
	public RegisterAdminInterface(){
		registerAdminGUI();
	}
	private void registerAdminGUI() {
		JFrame frame=new JFrame("Admin registration");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(800,800);
		JPanel form=new JPanel();
		form.setMaximumSize(new Dimension(600,600));
		form.setPreferredSize(new Dimension(600,600));
		form.setMinimumSize(new Dimension(600,600));
		form.setLayout(new BoxLayout(form,BoxLayout.Y_AXIS));
		Box fieldCin=new Box(BoxLayout.X_AXIS);
			JTextField cinInput=new JTextField("Put your CIN here");
			cinInput.setMaximumSize(inputSize);
			JLabel cin=new JLabel("CIN:");
			fieldCin.add(cin);
			fieldCin.add(cinInput);
			Box fieldName=new Box(BoxLayout.X_AXIS);
				JTextField firstNameInput=new JTextField("Put your first name here");
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
				Box fieldPassword=new Box(BoxLayout.X_AXIS);
				JTextField passwordInput=new JTextField("Put your password here");
				passwordInput.setMaximumSize(inputSize);
				JLabel password=new JLabel("Password:");
				fieldPassword.add(password);
				fieldPassword.add(passwordInput);
				JButton register=new JButton("register");
				register.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae){
					int adminCin=Integer.parseInt(cinInput.getText());
					String AdministratorFirstName=firstNameInput.getText();
					String AdministratorLastName=lastNameInput.getText();
					String AdministratorPassword=passwordInput.getText();
					Administrator a1=new Administrator(adminCin,AdministratorFirstName,AdministratorLastName,AdministratorPassword);
						//Statement statement=c.createStatement()
						try {
							IAdminController adminController;
							adminController=new AdminController();
							if (adminController.addAdmin(a1)==false)
							{
								System.out.println("No Administrator added");
								JOptionPane.showMessageDialog(null,"No Administrator Added");
							}
							else {
								System.out.println("Administrator added");
								JOptionPane.showMessageDialog(null,"Administrator added succesfully");
							}
						} catch (SQLException | ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					
				}
			});
				JButton login=new JButton("Login");
				JLabel exists=new JLabel("Already have an account?");
				login.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						//frame.setVisible(false);
						frame.dispose();
						JFrame LoginAdministratorInterface=new JFrame();
						new LoginAdministratorInterface();
					}
					
				});
				form.add(fieldCin);
				form.add(fieldName);
				form.add(fieldLastName);
				form.add(fieldPassword);
				form.add(register);
				form.add(login);
				frame.add(form);
				//frame.pack();
				frame.setVisible(true);
	}
	public static void main(String[] args) {
		new RegisterAdminInterface();
	}
}
