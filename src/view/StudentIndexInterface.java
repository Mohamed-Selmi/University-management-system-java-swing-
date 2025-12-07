package view;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

import entities.Student;
public class StudentIndexInterface {
private Student currentStudent;
private JButton viewGrades=new JButton("View Grades");
private JButton updateProfile=new JButton("Update profile");
private JButton logOut=new JButton("Logout");
private JFrame frame=new JFrame("Student index");
public StudentIndexInterface(Student currentStudent) {
	this.currentStudent=currentStudent;
	content();
}
private void content() {
	Box studentInfo=new Box(BoxLayout.Y_AXIS);
	Box studentRegistration=new Box(BoxLayout.X_AXIS);
	JLabel registrationLabel=new JLabel("registration:");
	JLabel currentStudentregistration=new JLabel(String.valueOf(currentStudent.getRegistrationNumber()));
	studentRegistration.add(registrationLabel);
	studentRegistration.add(currentStudentregistration);
Box studentName=new Box(BoxLayout.X_AXIS);
	JLabel nameLabel=new JLabel("First name:");
	JLabel currentStudentName=new JLabel(currentStudent.getFirstName());
	studentName.add(nameLabel);
	studentName.add(currentStudentName);
studentInfo.add(studentRegistration);
studentInfo.add(studentName);
JPanel form=new JPanel();
form.setMaximumSize(new Dimension(500,500));
form.setPreferredSize(new Dimension(500,500));
form.setMinimumSize(new Dimension(500,500));
GridLayout index=new GridLayout(4,1);
form.setLayout(index);
form.add(studentInfo);
form.add(viewGrades);
form.add(updateProfile);
form.add(logOut);
frame.add(form);
frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
frame.setSize(new Dimension(800,800));
frame.setMinimumSize(frame.getMinimumSize());
frame.setVisible(true);
}
//public static void main (String[] args) {
//	javax.swing.SwingUtilities.invokeLater(new Runnable() {
//		public void run() {
//			new StudentIndexInterface(new Student());
//		}
//	});
//}
}
