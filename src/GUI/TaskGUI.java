package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Task;

public class TaskGUI extends JPanel{
	private Task task;
	private JLabel label;
	
	public TaskGUI(Task task, int x, int y, int width, int height){
		super();
		this.setLayout(null);
		this.task = task;
		this.setBackground(Color.black);
		this.setBounds(x, y, width, height);
		label = new JLabel("<html>task<br>id :" + task.getId() + "<br>processingTime : " + task.getProcessingTime() + "</html>");
		label.setFont(new Font("Serif", Font.PLAIN, 17));
		label.setForeground(Color.lightGray);
		label.setBounds(10, 0, width, height);
		this.add(label);
		this.setVisible(true);
	}
	
}
