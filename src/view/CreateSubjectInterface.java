package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.ISubjectController;

import controllers.SubjectController;
import entities.Subject;


public class CreateSubjectInterface {
	private Dimension inputSize=new Dimension(200,100);
	JFrame frame=new JFrame("Student registration");
public CreateSubjectInterface() {
	SubjectCreationGUI();
}
	
	private void SubjectCreationGUI() {
		JPanel form=new JPanel();
		form.setMaximumSize(new Dimension(500,500));
		form.setPreferredSize(new Dimension(500,500));
		form.setMinimumSize(new Dimension(500,500));
		form.setLayout(new BoxLayout(form,BoxLayout.Y_AXIS));
		
		Box fieldSubjectId=new Box(BoxLayout.X_AXIS);
		JTextField subjectIDInput=new JTextField("Put the subject ID here");
		subjectIDInput.setMaximumSize(inputSize);
		JLabel cin=new JLabel("Subject ID:");
		fieldSubjectId.add(cin);
		fieldSubjectId.add(subjectIDInput);
	Box fieldSubjectName=new Box(BoxLayout.X_AXIS);
		JTextField subjectNameInput=new JTextField("Put the subject name here");
		subjectNameInput.setMaximumSize(inputSize);
		JLabel firstname=new JLabel("Subject name");
		fieldSubjectName.add(firstname);
		fieldSubjectName.add(subjectNameInput);
	Box fieldSubjectCoefficient=new Box(BoxLayout.X_AXIS);
		JTextField SubjectCoefficientInput=new JTextField("Put the subject coefficient here");
		SubjectCoefficientInput.setMaximumSize(inputSize);
		JLabel lastName=new JLabel("Coefficient");
		fieldSubjectCoefficient.add(lastName);
		fieldSubjectCoefficient.add(SubjectCoefficientInput);
	
		
		JButton register=new JButton("Register");
		
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){
					
					try {
						int subjectID=Integer.parseInt(subjectIDInput.getText());
						String subjectName=subjectNameInput.getText();
						float subjectCoefficient=Float.parseFloat(SubjectCoefficientInput.getText());
						ISubjectController subjectController;
						subjectController=new SubjectController();
						Subject s=new Subject(subjectID,subjectName,subjectCoefficient);
						if (subjectController.addSubject(s)==false)
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
					}
				
			}
		});
	Box box=new Box(BoxLayout.Y_AXIS);
	form.add(fieldSubjectId);
	form.add(fieldSubjectName);
	form.add(fieldSubjectCoefficient);
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
					new CreateSubjectInterface();
				}
			});
		}
}
