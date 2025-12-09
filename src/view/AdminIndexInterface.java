package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entities.Administrator;

public class AdminIndexInterface {
	private Administrator currentAdmin;
	private JButton manageGrades=new JButton("Create professor");
	private JButton updateProfile=new JButton("Create student");
	private JButton logOut=new JButton("Logout");
	private JFrame frame=new JFrame("admin index");
	public AdminIndexInterface(Administrator currentAdmin) {
		this.currentAdmin=currentAdmin;
	}
	private void indexGUI() {
		Box adminInfo=new Box(BoxLayout.Y_AXIS);
		Box adminCIN=new Box(BoxLayout.X_AXIS);
		JLabel CINLabel=new JLabel("CIN:");
		JLabel currentadminCIN=new JLabel(String.valueOf(currentAdmin.getCIN()));
		adminCIN.add(CINLabel);
		adminCIN.add(currentadminCIN);
		Box adminName=new Box(BoxLayout.X_AXIS);
			JLabel nameLabel=new JLabel("First name:");
			JLabel currentadminName=new JLabel(currentAdmin.getFirstName());
			adminName.add(nameLabel);
			adminName.add(currentadminName);
			adminInfo.add(adminCIN);
			adminInfo.add(adminName);
			JPanel form=new JPanel();
			form.setMaximumSize(new Dimension(500,500));
			form.setPreferredSize(new Dimension(500,500));
			form.setMinimumSize(new Dimension(500,500));
			GridLayout index=new GridLayout(4,1);
			form.setLayout(index);
			form.add(adminInfo);
			form.add(manageGrades);
			form.add(updateProfile);
			form.add(logOut);
			frame.add(form);
			
			manageGrades.addActionListener(new ActionListener() {
			
				@Override
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					JFrame AssignGradesInterface=new JFrame();
					new AssignGradesInterface(currentadmin);
					
				}
				
			});
			logOut.addActionListener(new ActionListener() {
			
				@Override
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					JFrame LoginadminInterface=new JFrame();
					new LoginAdministratorInterface();
					
				}
				
			});
frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
frame.setSize(new Dimension(800,800));
frame.setMinimumSize(frame.getMinimumSize());
frame.setVisible(true);

	}
}
