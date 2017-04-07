package model;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable{
	private BlockingQueue<Task> tasks;
	private AtomicInteger		waitingTime;
	private boolean				began;
	private boolean				closed;
	private int					id;
	private ServerStats			stats;
	
	public Server(int id){
		tasks = new ArrayBlockingQueue<Task>(1024);
		waitingTime = new AtomicInteger();
		waitingTime.set(0);
		began = false;
		closed = false;
		setId(id);
		stats = new ServerStats(this.id);
	}
	
	public void addTask(Task t){		
		stats.incTaskCount();
		stats.setMax(waitingTime.get());
		stats.addToTotalWaitingTime(waitingTime.get());
		waitingTime.set(waitingTime.get() + t.getProcessingTime());
		System.out.println("[Server] task added");
		tasks.add(t);
	}

	public int getWaitingTime(){
		return (waitingTime.get());
	}
	
	@Override
	public void run() {
		while ((tasks.size() > 0) || (!began)){
			try {
				if (tasks.size() > 0){
					began = true;
					System.out.println("[Server " + id +"] tasks count: " + tasks.size());
					Task t = tasks.element();
					processTask(t);
					tasks.remove();
					System.out.println("[Server " + id + "] processed for: " + t.getProcessingTime());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		closed = true;
		System.out.println("[Server " + id + "] closed");
	}
	
	public ServerStats getStats(){
		return (new ServerStats(stats));
	}
	
	public void processTask(Task t) throws InterruptedException{
		while (t.tick()){
			waitingTime.set(waitingTime.get() - Task.TICK_INTERVAL);
		}
	}
	
	public boolean isClosed(){
		return (closed);
	}
	
	public ArrayList<Task> getTasks(){
		return (new ArrayList<Task>(tasks));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
