//package swingInterfaces;
//import java.awt.*;
//import dao.DataBaseConnection;
//import entities.Professor;
//import dao.DataBaseCommands;
//
//
//import javax.swing.*;
//public class RegisterProfessorInterface {
//	private static void createProfessorGUI() {
//		JFrame frame=new JFrame("hello world!!");
//		frame.setSize(800,600);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		JLabel label= new JLabel("Hello");
//		frame.getContentPane().add(label);
////		JPanel form=new JPanel();
////		form.setLayout(new GridLayout(3,2));
////		form.setBackground(Color.red);//column,row
//		JTextField email=new JTextField("waas");
//		email.setMaximumSize(new Dimension(200,50)); //width height
//		JLabel emailLabel=new JLabel("Email:");
//		Box adress=new Box(BoxLayout.X_AXIS);
//		adress.setBackground(Color.red);
//		adress.add(emailLabel);
//		adress.add(email);
//		Box username=new Box(BoxLayout.X_AXIS);
//		adress.setBackground(Color.red);
//		JTextField name=new JTextField(80);
//		JLabel nameLabel=new JLabel("username:");
//		username.add(nameLabel);
//		username.add(name);
//		username.setMaximumSize(new Dimension(100,50));
//		JButton register=new JButton("Register");
//		register.setMaximumSize(new Dimension(50,50));
////		form.setMaximumSize(new Dimension(300,255));
////		form.add(adress);
////		form.add(username);
////		form.add(register);
////		form.setAlignmentX(JComponent.CENTER_ALIGNMENT);
//		JLabel title=new JLabel("Please fill in this form",SwingConstants.CENTER);
//		frame.add(title,BorderLayout.NORTH);
//		//frame.add(form,BorderLayout.CENTER,SwingConstants.CENTER);
//		frame.setBackground(Color.yellow);
//		//frame.pack();
//		frame.setVisible(true);
//		
//	}
//	public static void main(String[] args) {
//		javax.swing.SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				createProfessorGUI();
//			}
//		});
//
//	}
//
//}
package view;


