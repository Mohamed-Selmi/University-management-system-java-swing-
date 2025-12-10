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

public class LoginAdministratorInterface {

	private Dimension inputSize=new Dimension(200,100);
	private JFrame frame=new JFrame("Admin login");
 public LoginAdministratorInterface() {
	 createLoginGUI();
 }
 private void createLoginGUI() {
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
				JTextField passwordInput=new JTextField("Put your password here");
				passwordInput.setMaximumSize(inputSize);
				JLabel password=new JLabel("password:");
				fieldPassword.add(password);
				fieldPassword.add(passwordInput);
			JButton login=new JButton("Login");
			login.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae){
					
						//Statement statement=c.createStatement()
						try {
							int adminCin=Integer.parseInt(cinInput.getText());
							String adminPassword=passwordInput.getText();
							IAdminController adminController;
							adminController=new AdminController();
							if (adminController.loginAdmin(adminCin,adminPassword)==false)
							{
								System.out.println("No Professor nnection");
								JOptionPane.showMessageDialog(null,"Please check your CIN/Password");
						
							}
							
							//In case login is successful, I'm going to retrieve the professor object and pass it as parameter
							else {
								System.out.println("Professor connected");
								JOptionPane.showMessageDialog(null,"Professor logged in succesfully");
								frame.dispose();
								Administrator currentAdmin=adminController.getAdmin(adminCin);
								JFrame AdminIndexInterface=new JFrame();
								new AdminIndexInterface(currentAdmin);
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
		new LoginAdministratorInterface();
	}
}
