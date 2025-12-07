package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
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

import controllers.GroupeController;
import controllers.IGroupeController;
import controllers.IProfessorController;
import controllers.IStudentController;
import controllers.ISubjectController;
import controllers.ProfessorController;
import controllers.StudentController;
import controllers.SubjectController;
import entities.Grades;
import entities.Groupe;
import entities.Professor;
import entities.Student;
import entities.Subject;

public class AssignGradesInterface {
	private Professor currentProfessor;
	private Dimension inputSize=new Dimension(200,100);
	JFrame frame=new JFrame("Assign grades");
	//The current professor is retrieved from login and used as a session
	public AssignGradesInterface(Professor currentProfessor) {
		this.currentProfessor=currentProfessor;
		AssignGradeGUI();
	}
	private void AssignGradeGUI() {
		JPanel form=new JPanel();
		form.setMaximumSize(new Dimension(600,600));
		form.setPreferredSize(new Dimension(600,600));
		form.setMinimumSize(new Dimension(600,600));
		form.setLayout(new BoxLayout(form,BoxLayout.Y_AXIS));
		Box fieldGroup=new Box(BoxLayout.X_AXIS);
		JComboBox<Integer> groupPicker=new JComboBox();
		JLabel group=new JLabel("Group:");
		groupPicker.setMaximumSize(inputSize);
		try {
			IProfessorController professorController;
			professorController=new ProfessorController();
			List<Groupe> taughtGroups=new ArrayList<Groupe>();
			taughtGroups=professorController.displayTaughtGroups(currentProfessor);
			List<Integer> groupIDs=taughtGroups.stream().map(Groupe::getIdGroup).collect(Collectors.toList());
			for(Integer groupId:groupIDs) {
				groupPicker.addItem(groupId);
			}
		}
		catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		//List<Groupe> selectGroup=availableGroups.stream().collect);
		fieldGroup.add(group);
		fieldGroup.add(groupPicker);
		Box fieldSubject=new Box(BoxLayout.X_AXIS);
		JComboBox<Integer> subjectPicker=new JComboBox();
		JLabel subject=new JLabel("Subject:");
		subjectPicker.setMaximumSize(inputSize);
		try {
			ISubjectController subjectController;
			subjectController=new SubjectController();
			List<Subject> availableSubjects=new ArrayList<Subject>();
			int groupID=(Integer)groupPicker.getSelectedItem();
			Groupe g=null;
			IGroupeController groupeController;
			groupeController=new GroupeController();
			g=groupeController.getGroupe(groupID);
			availableSubjects=subjectController.displaySubjects(g);
			System.out.println(availableSubjects);
			List<Integer> subjectIDs=availableSubjects.stream().map(Subject::getSubjectID).collect(Collectors.toList());
			System.out.println(subjectIDs);
			for(Integer subjectID:subjectIDs) {
				subjectPicker.addItem(subjectID);
			}
		}
		catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		//List<Groupe> selectGroup=availableGroups.stream().collect)
		fieldSubject.add(subject);

		fieldSubject.add(subjectPicker);
		Box fieldStudent=new Box(BoxLayout.X_AXIS);
		JComboBox<String> studentPicker=new JComboBox();
		JLabel student=new JLabel("student:");
		studentPicker.setMaximumSize(inputSize);
		try {
			
			List<Student> studentList=new ArrayList<Student>();
			int groupID=(Integer)groupPicker.getSelectedItem();
			Groupe g=null;
			IStudentController studentController;
			studentController=new StudentController();
			IGroupeController groupeController;
			groupeController=new GroupeController();
			g=groupeController.getGroupe(groupID);
			studentList=studentController.displayStudentsList(g);
			System.out.println("test:");
			System.out.println(studentList);
			List<String> registrationNumbers=studentList.stream().map(Student::getRegistrationNumber).collect(Collectors.toList());
			for(String registrationNumber:registrationNumbers) {
				studentPicker.addItem(registrationNumber);
			}
		}
		catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		//List<Groupe> selectGroup=availableGroups.stream().collect)
		fieldStudent.add(student);

		fieldStudent.add(studentPicker);

		Box fieldDsGrade=new Box(BoxLayout.X_AXIS);
		JTextField dsGradeInput=new JTextField("Put the ds grade here");
		dsGradeInput.setMaximumSize(inputSize);
		JLabel dsGrade=new JLabel("DS");
		fieldDsGrade.add(dsGrade);
		fieldDsGrade.add(dsGradeInput);
		Box fieldExamGrade=new Box(BoxLayout.X_AXIS);
		JTextField examInput=new JTextField("Put the exam grade here");
		examInput.setMaximumSize(inputSize);
		JLabel examGrade=new JLabel("DS");
		fieldDsGrade.add(dsGrade);
		fieldDsGrade.add(examInput);
		JButton add=new JButton("Add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){
				int subjectId=(Integer)subjectPicker.getSelectedItem();
				float dsGrade=Float.parseFloat(dsGradeInput.getText());
				float examGrade=Float.parseFloat(examInput.getText());
				//Curricilum p1=new Curricilum(proffessorCin,professorFirstName,professorLastName,professorPassword);
					//Statement statement=c.createStatement()
				Grades g=new Grades();
					try {
						IProfessorController professorController;
						professorController=new ProfessorController();
						if (professorController.addProfessor()==false)
						{
							System.out.println("No Professor added");
							JOptionPane.showMessageDialog(null,"No professor Added");
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
		Box box=new Box(BoxLayout.Y_AXIS);
		form.add(fieldGroup);
		form.add(fieldSubject);
		form.add(fieldStudent);
		form.add(fieldDsGrade);
		form.add(fieldExamGrade);
		form.add(add);
		box.add(box.createVerticalGlue());
		box.add(form);
		box.add(box.createVerticalGlue());
		frame.add(box);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(new Dimension(800,800));
		frame.setMinimumSize(frame.getMinimumSize());
		frame.setVisible(true);
	}
	/*public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					new AssignGradesInterface(new Professor(1258,"test","tests",975));
				}
			});
		}*/
}
