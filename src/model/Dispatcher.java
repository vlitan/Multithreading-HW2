package model;

import java.util.ArrayList;


public class Dispatcher {
	private int maxServers;
	private int threshold;
	private ArrayList<Server> servers;
	private ArrayList<ServerStats> stats;
	public Strategy strategy;
	
	public Dispatcher(int maxServers, int tasksPerServerThreshold){
		this.setMaxServers(maxServers);
		this.setThreshold(tasksPerServerThreshold);
		servers = new ArrayList<Server>();
		strategy = new ShortestQueue();
		stats = new ArrayList<ServerStats>();
	}

	public void setStrategy(SelectionPolicy policy, int threshold){
		if (policy == SelectionPolicy.SHORTEST_QUEUE){
			strategy = new ShortestQueue();
			strategy.setThreshold(threshold);
		}
		else if (policy == SelectionPolicy.SHORTEST_TIME){
			strategy = new ShortestTime();
			strategy.setThreshold(threshold);
		}
	}
	
	public void dispatchTask(Task t){
		if (t != null){
			removeClosed();
			strategy.addTask(servers, t, servers.size() < maxServers);
			System.out.println("[Dispatcher] dispached task");
		}
	}
	
	public void removeClosed(){
		for (int i = 0; i < servers.size(); i++){
			if (servers.get(i).isClosed()){
				stats.add(servers.get(i).getStats());
				servers.remove(i);
				System.out.println("[Dispatcher] removed closed server, collected stats");
			}
		}
	}
	
	public boolean isDone(){
		return (servers.isEmpty());
	}
	
	public ArrayList<ServerStats> getStats(){
		return (stats);
	}
	
	public ArrayList<Server> getServers(){
		return (servers);
	}
	
	public int getMaxServers() {
		return maxServers;
	}


	public void setMaxServers(int maxServers) {
		if (maxServers > 0){
			this.maxServers = maxServers;
		}
		else {
			this.maxServers = 0;
		}
	}


	public int getThreshold() {
		return threshold;
	}


	public void setThreshold(int threshold) {
		if (threshold > 0){
			this.threshold = threshold;
		}
		else {
			this.threshold = 0;
		}
	}
}
