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

import controllers.GroupeController;
import controllers.IGroupeController;
import controllers.IProfessorController;
import controllers.ISubjectController;
import controllers.ProfessorController;
import controllers.SubjectController;
import entities.Groupe;
import entities.Professor;
import entities.Subject;

public class CreateCurricilumView {
	private Dimension inputSize=new Dimension(200,100);
	JFrame frame=new JFrame("Student registration");
public CreateCurricilumView() {
	CurrcilumCreationGUI();
}
private void CurrcilumCreationGUI() {
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
	Box fieldSubject=new Box(BoxLayout.X_AXIS);
	JComboBox<Integer> subjectPicker=new JComboBox();
	JLabel subject=new JLabel("Subject:");
	subjectPicker.setMaximumSize(inputSize);
	try {
		ISubjectController subjectController;
		subjectController=new SubjectController();
		List<Subject> availableSubjects=new ArrayList<Subject>();
		availableSubjects=subjectController.displaySubjects();
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
	//List<Groupe> selectGroup=availableGroups.stream().collect);
	fieldSubject.add(subjectPicker);
	JButton add=new JButton("Add");
	add.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae){
			int subjectId=(Integer)subjectPicker.getSelectedItem();
			int groupID=(Integer)groupPicker.getSelectedItem();
			//Curricilum p1=new Curricilum(proffessorCin,professorFirstName,professorLastName,professorPassword);
				//Statement statement=c.createStatement()
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
public static void main(String[] args){
	javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new CreateCurricilumView();
			}
		});
	}
}


