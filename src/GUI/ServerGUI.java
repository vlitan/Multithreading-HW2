package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Server;
import model.Task;

@SuppressWarnings("serial")
public class ServerGUI extends JPanel{
	private Server server;
	
	public ServerGUI(Server server){
		super();
		this.server = server;
	}
	
	public void paint(int x, int y, int width, int height){
		this.setBounds(x, y, width, height);
		JLabel label = new JLabel();
		label.setText("<html>Server<br>id : " + server.getId() + "<br>task count : " + server.getTasks().size() + "<br>waitingTime : " + server.getWaitingTime()+"</html>");
		label.setBounds(width / 4, height - 200, width, 200);
		label.setFont(new Font("Serif", Font.PLAIN, 17));
		label.setForeground(Color.ORANGE);
		height -= 150;
		label.setVisible(true);
		this.add(label);
		for (int i = 0; i < server.getTasks().size(); i++){
			this.add(new TaskGUI(server.getTasks().get(i), 0, i * height / server.getTasks().size(), width, height / server.getTasks().size() - 10));
		}
		this.setBackground(Color.blue);
		this.setLayout(null);
	}
}
