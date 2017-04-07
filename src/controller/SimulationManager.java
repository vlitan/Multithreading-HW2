package controller;


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JTextField;

import GUI.CoraGUI;
import model.Dispatcher;
import model.SelectionPolicy;
import model.Task;
import model.TaskGenerator;

public class SimulationManager implements Runnable {

	private int updateInterval = 1000; //milliseconds 
	private long lastNow = 0;
	
	private long timeLimit = 100000;
	private int maxProcessingTime = 10000;
	private int minProcessingTime = 1000;


	private int maxNumberOfServers = 2;
	private int numberOfClients = 10;
	private int minUpdateInterval = 1000;
	private int maxUpdateInterval = 2000;
	private int threshold = 3;
	private SelectionPolicy policy = SelectionPolicy.SHORTEST_QUEUE;

	private Dispatcher	dispatcher;
	private Queue<Task> tasks;
	private CoraGUI gui;

	public void init(){
		dispatcher = new Dispatcher(maxNumberOfServers, numberOfClients);
		dispatcher.setStrategy(policy, threshold);
		tasks = new ArrayDeque<Task>(numberOfClients + 1);
		for (int i = 0; i < numberOfClients; i++){
			tasks.add(TaskGenerator.instance().getNext(minProcessingTime, maxProcessingTime));
		}
		System.out.println("[SimulationManager] created");
		gui = new CoraGUI(dispatcher.getServers());
	}
	
	public int getThreshold() {
		return threshold;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

	@Override
	public void run() {
		gui.init();
		timeLimit += now();
		System.out.println("[SimulationManager] started");
		Timer t = new Timer();
		t.schedule(new TimerTask(){
			@Override
			public void run() {
				dispatcher.removeClosed();
				gui.update(dispatcher.getServers());
			}}, 0, 30);
		while (now() < timeLimit){
				updateInterval = minUpdateInterval + (new Random()).nextInt(maxUpdateInterval - minUpdateInterval);
				if(delay(now(), updateInterval)){
					dispatcher.dispatchTask(tasks.poll());
					System.out.println("[SimulationManager] tick");
				}
				if (dispatcher.isDone() && tasks.isEmpty()){
					gui.displayStats(dispatcher.getStats());
				}
		}
		System.out.println("[SimulationManager] ended");
	}
	
	   public long now(){
		   return (System.currentTimeMillis() % Long.MAX_VALUE);
	   }
	   
	   private boolean delay(long now, int deltaT){
		   	if (now < lastNow){
				lastNow = Long.MAX_VALUE - lastNow + now;
			}
			if (now - lastNow > deltaT){
				lastNow = now;
				return true;
			}
			else 
				return false;
	  }

	public int getMinProcessingTime() {
		return minProcessingTime;
	}

	public void setMinProcessingTime(int minProcessingTime) {
		this.minProcessingTime = minProcessingTime;
	}
	   
	public long getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(long timeLimit) {
		this.timeLimit = timeLimit;
	}

	public int getMaxProcessingTime() {
		return maxProcessingTime;
	}

	public void setMaxProcessingTime(int maxProcessingTime) {
		this.maxProcessingTime = maxProcessingTime;
	}

	public int getMaxNumberOfServers() {
		return maxNumberOfServers;
	}

	public void setMaxNumberOfServers(int maxNumberOfServers) {
		this.maxNumberOfServers = maxNumberOfServers;
	}

	public int getNumberOfClients() {
		return numberOfClients;
	}

	public void setNumberOfClients(int numberOfClients) {
		this.numberOfClients = numberOfClients;
	}

	public int getMinUpdateInterval() {
		return minUpdateInterval;
	}

	public void setMinUpdateInterval(int minUpdateInterval) {
		this.minUpdateInterval = minUpdateInterval;
	}

	public int getMaxUpdateInterval() {
		return maxUpdateInterval;
	}

	public void setMaxUpdateInterval(int maxUpdateInterval) {
		this.maxUpdateInterval = maxUpdateInterval;
	}

	public SelectionPolicy getPolicy() {
		return policy;
	}

	public void setPolicy(SelectionPolicy policy) {
		this.policy = policy;
	}

}
