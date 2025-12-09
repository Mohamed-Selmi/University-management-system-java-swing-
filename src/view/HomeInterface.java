package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HomeInterface {
	private JButton admin=new JButton("Admin");
	private JButton professor=new JButton("Professor");
	private JButton student=new JButton("Student");
	private JFrame frame=new JFrame("Home interface");
	public HomeInterface (){
		CreateHomeGUI();
	}
	private void CreateHomeGUI() {
		JPanel form=new JPanel();
		form.setMaximumSize(new Dimension(500,500));
		form.setPreferredSize(new Dimension(500,500));
		form.setMinimumSize(new Dimension(500,500));
		GridLayout index=new GridLayout(4,1);
		form.setLayout(index);
		form.add(admin);
		form.add(professor);
		form.add(student);
		frame.add(form);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(new Dimension(800,800));
		frame.setMinimumSize(frame.getMinimumSize());
		frame.setVisible(true);
		professor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				JFrame ProfessorRegisterInterface=new JFrame();
				new RegisterProfessorInterface();
			}
			
		});
		student.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				JFrame StudentRegisterInterface=new JFrame();
				new RegisterStudentInterface();
			}
			
		});
		admin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				JFrame AdminRegisterInterface=new JFrame();
				new RegisterAdminInterface();
			}
			
		});
	}
	public static void main(String[] args) {
		new HomeInterface();
	}
}
