package model;
import java.util.ArrayList;

import controller.IDGenerator;

public class ShortestQueue implements Strategy {

	Thread tr;
	private int threshold;
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
			if (server.getTasks().size() < min.getTasks().size()){
				min = server;
			}
		}
		
		if ((allowed) && (min.getTasks().size() >= threshold)){
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
		threshold  = t;
	}

}
