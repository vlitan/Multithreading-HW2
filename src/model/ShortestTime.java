package model;
import java.util.ArrayList;

import controller.IDGenerator;

public class ShortestTime implements Strategy {

	private int threshold;
	Thread tr;
	@Override
	public  void addTask(ArrayList<Server> servers, Task t, boolean allowed) {
		System.out.println("[Strategy] choosing server");
		
		Server min;
		if (servers.size() == 0){
			min = new Server(IDGenerator.getNextServerID());
			servers.add(min);
			tr = new Thread(min);
			tr.start();
		}
		else {
			min = servers.get(0);
		}
		
		for (Server server : servers){
			if (server.getWaitingTime() < min.getWaitingTime()){
				min = server;
			}
		}
		
		if ((allowed) && (min.getWaitingTime() >= threshold)){
			min = new Server(IDGenerator.getNextServerID());
			servers.add(min);
			tr = new Thread(min);
			tr.start();
		}
		
		min.addTask(t);
	}

	@Override
	public void setThreshold(int t) {
		// TODO Auto-generated method stub
		threshold = t;
	}

}
