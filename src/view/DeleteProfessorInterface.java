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

import entities.Administrator;
import entities.Professor;
import controllers.IProfessorController;
import controllers.ProfessorController;

public class DeleteProfessorInterface {
	Administrator currentAdmin;
	private Dimension inputSize=new Dimension(200,100);
	private JFrame frame=new JFrame("Professor delete");
	public DeleteProfessorInterface(Administrator currentAdmin) {
		DeleteGUI();
		this.currentAdmin=currentAdmin;
	}
	private void DeleteGUI() {
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
		JButton delete=new JButton("delete");
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				int professorCIN=Integer.parseInt(cinInput.getText());
				try {
					IProfessorController professorController;
					professorController=new ProfessorController();
					Professor p=professorController.getProfessor(professorCIN);
					if (p!=null) {
						professorController.removeProfessor(p);
						JOptionPane.showMessageDialog(null,p.getCIN()+"deleted succesfully");
					}
					else {
						JOptionPane.showMessageDialog(null,"Professor not found ");
					}
				}
				catch (SQLException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		JButton back=new JButton("return to admin index");
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				JFrame AdminIndexInterface=new JFrame();
				new AdminIndexInterface(currentAdmin);
				
			}
			
		});
		Box box=new Box(BoxLayout.Y_AXIS);
		form.add(fieldCin);
		form.add(delete);
		form.add(back);
		box.add(box.createVerticalGlue());
		box.add(form);
		box.add(box.createVerticalGlue());
		frame.add(box);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(new Dimension(800,800));
		frame.setMinimumSize(frame.getMinimumSize());
		frame.setVisible(true);
	}
	
}
