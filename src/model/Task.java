package model;

public class Task {
	public static final int TICK_INTERVAL = 10;
	private int arrivalTime;
	private int processingTime;
	private int id;
	
	public Task(int processingTime, int id){
		this.setProcessingTime(processingTime);
		this.setId(id);
	}
	
	public int getProcessingTime(){
		return (processingTime);
	}
	
	public void setProcessingTime(int processingTime){
		if (processingTime >= 0){
			this.processingTime = processingTime;
		}
		else{
			this.processingTime = 0;
		}
	}
	
	public void process() throws InterruptedException{
		Thread.sleep(processingTime);
	}

	public boolean tick() throws InterruptedException{
		setProcessingTime(getProcessingTime() - TICK_INTERVAL);
		Thread.sleep(TICK_INTERVAL);
		if (getProcessingTime() >= TICK_INTERVAL){
			return true;
		}
		return false;
	}
	
	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		if (arrivalTime >= 0){
			this.arrivalTime = arrivalTime;
		}
		else{
			this.arrivalTime = 0;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
