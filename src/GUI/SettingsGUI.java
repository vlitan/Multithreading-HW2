package GUI;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.SelectionPolicy;

public class SettingsGUI {
	private JTextField timeLimitTextField;
	private JTextField maxProcessingTimeTextField;
	private JTextField minProcessingTimeTextField;
	private JTextField maxNumberOfServersTextField;
	private JTextField numberOfClientsTextField;
	private JTextField minUpdateIntervalTextField;
	private JTextField maxUpdateIntervalTextField;
	private JTextField policyTextField;
	private JTextField thresholdTextField;
	
	private JLabel timeLimitLabel;
	private JLabel maxProcessingTimeLabel;
	private JLabel minProcessingTimeLabel;
	private JLabel maxNumberOfServersLabel;
	private JLabel numberOfClientsLabel;
	private JLabel minUpdateIntervalLabel;
	private JLabel maxUpdateIntervalLabel;
	private JLabel policyLabel;
	private JLabel thresholdLabel;
	
	private JButton startButton;
	private JFrame mainFrame;
	
	private int width = 600;
	private int height = 400;
	
	public SettingsGUI(){
		timeLimitTextField = new JTextField();
		maxProcessingTimeTextField = new JTextField();
		minProcessingTimeTextField = new JTextField();
		maxNumberOfServersTextField = new JTextField();
		numberOfClientsTextField = new JTextField();
		minUpdateIntervalTextField = new JTextField();
		maxUpdateIntervalTextField = new JTextField();
		policyTextField = new JTextField();
		thresholdTextField = new JTextField();
		thresholdLabel = new JLabel("Threshold of strategy");
		timeLimitLabel = new JLabel("Time limit of simulation");
		maxProcessingTimeLabel = new JLabel("Maximum Processing Time of a task");
		minProcessingTimeLabel = new JLabel("Minimum Processing Time of a task");
		maxNumberOfServersLabel = new JLabel("Maximum Number Of Servers");
		numberOfClientsLabel = new JLabel("Number Of Tasks");
		minUpdateIntervalLabel = new JLabel("Minimum Update Interval");
		maxUpdateIntervalLabel = new JLabel("Maximum Update Interval");
		policyLabel = new JLabel("Strategy for dispatcher");
		startButton = new JButton("Run Simulation");
		mainFrame = new JFrame("Settings");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLayout(null);
		mainFrame.setBounds(0, 0, width, height);
	}
	
	public void setStartListener(ActionListener al){
		startButton.addActionListener(al);
	}
	
	public void init(){
		timeLimitTextField.setBounds(width / 2, 0, width / 2, height / 11 - 10);
		maxProcessingTimeTextField.setBounds(width / 2, height * 1 / 11, width / 2, height / 11 - 10);
		minProcessingTimeTextField.setBounds(width / 2, height * 2 / 11, width / 2, height / 11 - 10);
		maxNumberOfServersTextField.setBounds(width / 2, height * 3 / 11, width / 2, height / 11 - 10);
		numberOfClientsTextField.setBounds(width / 2, height * 4 / 11, width / 2, height / 11 - 10);
		minUpdateIntervalTextField.setBounds(width / 2, height * 5 / 11, width / 2, height / 11 - 10);
		maxUpdateIntervalTextField.setBounds(width / 2, height * 6 / 11, width / 2, height / 11 - 10);
		thresholdTextField.setBounds(width / 2, height * 8 / 11, width / 2, height / 11 - 10);
		thresholdLabel.setBounds(0, height * 8 / 11, width / 2, height / 11 - 10);
		policyTextField.setBounds(width / 2, height * 7 / 11, width / 2, height / 11 - 10);
		timeLimitLabel.setBounds(0, 0, width / 2, height / 11 - 10);
		maxProcessingTimeLabel.setBounds(0, height * 1 / 11, width / 2, height / 11 - 10);
		minProcessingTimeLabel.setBounds(0, height * 2 / 11, width / 2, height / 11 - 10);
		maxNumberOfServersLabel.setBounds(0, height * 3 / 11, width / 2, height / 11 - 10);
		numberOfClientsLabel.setBounds(0, height * 4 / 11, width / 2, height / 11 - 10);
		minUpdateIntervalLabel.setBounds(0, height * 5 / 11, width / 2, height / 11 - 10);
		maxUpdateIntervalLabel.setBounds(0, height * 6 / 11, width / 2, height / 11 - 10);
		policyLabel.setBounds(0, height * 7 / 11, width / 2, height / 11 - 10);
		startButton.setBounds(width / 4, height * 9 / 11 - 5, width / 2, height / 11 - 10);
		
		mainFrame.add(startButton);
		mainFrame.add(timeLimitLabel);
		mainFrame.add(maxProcessingTimeLabel);
		mainFrame.add(minProcessingTimeLabel);
		mainFrame.add(maxNumberOfServersLabel);
		mainFrame.add(numberOfClientsLabel);
		mainFrame.add(minUpdateIntervalLabel);
		mainFrame.add(maxUpdateIntervalLabel);
		mainFrame.add(policyLabel);
		mainFrame.add(thresholdLabel);
		mainFrame.add(timeLimitTextField);
		mainFrame.add(maxProcessingTimeTextField);
		mainFrame.add(minProcessingTimeTextField);
		mainFrame.add(maxNumberOfServersTextField);
		mainFrame.add(numberOfClientsTextField);
		mainFrame.add(minUpdateIntervalTextField);
		mainFrame.add(maxUpdateIntervalTextField);
		mainFrame.add(policyTextField);
		mainFrame.add(thresholdTextField);
		
		mainFrame.setVisible(true);
	}
	
	public int getThreshold(){
		return (Integer.parseInt(thresholdTextField.getText()));
	}
	public void setDefaultThreshold(int threshold){
		thresholdTextField.setText("" + threshold);
	}
	public long getTimeLimit() {
		return Long.parseLong(timeLimitTextField.getText());
	}
	public void setDefaultTimeLimit(long timeLimit) {
		this.timeLimitTextField.setText("" + timeLimit);
	}
	public int getMaxProcessingTime() {
		return Integer.parseInt(maxProcessingTimeTextField.getText());
	}
	public void setDefaultMaxProcessingTime(int maxProcessingTime) {
		this.maxProcessingTimeTextField.setText("" + maxProcessingTime);
	}
	public int getMinProcessingTime() {
		return  Integer.parseInt(minProcessingTimeTextField.getText());
	}
	public void setDefaultMinProcessingTime(int minProcessingTime) {
		this.minProcessingTimeTextField.setText("" + minProcessingTime);
	}
	public int getMaxNumberOfServers() {
		return Integer.parseInt(maxNumberOfServersTextField.getText());
	}
	public void setDefaultMaxNumberOfServers(int maxNumberOfServers) {
		this.maxNumberOfServersTextField.setText("" + maxNumberOfServers);
	}
	public int getNumberOfClients() {
		return Integer.parseInt(numberOfClientsTextField.getText());
	}
	public void setDefaultNumberOfClients(int numberOfClients) {
		this.numberOfClientsTextField.setText("" + numberOfClients);
	}
	public int getMinUpdateInterval() {
		return Integer.parseInt(minUpdateIntervalTextField.getText());
	}
	public void setDefaultMinUpdateInterval(int minUpdateInterval) {
		this.minUpdateIntervalTextField.setText("" + minUpdateInterval);
	}
	public int getMaxUpdateInterval() {
		return Integer.parseInt(maxUpdateIntervalTextField.getText());
	}
	public void setDefaultMaxUpdateInterval(int maxUpdateInterval) {
		this.maxUpdateIntervalTextField.setText("" + maxUpdateInterval);
	}
	public SelectionPolicy getPolicy() {
		if (policyTextField.getText().equals("Time")){
			return SelectionPolicy.SHORTEST_TIME;
		}
		else{
			return SelectionPolicy.SHORTEST_QUEUE;
		}
	}
	public void setDefaultPolicy(SelectionPolicy policy) {
		if (policy == SelectionPolicy.SHORTEST_QUEUE){
			policyTextField.setText("Queue");
		}
		else{
			policyTextField.setText("Time");
		}
	}
}
