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
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.GroupeController;
import controllers.IGroupeController;
import controllers.StudentController;
import entities.Groupe;

public class CreateGroupInterface {
	private Dimension inputSize=new Dimension(200,100);
	public CreateGroupInterface(){
		createGroupGUI();
	}
	private void createGroupGUI() {
		JFrame frame=new JFrame("Group creation");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(800,800);
		JPanel form=new JPanel();
		form.setMaximumSize(new Dimension(600,600));
		form.setPreferredSize(new Dimension(600,600));
		form.setMinimumSize(new Dimension(600,600));
		form.setLayout(new BoxLayout(form,BoxLayout.Y_AXIS));
		Box fieldidGroup=new Box(BoxLayout.X_AXIS);
			JTextField idGroupInput=new JTextField("Put your idGroup here");
			idGroupInput.setMaximumSize(inputSize);
			JLabel idGroup=new JLabel("idGroup:");
			fieldidGroup.add(idGroup);
			fieldidGroup.add(idGroupInput);
			Box fieldName=new Box(BoxLayout.X_AXIS);
				JTextField groupNameInput=new JTextField("Put your group name here");
				groupNameInput.setMaximumSize(inputSize);
				JLabel groupName=new JLabel("groupname");
				fieldName.add(groupName);
				fieldName.add(groupNameInput);
			
				JButton add=new JButton("add");
				add.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent ae) {
						int groupId=Integer.parseInt(idGroupInput.getText());
						String groupName=groupNameInput.getText();
						Groupe g=new Groupe(groupId,groupName);
						try {
							IGroupeController groupController;
							groupController=new GroupeController();
							groupController.addGroup(g);
						} catch (SQLException | ClassNotFoundException e) {
							e.printStackTrace();
						}

						
					}
					
				});
	}
	
}
