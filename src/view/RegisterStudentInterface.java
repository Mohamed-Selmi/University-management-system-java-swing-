package view;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.*;
import javax.swing.text.DateFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import entities.Groupe;
import controllers.DateLabelFormatter;
import controllers.GroupeController;
import controllers.IGroupeController;
import controllers.IProfessorController;
import controllers.IStudentController;
import controllers.ProfessorController;
import controllers.StudentController;
import entities.Professor;
import entities.Student;
public class RegisterStudentInterface {
	private Dimension inputSize=new Dimension(200,100);
	JFrame frame=new JFrame("Student registration");
public RegisterStudentInterface() {
	studentRegistrationGUI();
}
private void studentRegistrationGUI(){
	JPanel form=new JPanel();
	form.setMaximumSize(new Dimension(600,600));
	form.setPreferredSize(new Dimension(600,600));
	form.setMinimumSize(new Dimension(600,600));
	form.setLayout(new BoxLayout(form,BoxLayout.Y_AXIS));
		Box fieldRegistrationNumber=new Box(BoxLayout.X_AXIS);
			JTextField registrationInput=new JTextField("Put your registration number here");
			registrationInput.setMaximumSize(inputSize);
			JLabel registrationNumber=new JLabel("Registration number:");
			fieldRegistrationNumber.add(registrationNumber);
			fieldRegistrationNumber.add(registrationInput);
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
			Box fieldBirth=new Box(BoxLayout.X_AXIS);
				UtilDateModel model=new UtilDateModel();
				model.setDate(2000,1,1);
				Properties p=new Properties();
				p.put("text.today", "Today");
				p.put("text.month", "Month");
				p.put("text.year", "Year");
				JDatePanelImpl datePanel=new JDatePanelImpl(model, p);
				JDatePickerImpl datePicker=new JDatePickerImpl(datePanel, new DateLabelFormatter());
				fieldBirth.add(datePicker);
		Box fieldGroup=new Box(BoxLayout.X_AXIS);
			JComboBox<Integer> groupPicker=new JComboBox();
			JLabel group=new JLabel("Group:");
			groupPicker.setMaximumSize(inputSize);
			try {
				IGroupeController groupeController;
				groupeController=new GroupeController();
				List<Groupe> availableGroups=new ArrayList<Groupe>();
				availableGroups=groupeController.displayGroupList();
				List<Integer> groupIDs=availableGroups.stream().map(Groupe::getIdGroup).collect(Collectors.toList());
				for(Integer groupId:groupIDs) {
					groupPicker.addItem(groupId);
				}
			}
			catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			//List<Groupe> selectGroup=availableGroups.stream().collect);
			fieldGroup.add(groupPicker);
		Box fieldPassword=new Box(BoxLayout.X_AXIS);
			JTextField passwordInput=new JTextField("Put your password here");
			passwordInput.setMaximumSize(inputSize);
			JLabel password=new JLabel("CIN:");
			fieldPassword.add(password);
			fieldPassword.add(passwordInput);
		JButton register=new JButton("Register");
				
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){
					
					try {
						String studentRegistrationNumber=registrationInput.getText();
						String studentName=firstNameInput.getText();
						String studentLastName=lastNameInput.getText();
						String studentPassword=passwordInput.getText();
						Date sdate=(Date) datePicker.getModel().getValue();
						LocalDate studentBirth=LocalDate.ofInstant(sdate.toInstant(),ZoneId.systemDefault());
						int studentGroup=(Integer)groupPicker.getSelectedItem();
						IStudentController studentController;
						IGroupeController groupController;
						studentController=new StudentController();
						groupController=new GroupeController();
						Student s=new Student(studentRegistrationNumber,studentName,studentLastName,studentBirth,studentPassword,groupController.getGroupe(studentGroup));
						if (studentController.addStudent(s)==false)
						{
							System.out.println("No Student added nnection");
							JOptionPane.showMessageDialog(null,"Please check your information");
					
						}
						
						//In case login is successful, I'm going to retrieve the professor object and pass it as parameter
						else {
							JOptionPane.showMessageDialog(null,"Student registered succesfully");
							
					}
					} catch (SQLException | ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					catch(Exception e) {
						System.out.println("something went wrong!?");
						System.out.println(datePicker.getModel().getValue());
					}
				
			}
		});
	Box box=new Box(BoxLayout.Y_AXIS);
	form.add(fieldRegistrationNumber);
	form.add(fieldName);
	form.add(fieldLastName);
	form.add(fieldPassword);
	form.add(fieldGroup);
	form.add(fieldBirth);
	form.add(register);
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
				new RegisterStudentInterface();
			}
		});
	}
}
