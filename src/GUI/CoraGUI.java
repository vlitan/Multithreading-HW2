package GUI;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import model.Server;
import model.ServerStats;

public class CoraGUI {
	private ArrayList<ServerGUI> servers;
	private JFrame window;
	private boolean displayedStats;
	
	public CoraGUI(ArrayList<Server> servers){
		this.servers = new ArrayList<ServerGUI>();
		for(Server server : servers){
			this.servers.add(new ServerGUI(server));
		}
		window = new JFrame("Cora");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(0, 0, 1000, 1000);
		displayedStats = false;
	}
	
	public void init(){
		for (ServerGUI serverGUI : servers){
			window.add(serverGUI);
		}
		window.setVisible(true);
	}
	
	
	public void update(ArrayList<Server> servers){
		if (!displayedStats){
			this.servers = new ArrayList<ServerGUI>();
			window.getContentPane().removeAll();
			for(Server server : servers){
				this.servers.add(new ServerGUI(server));
			}
			for(int i = 0; i < this.servers.size(); i++){
				this.servers.get(i).paint(i * window.getWidth() / this.servers.size(), 0, window.getWidth() / this.servers.size() - 10 , window.getHeight());
			}
			for (ServerGUI serverGUI : this.servers){
				window.add(serverGUI);
			}
			window.getContentPane().setLayout(null);
			window.setTitle(this.servers.size() + " active serversGUI");
			window.revalidate();
			window.repaint();
		}
	}

	public void displayStats(ArrayList<ServerStats> stats) {
		if (!displayedStats){
			displayedStats = true;
			window.getContentPane().removeAll();
			ArrayList<JLabel> labels = new ArrayList<JLabel>();
			for (int i = 0; i < stats.size(); i++){
				labels.add(new JLabel(stats.get(i).toFormatedString()));
				labels.get(i).setBounds(0, i * window.getHeight() / stats.size(), window.getWidth(), window.getHeight() / stats.size() - 10);
				labels.get(i).setFont(new Font("Serif", Font.PLAIN, 17));
				window.add(labels.get(i));
			}
			window.getContentPane().setLayout(null);
			window.setTitle(this.servers.size() + " active serversGUI");
			window.revalidate();
			window.repaint();
		}
	}
}
