package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.SettingsGUI;

public class Main {
	
	private static SimulationManager simulator;
	private static Thread simThread;
	private static SettingsGUI settingsGUI;
	
	public static void main(String[] args) {
		simulator = new SimulationManager();
		settingsGUI = new SettingsGUI();
		settingsGUI.init();
		loadDefaultToGUI();
		settingsGUI.setStartListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setFromGUI();
				simulator.init();
				simThread = new Thread(simulator);
				simThread.start();
			}
		});
	}
	
	public static void loadDefaultToGUI(){
		settingsGUI.setDefaultMaxNumberOfServers(simulator.getMaxNumberOfServers());
		settingsGUI.setDefaultMaxProcessingTime(simulator.getMaxProcessingTime());
		settingsGUI.setDefaultMaxUpdateInterval(simulator.getMaxUpdateInterval());
		settingsGUI.setDefaultMinProcessingTime(simulator.getMinProcessingTime());
		settingsGUI.setDefaultMinUpdateInterval(simulator.getMinUpdateInterval());
		settingsGUI.setDefaultNumberOfClients(simulator.getNumberOfClients());
		settingsGUI.setDefaultPolicy(simulator.getPolicy());
		settingsGUI.setDefaultTimeLimit(simulator.getTimeLimit());
		settingsGUI.setDefaultThreshold(simulator.getThreshold());
	}
	
	public static void setFromGUI(){
		simulator.setMaxNumberOfServers(settingsGUI.getMaxNumberOfServers());
		simulator.setMaxProcessingTime(settingsGUI.getMaxProcessingTime());
		simulator.setMaxUpdateInterval(settingsGUI.getMaxUpdateInterval());
		simulator.setMinProcessingTime(settingsGUI.getMinProcessingTime());
		simulator.setMinUpdateInterval(settingsGUI.getMinUpdateInterval());
		simulator.setNumberOfClients(settingsGUI.getNumberOfClients());
		simulator.setPolicy(settingsGUI.getPolicy());
		simulator.setTimeLimit(settingsGUI.getTimeLimit());
		simulator.setThreshold(settingsGUI.getThreshold());
	}
	
}
